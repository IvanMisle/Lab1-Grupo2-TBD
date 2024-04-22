--Función que retorna la cantidad de tareas activas de una emeregencia
CREATE OR REPLACE FUNCTION getActiveTasksByIdEmergency(emergency_id BIGINT) 
RETURNS INT AS $$
DECLARE 
	numberActiveTasks INT;
BEGIN 
	SELECT COUNT(*)
	INTO numberActiveTasks
	FROM task t
	INNER JOIN task_state ts ON ts.id = t.id_task_state
	WHERE t.id_emergency = emergency_id AND
	ts.state = true;
	
	RETURN numberActiveTasks;
END;
$$ LANGUAGE plpgsql;

-- Función del trigger para almacenar información dependiendo de la acción realizada
CREATE OR REPLACE FUNCTION log_function() RETURNS TRIGGER AS
$$
DECLARE
    query_c TEXT;
    user_c VARCHAR(255) := User;
    date_c DATE := current_date;
    time_c TIME := current_time;
BEGIN
    -- Excluir la tabla log_table para evitar un bucle en el cual se llama así mismo (overflow en el stack)
    IF TG_TABLE_NAME = 'log_table' THEN
        RETURN NEW;
    END IF;

    SELECT current_query() INTO query_c;
    
    -- Se obtiene la tabla y la acción que se realiza
    IF (TG_OP = 'INSERT') THEN
        INSERT INTO log_table (table_c, action_c, user_c, date_c, time_c, query_c)
        VALUES (TG_TABLE_NAME, 'INSERT', user_c, date_c, time_c, query_c);
    ELSIF (TG_OP = 'UPDATE') THEN
        INSERT INTO log_table (table_c, action_c, user_c, date_c, time_c, query_c)
        VALUES (TG_TABLE_NAME, 'UPDATE', user_c, date_c, time_c, query_c);
    ELSIF (TG_OP = 'DELETE') THEN
        INSERT INTO log_table (table_c, action_c, user_c, date_c, time_c, query_c)
        VALUES (TG_TABLE_NAME, 'DELETE', user_c, date_c, time_c, query_c);
    END IF;

    RETURN NEW;
END
$$
LANGUAGE plpgsql;

-- Crear un trigger para cada tabla existente en la base de datos
DO $$ 
DECLARE 
    r RECORD; 
BEGIN 
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'public') 
    LOOP 
        EXECUTE format('CREATE TRIGGER trigger_log_%1$s AFTER INSERT OR UPDATE OR DELETE ON %1$s FOR EACH STATEMENT EXECUTE FUNCTION log_function()', r.tablename); 
    END LOOP; 
END $$;



