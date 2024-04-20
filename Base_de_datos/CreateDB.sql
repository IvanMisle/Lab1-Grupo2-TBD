-- Crear tabla institution
CREATE TABLE Institution (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
);

-- Crear tabla emergency
CREATE TABLE Emergency (
    id BIGSERIAL PRIMARY KEY,
    id_institution BIGINT,
    state BOOLEAN,
    name TEXT,
    description TEXT,
    responsible_coordinator TEXT,
    FOREIGN KEY (id_institution) REFERENCES institution(id)
);

-- Crear tabla task_state
CREATE TABLE Task_state (
    id BIGSERIAL PRIMARY KEY,
	state bool
);

-- Crear tabla task
CREATE TABLE Task (
    id BIGSERIAL PRIMARY KEY,
    name_task TEXT,
    description TEXT,
    id_emergency BIGINT,
    id_task_state BIGINT,
    FOREIGN KEY (id_emergency) REFERENCES emergency(id),
    FOREIGN KEY (id_task_state) REFERENCES task_state(id)
);

-- Crear tabla volunteer
CREATE TABLE Volunteer (
    id BIGSERIAL PRIMARY KEY,
    availability BOOLEAN,
    name TEXT,
    password TEXT,
    age INT
);

-- Crear tabla ranking
CREATE TABLE Ranking (
    id BIGSERIAL PRIMARY KEY,
    id_task BIGINT,
    id_volunteer BIGINT,
    level_ranking INT,
    FOREIGN KEY (id_task) REFERENCES task(id),
    FOREIGN KEY (id_volunteer) REFERENCES volunteer(id)
);

-- Crear tabla ability
CREATE TABLE Ability (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
);

-- Crear tabla vol_ability
CREATE TABLE Vol_Ability (
    id BIGSERIAL PRIMARY KEY,
    id_volunteer BIGINT,
    id_ability BIGINT,
    FOREIGN KEY (id_volunteer) REFERENCES volunteer(id),
    FOREIGN KEY (id_ability) REFERENCES ability(id)
);

-- Crear tabla eme_ability
CREATE TABLE Eme_Ability (
    id BIGSERIAL PRIMARY KEY,
    id_emergency BIGINT,
    id_ability BIGINT,
    FOREIGN KEY (id_emergency) REFERENCES emergency(id),
    FOREIGN KEY (id_ability) REFERENCES ability(id)
);

-- Crear tabla task_ability
CREATE TABLE Task_Ability (
    id BIGSERIAL PRIMARY KEY,
    id_eme_ability BIGINT,
    id_task BIGINT,
    FOREIGN KEY (id_eme_ability) REFERENCES eme_ability(id),
    FOREIGN KEY (id_task) REFERENCES task(id)
);

-- Crear tabla log_table
CREATE TABLE log_table (
    id SERIAL PRIMARY KEY,
    table_c VARCHAR(255) NOT NULL,
    action_c VARCHAR(10) NOT NULL,
    user_c VARCHAR(255) NOT NULL,
    date_c date NOT NULL,
	time_c time NOT NULL,
    query_c TEXT NOT NULL
);