# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.hs-augsburg.HR-Management-Tool' is invalid and this project uses 'com.hsaugsburg.HRManagementTool' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Setup Spring security with JPA](https://www.youtube.com/watch?v=awcCiqBO36E&t=1627s&ab_channel=DanVega)

### Setup DB
* To set up the db first you have to uncomment the method _commandLineRunner_ in th main file **HrManagementToolApplication.java**.
This will insert two users into the db on application start up. 
* After starting the application the _commandLineRunner_ method should be commented again to prevent db errors and inserting duplicates.
* Then you can access the h2-console under _http://localhost:8090/h2-console/_. The password is defined in the application.properties file.
* In the h2-console execute the insert statements defined in the file **testData.sql** located in **src/main/resources/database/testData.sql**

###Docker
* To containerise the application, it is needed to deploy the image. 
$ docker build -t hr-management-tool .
$ cd docker
$ docker-compose up
* To achieve the docker container with the db use the exec statement
$ docker exec -it db /bin/bash
* To login into the db 
$ psql -U compose-postgres -W compose-postgres
* Than just enter the password
* To execute any sql statement follow the schema:
$ select * from ABTEILUNG
$ \crosstabview
* The data is persisted in the volume, described in the docker-compose file.