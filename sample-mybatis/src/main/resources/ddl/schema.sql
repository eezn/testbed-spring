CREATE TABLE companyEntity (
    id INT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255) NULL,
    company_address VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    company_id INT NULL,
    employee_name VARCHAR(255) NULL,
    employee_address VARCHAR(255) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES companyEntity(id)
);
