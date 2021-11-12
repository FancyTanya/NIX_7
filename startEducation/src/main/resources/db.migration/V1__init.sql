CREATE TABLE students (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name varchar(50) NULL,
  last_name varchar(50) NULL,
  email varchar(50) NULL,
  password varchar(240) NULL
  `role` enum('teacher,student') NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8_unicode_ci';

CREATE TABLE `teachers` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(50) NULL,
  `last_name` varchar(50) NULL,
  `email` varchar(50) NULL,
  `password` varchar(240) NULL,
  `role` enum('teacher,student') NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8mb4_unicode_ci';

CREATE TABLE `grades` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `grade` int NULL
) ENGINE='InnoDB' COLLATE 'utf8_unicode_ci';

CREATE TABLE `topics` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) NULL
) ENGINE='InnoDB' COLLATE 'utf8mb4_unicode_ci';

CREATE TABLE `lessons` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(50) NULL,
  `date` timestamp NOT NULL,
  `is_complete` enum('0','1') NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8mb4_unicode_ci';