FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD target/api-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]