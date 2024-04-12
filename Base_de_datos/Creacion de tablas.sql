-- Crear tabla ranking
CREATE TABLE Ranking (
    id INT PRIMARY KEY,
    id_task INT,
    id_volunteer INT,
    level_ranking INT,
    FOREIGN KEY (id_task) REFERENCES task(id),
    FOREIGN KEY (id_volunteer) REFERENCES volunteer(id)
);

-- Crear tabla institution
CREATE TABLE Institution (
    id INT PRIMARY KEY,
    name TEXT
);

-- Crear tabla volunteer
CREATE TABLE Volunteer (
    id INT PRIMARY KEY,
    disponibility BOOLEAN,
    name TEXT,
    password TEXT,
    age INT
);

-- Crear tabla vol_abillity
CREATE TABLE VolAbillity (
    id INT PRIMARY KEY,
    id_volunteer INT,
    id_ability INT,
    FOREIGN KEY (id_volunteer) REFERENCES volunteer(id),
    FOREIGN KEY (id_ability) REFERENCES abillity(id)
);

-- Crear tabla emergency
CREATE TABLE Emergency (
    id INT PRIMARY KEY,
    id_institution INT,
    status BOOLEAN,
    name TEXT,
    description TEXT,
    coordinator_responsible TEXT,
    FOREIGN KEY (id_institution) REFERENCES institution(id)
);

-- Crear tabla eme_abillity
CREATE TABLE EmeAbillity (
    id INT PRIMARY KEY,
    id_emergency INT,
    id_ability INT,
    FOREIGN KEY (id_emergency) REFERENCES emergency(id),
    FOREIGN KEY (id_ability) REFERENCES abillity(id)
);

-- Crear tabla abillity
CREATE TABLE Abillity (
    id INT PRIMARY KEY,
    name TEXT
);

-- Crear tabla task
CREATE TABLE Task (
    id INT PRIMARY KEY,
    name_task TEXT,
    description TEXT,
    id_emergency INT,
    id_status_task INT,
    FOREIGN KEY (id_emergency) REFERENCES emergency(id),
    FOREIGN KEY (id_status_task) REFERENCES task_status(id)
);

-- Crear tabla task_abillity
CREATE TABLE TaskAbillity (
    id INT PRIMARY KEY,
    id_eme_abillity INT,
    id_task INT,
    FOREIGN KEY (id_eme_abillity) REFERENCES eme_abillity(id),
    FOREIGN KEY (id_task) REFERENCES task(id)
);