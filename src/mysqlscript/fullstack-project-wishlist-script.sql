CREATE DATABASE IF NOT EXISTS fullstack_project_wishlist;
USE fullstack_project_wishlist;

-- Create Users table
CREATE TABLE IF NOT EXISTS user (
    user_id                 INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
    first_name				VARCHAR(30)		NOT NULL,
    last_name				VARCHAR(30)		NOT NULL,
    email					VARCHAR(30)		NOT NULL,
    user_password			VARCHAR(20)		NOT NULL
);

-- Create Wishlists table
CREATE TABLE IF NOT EXISTS wishlist (
    wishlist_id				INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
    user_id					INT				NOT NULL,
    wishlist_name			VARCHAR(20)		NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);

-- Create Wish table
CREATE TABLE IF NOT EXISTS wish (
    wish_id				 	INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
    wishlist_id				INT				NOT NULL,
    wish_name				VARCHAR(20)		NOT NULL,
    wish_description		VARCHAR(30),
    price					DOUBLE			NOT NULL,
    FOREIGN KEY (wishlist_id) REFERENCES wishlist(wishlist_id) ON DELETE CASCADE
);

-- DATA INSERT --
-- Insert users
INSERT INTO user (first_name, last_name, email, user_password)
VALUES
    ('Ib', 'Olsen', 'ibolsen@gmail.com', 'test'),
    ('Jakob', 'Madsen', 'jmadsen@gmail.com', 'test');

-- Insert Wishlists
INSERT INTO wishlist (user_id, wishlist_name)
VALUES
    (1, 'Ønskelisten'),
    (2, 'Julegaver');

-- Insert Wishes
INSERT INTO wish (wishlist_id, wish_name, wish_description, price)
VALUES
    (1, 'Macbook Air', 'M2 Version', 11999.95),
    (1, '1000 V-Bucks', 'Fortnite', 50.00),
    (2, 'Karambit: Fade', 'CS2', 10000.00);
