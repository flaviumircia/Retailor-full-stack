# Retailor Back-end
Web application back-end built with Spring, Spring Boot, Thymeleaf and MySQL.
In development...!

# About
Project for Database course.
This project is a full-stack web application built with the following technologies:
<ul>
<li><h3>Front-end:</h3>Thymeleaf</br> Future releases will add an Android UI</li>
<li><h3>Back-end:</h3> Spring </br> The API is built with Spring-Boot</li>
<li><h3>Database</h3>MySQL </br> Hibernate (JPA) in Spring </li>
</ul>

# How it works
The project should support all CRUD operation received by the back-end controller from the front-end UI.
It is built on the MVC architectural pattern and it is packaged by layer.

<img src="https://user-images.githubusercontent.com/74871618/212982804-23aa0dbe-916c-4d63-91e8-67602ae07615.png" style="height:360px"/>

The structure of the application is split by layers giving advantages over the classic monolith architecture.
<img src="https://user-images.githubusercontent.com/74871618/212983339-a070ae1b-d3b6-445b-bb77-55cbcb9ef53b.png" style="height:360px"/>

# Database
The database it's built over two main tables (Orders and Clients) with the Many-to-Many relationship, given this condition I have added a 3rd table (Association) connecting the other (two) tables by the foreign keys.

<img src="https://user-images.githubusercontent.com/74871618/212984013-73e96667-b246-4324-93ee-262f16378718.png" style="height:360px"/>

In addition to those 3 tables already connected I have added a generator-sequence for each giving the possibility of auto-incrementing the primary key (each ID) in Hiberante.

Hibernate it's used in Spring-Boot mapping the Java classes into Entities and Entities to MySQL data tables.
