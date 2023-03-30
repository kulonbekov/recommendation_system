insert into tb_role (id, created, status, updated, name) VALUES (1, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_USER');
insert into tb_role (id, created, status, updated, name) VALUES (2, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_ADMIN');

insert into tb_user(id,created,status,updated,age, email, gender, password, username)
VALUES (1, '2023-03-29 02:28:38.593', 'ACTIVE', '2023-03-29 02:28:38.593', 29, 'kulonbekov@gmail.com','MALE', '$2a$04$TgiPX6SJgrjQ4RQhKNWOnOwJ.ohCgTZ63kxc9ysIcnhFol21wg9Y2', 'kulonbekov');

insert into tb_user_roles(user_id,role_id)VALUES (1,2);

insert into tb_tag(id,created,status,updated,name)VALUES (1,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Искусство');
insert into tb_tag(id,created,status,updated,name)VALUES (2,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Цитаты');
insert into tb_tag(id,created,status,updated,name)VALUES (3,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Автомобили');
insert into tb_tag(id,created,status,updated,name)VALUES (4,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Аниме');
insert into tb_tag(id,created,status,updated,name)VALUES (5,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Фотографии');
insert into tb_tag(id,created,status,updated,name)VALUES (6,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Футбол');
insert into tb_tag(id,created,status,updated,name)VALUES (7,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Технологии');
insert into tb_tag(id,created,status,updated,name)VALUES (8,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Дизайн');
insert into tb_tag(id,created,status,updated,name)VALUES (9,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Образование');
insert into tb_tag(id,created,status,updated,name)VALUES (10,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Юмор');
insert into tb_tag(id,created,status,updated,name)VALUES (11,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Животные');
insert into tb_tag(id,created,status,updated,name)VALUES (12,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Развлечение');
insert into tb_tag(id,created,status,updated,name)VALUES (13,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Мужской стиль');
insert into tb_tag(id,created,status,updated,name)VALUES (14,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Спорт');
insert into tb_tag(id,created,status,updated,name)VALUES (15,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Кабинет');
insert into tb_tag(id,created,status,updated,name)VALUES (16,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Мотоциклы');
insert into tb_tag(id,created,status,updated,name)VALUES (17,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Знаменитости');
insert into tb_tag(id,created,status,updated,name)VALUES (18,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Завтрак');
insert into tb_tag(id,created,status,updated,name)VALUES (19,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Мебель');
insert into tb_tag(id,created,status,updated,name)VALUES (20,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Наука');
insert into tb_tag(id,created,status,updated,name)VALUES (21,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Кухни');
insert into tb_tag(id,created,status,updated,name)VALUES (22,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Спальня');
insert into tb_tag(id,created,status,updated,name)VALUES (23,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Кемпинг');
insert into tb_tag(id,created,status,updated,name)VALUES (24,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Красота');
insert into tb_tag(id,created,status,updated,name)VALUES (25,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Живопись');

insert into tb_picture(id,created,status,updated,author,image,name,number_of_views)
VALUES (1,'2023-03-31 00:49:28.491','ACTIVE','2023-03-31 00:49:28.491','Christiaana','C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\images\Panamera-car1.jpg','Panamera',30);

insert into tb_picture(id,created,status,updated,author,image,name,number_of_views)
VALUES (2,'2023-03-31 00:49:28.491','ACTIVE','2023-03-31 00:49:28.491','Christiaana','C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\images\Panamera-car2.jpg','Panamera',31);

insert into tb_picture(id,created,status,updated,author,image,name,number_of_views)
VALUES (3,'2023-03-31 00:49:28.491','ACTIVE','2023-03-31 00:49:28.491','Christiaana','C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\images\Lamborgini-car1.jpg','Lamborgini',30);

insert into tb_picture(id,created,status,updated,author,image,name,number_of_views)
VALUES (4,'2023-03-31 00:49:28.491','ACTIVE','2023-03-31 00:49:28.491','Christiaana','C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\images\Lamborgini-car2.jpg','Lamborgini',31);

insert into tb_picture_tag(picture_id,tag_id)VALUES (1,3);
insert into tb_picture_tag(picture_id,tag_id)VALUES (1,13);
insert into tb_picture_tag(picture_id,tag_id)VALUES (1,8);
insert into tb_picture_tag(picture_id,tag_id)VALUES (2,3);
insert into tb_picture_tag(picture_id,tag_id)VALUES (2,13);
insert into tb_picture_tag(picture_id,tag_id)VALUES (2,8);
insert into tb_picture_tag(picture_id,tag_id)VALUES (3,3);
insert into tb_picture_tag(picture_id,tag_id)VALUES (3,13);
insert into tb_picture_tag(picture_id,tag_id)VALUES (3,8);
insert into tb_picture_tag(picture_id,tag_id)VALUES (4,3);
insert into tb_picture_tag(picture_id,tag_id)VALUES (4,13);
insert into tb_picture_tag(picture_id,tag_id)VALUES (4,8);