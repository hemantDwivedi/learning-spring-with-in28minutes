INSERT INTO user_details(id, birth_date, name)
VALUES(100, current_date(), 'Hemant');
INSERT INTO user_details(id, birth_date, name)
VALUES(101, current_date(), 'sam');
INSERT INTO user_details(id, birth_date, name)
VALUES(102, current_date(), 'bob');
INSERT INTO user_details(id, birth_date, name)
VALUES(103, current_date(), 'Josh');

INSERT INTO post(id, description, user_id)
VALUES(10001, 'learn devops', 100);
INSERT INTO post(id, description, user_id)
VALUES(10002, 'learn spring boot 3', 101);
INSERT INTO post(id, description, user_id)
VALUES(10003, 'learn microservices', 102);
INSERT INTO post(id, description, user_id)
VALUES(10004, 'learn aws', 103);