CREATE DATABASE IF NOT EXISTS wishlist;
USE wishlist;

-- Create Users table
CREATE TABLE IF NOT EXISTS users (
 user_id                 INT				NOT NULL		PRIMARY KEY		AUTO_INCREMENT,
 first_name				VARCHAR(255)	NOT NULL,
 last_name				VARCHAR(255)	NOT NULL,
 email					VARCHAR(255)	NOT NULL,
 authentication_code		VARCHAR(255)	NOT NULL
);

-- Create Wishlists table
CREATE TABLE IF NOT EXISTS wishlists (
 wishlist_id				INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
 user_id					INT				NOT NULL,
 wishlist_name			VARCHAR(255)	NOT NULL,
 FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Create Products table
CREATE TABLE IF NOT EXISTS products (
product_id			 	INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
product_name			VARCHAR(255)	NOT NULL,
product_description		VARCHAR(255),
price					DOUBLE(10,2)	NOT NULL
);

-- Create Wishes table
CREATE TABLE IF NOT EXISTS wishes (
  wishlist_id				INT				NOT NULL,
  product_id				INT				NOT NULL,
  quantity				INT(10)			NOT NULL,
  FOREIGN KEY (wishlist_id) 	REFERENCES wishlists(wishlist_id),
  FOREIGN KEY (product_id) 	REFERENCES products(product_id)
);


-- DATA INSERT --
-- Insert users
INSERT INTO users (first_name, last_name, email, authentication_code)
VALUES
    ('Ib', 'Olsen', 'ibolsen@gmail.com', 'test'),
    ('Jakob', 'Madsen', 'jmadsen@gmail.com', 'test2');

-- Insert Wishlists
INSERT INTO wishlists (user_id, wishlist_name)
VALUES
    (1, 'Ønskelisten'),
    (2, 'Julegaver');

-- Insert Products
INSERT INTO products (product_name, product_description, price)
VALUES
    ('Macbook Air', 'M2 Version', 11999.95),
    ('1000 V-Bucks Gift Card', 'Fortnite', 50.00),
    ('Karambit: Fade', 'CS2', 10000.00);

-- Insert Wishes
INSERT INTO wishes (wishlist_id, product_id, quantity)
VALUES
    (1, 1, 1),
    (1, 2, 2),
    (2, 3, 1);