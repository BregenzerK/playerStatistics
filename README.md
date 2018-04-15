# playerStatistics
This repository contains a spring boot application as server as well as a react and angular application as client. 
I chose Spring boot and angular, because I have the most experience with it and I knew, that I could hit all requirements efficiently. 
Furthermore here are some more reasons why this frameworks fit this use case: 
## Backend:
  - by using tools like the spring initializr (https://start.spring.io/) it´s extremly easy and fast to generate your boiler-plate server application. This already contains the relevant dependencies and an in-memory database setup.
 - spring batch provides a mechanism to import data after the application started. This is an easy and reliable way, but rather not generic. You can´t change column names without touching the implementation.
 - spring boot also comes with an efficient way to define database entries and queries.
 - a simple integration of swagger allows a user-friendly and interface documentation and the possibility to generate the responding client implementation
  
## Frontend:
  I overlooked the fact, that typescript was not allowed in this exercise and after finding out, I aquired some basic knowledge of the react framework and re-did the client side.
 - Both frameworks offer client side rendering. The biggest difference in terms of implementation is that the angular app is using a generated service implementation while the react app is calling the endpoints directly.
 
 ## Install and Run instructions
    cd player-statistics-backend
    mvn clean package
    mvn spring-boot:run 
    --> localhost:8080/swagger-ui.html
    
    cd ../player-statistics-angular
    npm i
    ng run start
    --> localhost:4200
    
    cd ../player-statistics-react
    npm i
    ng run start
    --> localhost:3000
