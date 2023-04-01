insert into tb_role (id, created, status, updated, name) VALUES (1, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_USER');
insert into tb_role (id, created, status, updated, name) VALUES (2, '2023-03-29 02:27:35', 'ACTIVE', '2023-03-29 02:27:41', 'ROLE_ADMIN');

insert into tb_user(id,created,status,updated,age, email, gender, password, username)
VALUES (1, '2023-03-29 02:28:38.593', 'ACTIVE', '2023-03-29 02:28:38.593', 29, 'kulonbekov@gmail.com','MALE', '$2a$04$TgiPX6SJgrjQ4RQhKNWOnOwJ.ohCgTZ63kxc9ysIcnhFol21wg9Y2', 'kulonbekov');

insert into tb_user_roles(user_id,role_id)VALUES (1,2);

insert into tb_genre(id,created,status,updated,name)VALUES (1,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Классическая музыка');
insert into tb_genre(id,created,status,updated,name)VALUES (2,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Hip Hop');
insert into tb_genre(id,created,status,updated,name)VALUES (3,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Индийская поп-музыка');
insert into tb_genre(id,created,status,updated,name)VALUES (4,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Rap');
insert into tb_genre(id,created,status,updated,name)VALUES (5,'2023-03-29 02:28:38.593','ACTIVE', '2023-03-29 02:28:38.593','Поп-музыка');


insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (1,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Мурас', 'Мирбек Атабеков', 2017, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\muras.jpg', 'Мурас', 500, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\mirbek-atabekov-muras.mp3');
insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (2,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Zamanbap', 'Бегиш, Bayastan, G-Voo', 2019, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\ene-til.jpg', 'Эне-тил', 450, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\zamanbap-ene-til.mp3');
insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (3,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Сени менен', 'Мирбек Атабеков', 2022, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\seni-menen.jpg', 'Сени менен', 470, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\mirbek-atabekov-seni-menen.mp3');
insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (4,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Ауылымды сағындым', 'RaiM', 2019, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\aulymdy-sagyndym.jpg', 'Ауылымды сағындым', 510, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\raim-auylymdy-sagyndym.mp3');
insert into tb_music (id,created,status,updated,album,author,date_of_issue,image,name,number_of_plays, song)
VALUES (5,'2023-04-01 20:28:22.02','ACTIVE','2023-04-01 20:28:22.02','Айланып учуп кетем', 'FREEMAN 996', 2019, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\images\айланып-учуп-кетем.jpg', 'Айланып учуп кетем', 490, 'C:\Users\Comp\IdeaProjects\Bootcamp_12\recommendation_system\..\recommendation_system\recommendation_system\src\main\resources\musics\songs\freeman-996-ajlanyp-uchup-ketem.mp3');



insert into tb_music_genre(music_id,genre_id)VALUES (1,1);
insert into tb_music_genre(music_id,genre_id)VALUES (1,3);
insert into tb_music_genre(music_id,genre_id)VALUES (2,2);
insert into tb_music_genre(music_id,genre_id)VALUES (2,3);
insert into tb_music_genre(music_id,genre_id)VALUES (2,4);
insert into tb_music_genre(music_id,genre_id)VALUES (3,5);
insert into tb_music_genre(music_id,genre_id)VALUES (3,3);
insert into tb_music_genre(music_id,genre_id)VALUES (4,2);
insert into tb_music_genre(music_id,genre_id)VALUES (4,4);
insert into tb_music_genre(music_id,genre_id)VALUES (5,1);
insert into tb_music_genre(music_id,genre_id)VALUES (5,3);