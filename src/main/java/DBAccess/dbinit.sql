CREATE DATABASE IF NOT EXISTS forum;
use forum;

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
  email varchar(40) NOT NULL,
  password varchar(100) NOT NULL,
  role varchar(8) NOT NULL ,
  PRIMARY KEY (email)
);

INSERT INTO categories (category) VALUES ("Generelt");
INSERT INTO categories (category) VALUES ("Salg af udstyr");