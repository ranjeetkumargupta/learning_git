FROM openjdk:17-jdk-alpine
COPY target/spring-postgres-docker.jar application.jar
ENTRYPOINT [ "java", "-jar", "application.jar" ]
