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