CREATE TABLE measures (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    value DOUBLE PRECISION,
    measured_at timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);