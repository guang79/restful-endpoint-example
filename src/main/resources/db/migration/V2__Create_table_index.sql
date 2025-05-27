-- department index
CREATE INDEX IF NOT EXISTS idx_department_name ON department(name);


-- employee index
CREATE INDEX IF NOT EXISTS idx_employee_email ON employee(email);
CREATE INDEX IF NOT EXISTS idx_employee_phone_number ON employee(phone_number);
CREATE INDEX IF NOT EXISTS idx_employee_department_id ON employee(department_id);

