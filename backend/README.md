# Idealo-code-challenge-server

[Spring Boot](http://projects.spring.io/spring-boot/) server.

## Requirements
1. An end point for robot to move the position by command script on server
2. Implement Business Logic to move position

## Prerequisite
For building and running the application you need:

- [JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/)
- [Maven 3](https://maven.apache.org)
    
## Implementation
- Followed Package standard to keep all the layers but at high level these classes are created
    - main
        - RobotController
        - RobotService
        - RobotRepository, PositionReporsitory
        - Robot (Entity) =(1..1 relation)=> Position (Entity)
        - RobotPosition (DTO for datashare through Rest end point)
        - Enum for Direction, Commands in util package
        - Used lombok to reduce redundent code
        - Used ExceptionHandler to handle exceptions & even for validation failure created custom eception class 
    - test
        - RobotIntegrationTest
        - RobotUnitTest
    - API End Point (Kept Robot as resource and commands is to apply mpve command on robot) - (Tried to follow standard - https://restfulapi.net/resource-naming/)
        - robots/{robot-id}/commands 
2. Used H2 InMemory Database for POC
3. Follow entity driven design, so Robot Entity has method movePosition, which has business logic of data movement.

## Run and Test the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.idealo.challenge.robot` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

To run the testcases use:
```shell
mvn clean test
```
