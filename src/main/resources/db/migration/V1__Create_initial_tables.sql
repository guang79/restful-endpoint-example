-- department table
CREATE TABLE IF NOT EXISTS department
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);


-- employee table
CREATE TABLE IF NOT EXISTS employee
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    salary NUMERIC(20, 2),
    department_id BIGINT NOT NULL,
    job_title VARCHAR(100),
    is_current BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(id)
);
