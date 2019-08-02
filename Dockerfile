ARG VERSION=1.0.0
FROM openjdk:8-jdk-alpine
VOLUME /tmp
MAINTAINER Rodrigo
LABEL maintainer="rodriggoarantes@gmail.com"

COPY target/kotlin-study-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","/app.jar", "--spring.profiles.active=prod"]

EXPOSE 8181 15005
