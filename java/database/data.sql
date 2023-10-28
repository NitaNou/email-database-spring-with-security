BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO department (id, dept_name) VALUES (1, 'Wonkavator');
INSERT INTO department (id, dept_name) VALUES (2, 'Chocolate');
INSERT INTO department (id, dept_name) VALUES (3, 'Fizzy-Lifting-Drink');
INSERT INTO department (id, dept_name) VALUES (4, 'None');

INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Charlie', 'Bucket', 1);
INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Veruca', 'Salt', 4);
INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Augustus', 'Gloop', 2);
INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Grandpa', 'Joe', 3);
INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Violet', 'Beauregarde', 4);
INSERT INTO prospect_employee (first_name, last_name, prospect_dept_id) VALUES ('Mike', 'Teavee', 4);

INSERT INTO official_employee (id, first_name, last_name, dept_id) VALUES (1, 'Charlie', 'Bucket', 1);
INSERT INTO official_employee (id, first_name, last_name, dept_id) VALUES (2, 'Augustus', 'Gloop', 2);
INSERT INTO official_employee (id, first_name, last_name, dept_id) VALUES (3, 'Grandpa', 'Joe', 3);


COMMIT TRANSACTION;