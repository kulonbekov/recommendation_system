# Проект "Система рекомендаций"

Это онлайн-платформа, которая рекомендует пользователям новый контент, который может заинтересовать их, 
и побудить пользователей потреблять больше контента на этой платформе.

## Запуск

1. Для запуска вам понадобиться **[Java 8](https://www.java.com/ru/)** и выше.
2. СУБД использован **[PostgreSQL 15.0](https://www.postgresql.org/)**.

## Технологии

1. **[Spring Boot](https://spring.io/projects/spring-boot)** проект использует систему сборки на основе **[Maven](https://maven.apache.org/)**.
2. Для работы с базами данных и для сохраниение Java-обьектов используется **Spring Data Jpa**, для реализации **Hibernate**.
3. **[Spring Security](https://spring.io/projects/spring-security)** для аутентификации и контрола доступа.
4. Для описание **API** и создание документации, в проекте использован **[Swagger](https://swagger.io/).**
````
 http://localhost:8079/swagger-ui.html#
````
6. Для тестирование **API** - **[Postman](https://www.postman.com/)**.

## Настройки и описания проекта

1. Настройки соединение к БД прописаны в файле `src/main/resources/application.proporties` (надо будет создать новую database и прописать username и password
2. Все зависимости и библиотеки прописаны в файле `pom.xml` (при запуска автоматические будут загружены).
3. Сервер порт по умолчанию **'8079'**, при желание можно поменять в файле `src/main/resources/application.proporties`.
4. При запуске проекта, автоматический добавиться нужные таблицы в **PostgreSQL** и необходимы SQL запросы из файла `src/main/resources/data.sql`.
5. Для настройки **`Mail Sender`**, необходимо будет в настройках gmail почты, добавить пароль доступа для сторонных приложений, эти настройки прописаны в файле `src/main/resources/application.proporties`.
6. Все необходимые изображении и музыки сохранены в файле `src/main/resources/musics`, а пути к этим файлам прописаны в БД.
## Важное

При добавление пользователей, ролей, контента могут возникнуть ошибки, эти ошибки возникают из-за того что в ручную в базу были добавлены записи и генерация уникальных значений выдает ошибку "повторяющееся значение ключа нарушает ограничение уникальности", эти ошибки решаются очень быстро, надо нажать `send` пропустить в ручную добавленные записи в БД.

## Описание API запросов для контроля доступа 
1. POST запрос "Аутентификация" `http://localhost:8079/api/v1/auth/login`

- Пользователь с доступом admin **(ROLE_ADMIN)**: 
- username: **mirbek**
- password: **AdIl1!2@** (есть валидация пароля)
- Пользователь с доступом user **(ROLE_USER)**
- username: **adil**
- password: **AdIl1!2@**

2. Post запрос **"Регистрация"** `http://localhost:8079/api/v1/auth/register` в JSON формате, в поле **`email`** (есть обязательная валидация почты) 
````
{
    "username":"ermek",
    "password":"AdIl1!2@",
    "email":"sehami4053@djpich.com",
    "age":27,
    "gender":"MALE",
    "genres":[{
        "name":"Классическая музыка"
        },
        {
        "name":"Rap"
        }
    ]
}
````

3. Post запрос **"Сброс пароля"**, заполняется почта пользователя в JSON формате.
````
http://localhost:8079/api/v1/auth/reset-password
````
````
{
    "email":"sehami4053@djpich.com"
}
````
на почту придет jwt-token, он необходим при создание нового пароля.

4. Post запрос **"Изменить пароль"** `http://localhost:8079/api/v1/auth/change-password` в JSON формате.
````
{
    "email":"sehami4053@djpich.com",
    "token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZGlsIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY4MDI5NjEyNCwiZXhwIjoxNjgwMjk5NzI0fQ.Web4FSNHIVGlrmYirtTlJQiBUzdLOm_hx0ysCDMyJBs",
    "password":"EdIl1!2@",
    "passwordConfirmation":"EdIl1!2@"
}
````
- Заполняем поле почта, токен, и два поля для пароля.

## Описание API запроcов для добавления контента

1. Post запрос **"Save"** `http://localhost:8079/api/v1/admin/music-save` , контент добавляется с помощью `ModelAttribute` и `MultiParFile`.
- Необходимо авторизоваться с ролем **`ROLE_ADMIN`**, полученный токен добавить в **`Headers`**.
- Key: **`Authorization`**
- Value: **`Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrdWxvbmJla292Iiwicm9sZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE2ODAzNTQ2MzAsImV4cCI6MTY4MDM5MDYzMH0.atY0oyZBlf0sizfe717nn1jtb43vApX7yvqAcSX8xMU`** 
- `Bearer_новыйтокен`.
- После выбираем **`Body`** -> **`form-data`** и заполняем поля.
![Image alt](https://github.com/kulonbekov/recommendation_system/blob/master/recommendation_system/src/main/resources/musics/images/form-data-save-music.PNG)

## Описание API запросов для поиска, фильтрации и рекомендации

1. Get запрос **"Живой поиск по названию товара"**
````
http://localhost:8079/api/v1/users/find/by/name?name=Сени менен
````

2. Get запрос **"Фильтрация по автору"**
````
http://localhost:8079/api/v1/users/find/all/by/author?author=Мирбек
````

3. Get запрос **"Фильтрация по жанру"****
````
http://localhost:8079/api/v1/users/find/all/by/genre?genre=Классическая
````

4. Get запрос **"Фильтрация по названию"**
````
http://localhost:8079/api/v1/users/find/all/by/name?name=Мур
````

5. Get запрос **"Рекомендация (популярное)"**
````
http://localhost:8079/api/v1/users/find/all/by/popular
````

6. Get запрос **"Рекомендация (новинка)"**
````
http://localhost:8079/api/v1/users/find/all/by/new
````

7. Get запрос **"Рекомендация (по вкусу пользователя)"**
````
http://localhost:8079/api/v1/users/find/all/by/user-popular?name=adil
````

## Модульные тесты
- Добавлен **JUnit** тест для валидации email адреса при добавления пользователя
![Image alt](https://github.com/kulonbekov/recommendation_system/blob/master/recommendation_system/src/main/resources/musics/images/ValidEmailProvider.PNG)
![Image alt](https://github.com/kulonbekov/recommendation_system/blob/master/recommendation_system/src/main/resources/musics/images/InvalidEmailProvider.PNG)
