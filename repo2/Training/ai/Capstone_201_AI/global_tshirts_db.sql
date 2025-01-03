-- Create the database
CREATE DATABASE global_tshirts;
USE global_tshirts;

-- Create the t_shirts table
CREATE TABLE t_shirts (
    t_shirt_id INT AUTO_INCREMENT PRIMARY KEY,
    brand ENUM('Van Huesen', 'Levi', 'Nike', 'Adidas') NOT NULL,
    color ENUM('Red', 'Blue', 'Black', 'White') NOT NULL,
    size ENUM('XS', 'S', 'M', 'L', 'XL') NOT NULL,
    price INT CHECK (price BETWEEN 10 AND 50),
    stock_quantity INT NOT NULL,
    UNIQUE KEY brand_color_size (brand, color, size)
);

-- Create the discounts table
CREATE TABLE discounts (
    discount_id INT AUTO_INCREMENT PRIMARY KEY,
    t_shirt_id INT NOT NULL,
    pct_discount DECIMAL(5,2) CHECK (pct_discount BETWEEN 0 AND 100),
    FOREIGN KEY (t_shirt_id) REFERENCES t_shirts(t_shirt_id)
);

-- Insert some sample data
INSERT INTO t_shirts (brand, color, size, price, stock_quantity)
VALUES ('Nike', 'White', 'XS', 25, 91),
       ('Adidas', 'Red', 'S', 30, 45);

-- Insert discounts
INSERT INTO discounts (t_shirt_id, pct_discount)
VALUES (1, 10.00), (2, 15.00);
