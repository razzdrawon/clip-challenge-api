------------------------------------
--User table
------------------------------------
INSERT INTO user(user_id,first_name,last_name,created_dt) VALUES (1,'Ricardo Axel','Padilla Gonzalez','2022-03-05 00:00:00');
INSERT INTO user(user_id,first_name,last_name,created_dt) VALUES (2,'User','Test','2022-03-05 00:00:00');
INSERT INTO user(user_id,first_name,last_name,created_dt) VALUES (3,'First','Last','2022-03-05 00:00:00');

------------------------------------
--Payment table
------------------------------------
INSERT INTO payment(payment_id,amount,user_id,is_disbursed,card_info,created_dt) VALUES (1,192.2345,1,false,'CardInfo1','2022-03-05 00:00:00');
INSERT INTO payment(payment_id,amount,user_id,is_disbursed,card_info,created_dt) VALUES (2,307.8,1,false,'CardInfo2','2022-03-05 00:00:00');
INSERT INTO payment(payment_id,amount,user_id,is_disbursed,card_info,created_dt) VALUES (3,1500,1,false,'CardInfo3','2022-03-05 00:00:00');
INSERT INTO payment(payment_id,amount,user_id,is_disbursed,card_info,created_dt) VALUES (4,400,1,false,'CardInfo3','2022-03-05 00:00:00');
INSERT INTO payment(payment_id,amount,user_id,is_disbursed,card_info,created_dt) VALUES (5,9034.7534,1,false,'CardInfo3','2022-03-05 00:00:00');

--Disbursement
INSERT INTO disbursement(disbursement_id,amount_payment,amount_disbursement,user_id,created_dt) VALUES (1,100,96.5,1,'2022-03-05 00:00:00');