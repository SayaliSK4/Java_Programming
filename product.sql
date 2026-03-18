
CREATE DATABASE productdb;
use productdb;
CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    product_price DOUBLE
);

-- Insert Data
INSERT INTO product1 (product_name, product_price) VALUES
('Milk', 50),
('Butter', 120),
('Cheese', 250);

       
