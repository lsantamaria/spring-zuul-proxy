# Zuul proxy starter

A sample Spring Boot project for integrating the a UI to an external backend

### Technologies

- Java JDK 8
- Spring Boot 2.2.6

### Requirements

- Java JDK 8
- Gradle 5.4 (provided)

### Installation

- Download and install Java JDK 8 from the [Java official webpage](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html). 

- Set JAVA_HOME environment variable to point to the previous installation.


### Compilation

```
./gradlew compileJava
```
### Test
```
./gradlew test
```

### Run
You can run the project either building and running the JAR:
```
./gradlew build

java -jar /build/libs/dfm-starter-be-0.0.1-SNAPSHOT.jar
```

or using spring-boot gradle plugin:

```
./gradlew bootRun
```
The API will be running at http://localhost:8080.
