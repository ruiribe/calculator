# Calculator
Spring boot application that exposes a REST API, and allows to calculate the results of simple arithmetic operations (Sum, Subtract, Multiply and Divide), using two operands.

### Tecnologies

- Java(v8)
- Maven(v3)
- Spring Boot(v1.5.8.RELEASE)
- Docker(17.06.0-ce)
- Docker-compose(v1.13.0)

### Startup
#### Required to run:

- Java (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Maven (https://maven.apache.org/install.html)
- Docker (https://docs.docker.com/engine/installation/)
- Docker Compose (https://docs.docker.com/compose/install/)

### Profiles
Two profiles were created to run the application: Client and Server
#### Client
To run the application as a Client:
```
java -jar -Dspring.profiles.active=client target/calculator-0.0.1-SNAPSHOT.jar
```
Application will run on Port 8080.
#### Server
To run the application as a Client:
```
java -jar -Dspring.profiles.active=server target/calculator-0.0.1-SNAPSHOT.jar
```
Application will run on Port 8090.
### API REST
#### URL
- http://[ip-machine]:8080/
#### Operations:
```
GET     /sum?a=x&b=y                - Sums a and b, and returns the result
GET     /subtract?a=x&b=y           - Subtracts b from a, and returns the result
GET     /multiply?a=x&b=y           - Multiplies a and b, and returns the result
GET     /divide?a=x&b=y             - Divides a with b, and returns the result
```

