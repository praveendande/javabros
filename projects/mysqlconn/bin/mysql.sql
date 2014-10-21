/* use database */
use test;


/* Create table customer */
CREATE TABLE customer (
  c_id INT NOT NULL AUTO_INCREMENT,
  c_fname VARCHAR(45) NOT NULL,
  c_lname VARCHAR(45) NOT NULL,
  c_city VARCHAR(45) NOT NULL,
  c_zipcode INT NOT NULL,
PRIMARY KEY (c_id));

/* Inserting rows into the table */
INSERT INTO customer (c_fname, c_lname, c_city, c_zipcode) VALUES ('lei', 'yuan', 'indianapolis', 46268);
INSERT INTO customer (c_fname, c_lname, c_city, c_zipcode) VALUES ('sachi', 'mishra', 'new york', 96543);
INSERT INTO customer (c_fname, c_lname, c_city, c_zipcode) VALUES ('john', 'bino', 'dallas', 12345);
INSERT INTO customer (c_fname, c_lname, c_city, c_zipcode) VALUES ('kumar', 'yarley', 'bloomington', 43122);

/* Listing all customers */
SELECT * 
FROM customer;


/* Deleting a row based on constraint */
DELETE 
FROM customer 
where c_id=1;

/* Update customer */
UPDATE customer 
set c_city='City Changed' 
where c_id=2;

/* Drop Customer table */
DROP table customer;