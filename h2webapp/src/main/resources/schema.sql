DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer(
  id NUMERIC IDENTITY PRIMARY KEY,
  first_name VARCHAR(512) NOT NULL,
  last_name VARCHAR(512) NOT NULL,
  date_of_birth TIMESTAMP NOT NULL,
  username VARCHAR(512) NOT NULL,
  password VARCHAR(60) NOT NULL
);