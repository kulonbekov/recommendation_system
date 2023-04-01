insert into tb_role (id, created, status, updated, name) VALUES (1, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_USER');
insert into tb_role (id, created, status, updated, name) VALUES (2, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_ADMIN');

insert into tb_user(id,created,status,updated,age, email, gender, password, username)
VALUES (1, '2023-03-29 02:28:38.593', 'ACTIVE', '2023-03-29 02:28:38.593', 29, 'kulonbekov@gmail.com','MALE', '$2a$04$TgiPX6SJgrjQ4RQhKNWOnOwJ.ohCgTZ63kxc9ysIcnhFol21wg9Y2', 'kulonbekov');

insert into tb_user_roles(user_id,role_id)VALUES (1,2);

insert into tb_genre(id,created,status,updated,name)VALUES (1,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Классическая музыка');