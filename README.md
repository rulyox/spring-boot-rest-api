# Spring Boot REST API Server

An example REST API server using Spring Boot.

## Usage

```shell
docker-compose build
docker-compose up -d
```

## Manual Usage

Execute these commands inside `server/app`.

### Using Maven

* test : `mvn test`
* package : `mvn package`

### Using Maven Wrapper

* run (for test purposes) : `./mvnw spring-boot:run`
* test : `./mvnw test`
* package : `./mvnw package`

After packaging, `target/ExampleServer.jar` will be created.

#### run
```shell
java -jar target/ExampleServer.jar
```
