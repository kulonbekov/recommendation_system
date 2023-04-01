insert into tb_role (id, created, status, updated, name) VALUES (1, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_USER');
insert into tb_role (id, created, status, updated, name) VALUES (2, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_ADMIN');

insert into tb_user(id,created,status,updated,age, email, gender, password, username)
VALUES (1, '2023-03-29 02:28:38.593', 'ACTIVE', '2023-03-29 02:28:38.593', 29, 'kulonbekov@gmail.com','MALE', '$2a$04$TgiPX6SJgrjQ4RQhKNWOnOwJ.ohCgTZ63kxc9ysIcnhFol21wg9Y2', 'kulonbekov');

insert into tb_user_roles(user_id,role_id)VALUES (1,2);

insert into tb_genre(id,created,status,updated,name)VALUES (1,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Классическая музыка');
insert into tb_genre(id,created,status,updated,name)VALUES (2,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Arabic Hip Hop');
insert into tb_genre(id,created,status,updated,name)VALUES (3,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Индийская поп-музыка');
insert into tb_genre(id,created,status,updated,name)VALUES (4,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Khaliji Rap');


insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (1,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Мурас', 'Мирбек Атабеков', 2017, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\muras.jpg', 'Мурас', 500, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\mirbek-atabekov-muras.mp3');

insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (2,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Zamanbap', 'Бегиш, Bayastan, G-Voo', 2019, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\ene-til.jpg', 'Эне-тил', 450, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\zamanbap-ene-til.mp3');

insert into tb_music_genre(music_id,genre_id)VALUES (1,1);
insert into tb_music_genre(music_id,genre_id)VALUES (1,3);
insert into tb_music_genre(music_id,genre_id)VALUES (2,2);
insert into tb_music_genre(music_id,genre_id)VALUES (2,3);
insert into tb_music_genre(music_id,genre_id)VALUES (2,4);