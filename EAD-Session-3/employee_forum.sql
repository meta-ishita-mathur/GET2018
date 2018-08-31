CREATE DATABASE employee_forum;
USE employee_forum;
CREATE TABLE Employees(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(200) NOT NULL,
    lastName VARCHAR(200) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,
    age INT NOT NULL
);
INSERT INTO Employees(firstName, lastName, email, age) 
VALUES ("ishita", "mathur", "ishita.mathur@gmail.com", 21);

SELECT * FROM Employees;