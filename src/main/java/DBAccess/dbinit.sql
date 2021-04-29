CREATE DATABASE IF NOT EXISTS cupcake;
use cupcake;

DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS bottoms;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS posts;

CREATE TABLE posts
(
  postID int(8) NOT NULL AUTO_INCREMENT,
  category varchar(90) NOT NULL,
  content TEXT NOT NULL,
  author varchar(40) NOT NULL,
  filePath varchar(150) NOT NULL,
  created TIMESTAMP default current_timestamp,
  PRIMARY KEY (postID)
);

CREATE TABLE categories
(
  category varchar(100) NOT NULL,
  PRIMARY KEY (category)
);

CREATE TABLE users
(
  userID int(4) NOT NULL AUTO_INCREMENT,
  email varchar(40) NOT NULL,
  password varchar(12) NOT NULL,
  role varchar(8) NOT NULL ,
  balance double,
  PRIMARY KEY (userID)
);

CREATE TABLE bottoms
(
    bottomID          int(3)       NOT NULL AUTO_INCREMENT,
    name        varchar(255) NOT NULL,
    price       double,
    PRIMARY KEY (bottomID)
);

CREATE TABLE toppings
(
    topID          int(3)       NOT NULL AUTO_INCREMENT,
    name        varchar(255) NOT NULL,
    price       double,
    PRIMARY KEY (topID)
);

CREATE TABLE orders
(
    orderID    int(7) NOT NULL auto_increment,
    userID int (4) NOT NULL ,
    price      double,
    timest TIMESTAMP default current_timestamp ,
    PRIMARY KEY (orderID),
    FOREIGN KEY (userID) REFERENCES users(userID)
);

CREATE TABLE items
(
    itemID int(4) NOT NULL auto_increment,
    orderID int(7) NOT NULL,
    topID     int(3) NOT NULL,
    bottomID  int(3) NOT NULL,
    quantity  int(2) NOT NULL,
    PRIMARY KEY (itemID),
    FOREIGN KEY (orderID) REFERENCES orders(orderID),
    FOREIGN KEY (bottomID) REFERENCES bottoms(bottomID),
    FOREIGN KEY (topID) REFERENCES toppings(topID)

);

INSERT INTO users (email,password, role,balance) VALUES ('email1@gmail.com', 'test1', 'customer', '150.00');
INSERT INTO users (email,password, role, balance) VALUES ('email2@gmail.com', 'test2', 'customer', '100.00');
INSERT INTO users (email,password, role, balance) VALUES ('email3@gmail.com', 'test3', 'customer', '25.00');

INSERT INTO users (email,password, role) VALUES ('email4@gmail.com', 'test4', 'employee');
INSERT INTO users (email,password, role) VALUES ('email5@gmail.com', 'test5', 'employee');


INSERT INTO bottoms (name, price) VALUES ('Chocolate', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Vanilla', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Nutmeg', 5.00);
INSERT INTO bottoms (name, price) VALUES ('Pistacio', 6.00);
INSERT INTO bottoms (name, price) VALUES ('Almond', 7.00);

INSERT INTO toppings (name, price) VALUES ('Chocolate', 5.00);
INSERT INTO toppings (name, price) VALUES ('Blueberry', 5.00);
INSERT INTO toppings (name, price) VALUES ('Raspberry', 5.00);
INSERT INTO toppings (name, price) VALUES ('Crispy', 6.00);
INSERT INTO toppings (name, price) VALUES ('Strawberry', 6.00);
INSERT INTO toppings (name, price) VALUES ('Rum/Raisin', 7.00);
INSERT INTO toppings (name, price) VALUES ('Orange', 8.00);
INSERT INTO toppings (name, price) VALUES ('Lemon', 8.00);
INSERT INTO toppings (name, price) VALUES ('Blue Cheese', 9.00);

INSERT INTO orders (userID, price) VALUES (2,26.00);

INSERT INTO items (orderID, topID, bottomID, quantity) VALUES (1,1,1,1);
INSERT INTO items (orderID, topID, bottomID, quantity) VALUES (1,9,5,1);

INSERT INTO categories (category) VALUES ("Generelt");
INSERT INTO categories (category) VALUES ("Salg af udstyr");



