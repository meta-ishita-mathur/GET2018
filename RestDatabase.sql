CREATE DATABASE rest;

USE rest;

CREATE TABLE category
(   
    id INT AUTO_INCREMENT,
    category_name VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE advertisement
(   
    id INT AUTO_INCREMENT,
    title VARCHAR(30),
    description VARCHAR(500),
    category_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(category_id) REFERENCES category(id)
);