# Rent_Manager_Backend

This project is the back end part of Rent Manager application.
This is an application created for rental companies. In this project we are working with construction machines.
<br><br>
The application offers CRUD operations on products, customers and rents.
There is a basic dashboard for various statistics and graphs, and the navigation contains a "notifications" tab that shows if products should be brought back by customer.
<br>

### Login
There is no opportunity for registration: only admin can register new users. There are two default users: admin and user with admin and user roles.
<br>
## Login data:
 - For admin:
    - Username: admin
    - Password: admin
  - For user:
    - Username: user
    - Password: user

### Tech stack

- Spring Boot,
- JPA/Hibernate, Postgres database,
- Lombok,
- Authentication handled with Spring Security and Jason Web Tokens (stored in httponly cookies)

### Microservices

On the "service-merge" branch there is a modified version of the project, separated into microservices. 
<br>The services are connected with Euraka and available via Zuul API gateaway.
<a href="https://github.com/EvelinSzabados/Rent-Manager">See the front end repo</a>
<br>
<b>Deployment still in process</b>
For deployment, secured enpoints needed to be available because of crossdomain cookie problem.

### Install

Clone or the download the repo. Open as Maven project by pom.xml.
<br>
## Service merge branch:
<br>
 Open as Maven project, database files can be found in Resources/Database/Init.
 <br>On the Services tab in IntelliJ run each microservice - first run Rent Manager Application with Zuul, then Service registry - after these run other services.
