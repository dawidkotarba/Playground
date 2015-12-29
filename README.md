# Spring Playground
    This is just a simple example of Spring-based app (with AngularJS in future). Dev still in progress.

![Build Status](https://travis-ci.org/dawidkotarba/Playground.svg)

## Tech stack:
- build: Gradle (wrapper available)
- container: Spring MVC (web, data, aop, security, test)
- db: H2
- JPA: Hibernate with Querydsl
- server: embedded Tomcat (Spring Boot app)
- tests: TestNG, Mockito, Hamcrest, JBehave
- doc: SwaggerUI

## Front-end (todo all):
- build: bower + gulp/grunt
- js: AngularJS
- css: Bootstrap + Less?
- tests: Karma, Jasmine + Sinon + Chai

## Buld & run:
From main folder:
- gradlew build
- java -jar build\libs\playground-0.1.0.jar

All logs will be stored in "/opt/apps/webdata/weblogs" folder.

## Pages (providing Tomcat runs on default 8080):
- localhost:8080/login --> default login page
- localhost:8080/db --> H2 console (url: jdbc:h2:mem:testdb, user: sa, pwd: <blank>)
- localhost:8080/swagger-ui.html --> SwaggerUI

Admin credentials: admin : admin
