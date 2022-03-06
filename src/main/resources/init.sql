------------------------------------
--User table
------------------------------------
INSERT INTO user(user_id,first_name,last_name) VALUES (1,'Ricardo Axel','Padilla Gonzalez');
INSERT INTO user(user_id,first_name,last_name) VALUES (2,'User','Test');
INSERT INTO user(user_id,first_name,last_name) VALUES (3,'First','Last');


------------------------------------
--Payment table
------------------------------------
INSERT INTO payment(payment_id,user_id,amount) VALUES (1,3,1.2345);
INSERT INTO payment(payment_id,user_id,amount) VALUES (2,3,30.8);
INSERT INTO payment(payment_id,user_id,amount) VALUES (3,3,1000);