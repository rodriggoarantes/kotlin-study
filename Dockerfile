ARG VERSION=1.0.0
FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER Rodrigo
LABEL maintainer="rodriggoarantes@gmail.com"

COPY target/kotlin-study-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8181
