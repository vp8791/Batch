# Spring Boot Security Jwt Authentication

This is a sample project to provide example on how to add JWT token authentication in a spring boot application.
The example uses maven as a build tool and also sample script to run on application startup so that anybody can get started by simply running Application.java
 
The complete explanation can be found on my blog here - [Spring Boot Security JWT Authentication](http://www.devglan.com/spring-security/spring-boot-jwt-auth)
## Technology Used

 1. Spring Boot (1.5.8.RELEASE)
 2.  JWT (0.6.0)
 3.  Mysql
 4. Java 1.8
## Similar Post

You may be interested in other spring security articles:

[Spring Boot Security OAUTH2 Example](http://www.devglan.com/spring-security/spring-boot-security-oauth2-example).

[Spring Boot Security Basic Authentication](http://www.devglan.com/spring-security/spring-boot-security-rest-basic-authentication)

[Spring Boot Security Hibernate Login](http://www.devglan.com/spring-security/spring-boot-security-hibernate-login-example)

[Securing Actuator Endpoints with Spring Security](http://www.devglan.com/spring-security/securing-spring-boot-actuator-endpoints-with-spring-security)

==Murali Craete following after logging into DB as root/1234=====
create database angular;

use angular;

CREATE TABLE user(id INT NOT NULL AUTO_INCREMENT,age INT,firstName VARCHAR(255),lastName VARCHAR(255),password VARCHAR(255),salary BIGINT,username VARCHAR(255),PRIMARY KEY (id))ENGINE=MyISAM;


INSERT INTO user (id, firstname, lastname, username, password, salary, age) VALUES (1, 'Alex','Knr', 'alex123','$2a$04$4vwa/ugGbBVDvbWaKUVZBuJbjyQyj6tqntjSmG8q.hi97.xSdhj/2', 3456, 33);
INSERT INTO user (id, firstname, lastname, username, password, salary, age)  VALUES (2, 'Tom', 'Asr', 'tom234', '$2a$04$QED4arFwM1AtQWkR3JkQx.hXxeAk/G45NiRd3Q4ElgZdzGYCYKZOW', 7823, 23);
INSERT INTO user (id, firstname, lastname, username, password, salary, age)  VALUES (3, 'Adam', 'Psr', 'adam', '$2a$04$WeT1SvJaGjmvQj34QG8VgO9qdXecKOYKEDZtCPeeIBSTxxEhazNla', 4234, 45);

=
user Id/password:
-- Passwords are 
-- tom234/tom234
-- adam/adam
