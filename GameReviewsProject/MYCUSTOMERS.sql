-- Create the customer table
CREATE TABLE IF NOT EXISTS customer (
    cus_code INTEGER PRIMARY KEY,
    cus_lname VARCHAR(20),
    cus_fname VARCHAR(20),
    cus_initial CHAR(1),
    cus_areacode INTEGER,
    cus_phone INTEGER 
);

-- Create the vendor table
CREATE TABLE IF NOT EXISTS vendor (
    vend_code INTEGER PRIMARY KEY,
    vend_name VARCHAR(30),
    vend_contact VARCHAR(30),
    vend_areacode INTEGER,
    vend_phone INTEGER 
);

-- Create the product table
CREATE TABLE IF NOT EXISTS product (
    prod_code INTEGER PRIMARY KEY,
    prod_desc VARCHAR(50),
    prod_price INTEGER,
    prod_quant INTEGER,
    vend_code INTEGER,
    FOREIGN KEY (vend_code) REFERENCES vendor(vend_code) 
);

-- Create the invoice table
CREATE TABLE IF NOT EXISTS invoice (
    inv_number INTEGER PRIMARY KEY,
    cus_code INTEGER,
    inv_date DATE,
    FOREIGN KEY (cus_code) REFERENCES customer(cus_code) 
);

-- Create the line table
CREATE TABLE IF NOT EXISTS line (
    inv_number INTEGER,
    prod_code INTEGER,
    line_units INTEGER,
    PRIMARY KEY (inv_number, prod_code),
    FOREIGN KEY (inv_number) REFERENCES invoice(inv_number),
    FOREIGN KEY (prod_code) REFERENCES product(prod_code) 
);

-- Insert data into the customer table with error handling
BEGIN;
INSERT INTO customer (cus_code, cus_lname, cus_fname, cus_initial, cus_areacode, cus_phone) VALUES
(10010, 'Ramas', 'Paul', 'A', 615, 8442573),
(10011, 'Dunne', 'Leona', 'K', 713, 8941238),
(10012, 'Smith', 'Kathy', 'W', 615, 8942285),
(10013, 'Olowski', 'Paul', 'F', 615, 2221672),
(10014, 'Orlando', 'Myron', NULL, 615, 2971228);
COMMIT;

-- Insert data into the invoice table with error handling
BEGIN;
INSERT INTO invoice (inv_number, cus_code, inv_date) VALUES
(1001, 10011, '2018-01-03'),
(1002, 10014, '2016-08-04'),
(1003, 10012, '2017-03-20'),
(1004, 10014, '2018-01-13');
COMMIT;

-- Insert data into the line table with error handling
BEGIN;
INSERT INTO line (inv_number, prod_code, line_units) VALUES
(1001, 12321, 1),
(1001, 65781, 3),
(1003, 83456, 2),
(1002, 34256, 6),
(1003, 12321, 5),
(1002, 12321, 6),
(1001, 83456, 3);
COMMIT;

-- Insert data into the product table with error handling
BEGIN;
INSERT INTO product (prod_code, prod_desc, prod_price, prod_quant, vend_code) VALUES
(12321, 'hammer', 189, 20, 232),
(65781, 'chain', 12, 45, 235),
(34256, 'tape', 35, 60, 235),
(83456, 'saw', 165, 15, 236),
(12333, 'hanger', 200, 10, 232);
COMMIT;

-- Insert data into the vendor table with error handling
BEGIN;
INSERT INTO vendor (vend_code, vend_name, vend_contact, vend_areacode, vend_phone) VALUES
(232, 'Bryson', 'Smith', 615, 2233234),
(235, 'SuperLoo', 'Anderson', 615, 2158995),
(236, 'Brett', 'Manko', 612, 3458695);
COMMIT;

-- Select statement with error handling
BEGIN;
SELECT * FROM customer;
COMMIT;
