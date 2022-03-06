DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS disbursement;

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT UNIQUE,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `created_dt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE `payment` (
  `payment_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `is_disbursed` tinyint(1) NOT NULL DEFAULT '0',
  `card_info` varchar(100) NOT NULL,
  `created_dt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
);

CREATE TABLE `disbursement` (
  `disbursement_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `created_dt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`disbursement_id`)
);