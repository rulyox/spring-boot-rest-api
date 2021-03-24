FROM maven:3.6.3-openjdk-8

COPY ./app /server
WORKDIR /server

RUN mvn package

CMD ["java", "-jar", "target/ExampleServer.jar"]
