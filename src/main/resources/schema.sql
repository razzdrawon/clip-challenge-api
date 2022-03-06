DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS payment;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT UNIQUE,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `payment` (
  `payment_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`payment_id`)
);