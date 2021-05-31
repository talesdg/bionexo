FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/bionexo-1.0.0.jar bionexo-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bionexo-1.0.0.jar"]

