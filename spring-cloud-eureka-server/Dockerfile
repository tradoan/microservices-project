# base image
FROM openjdk:11

VOLUME /tmp

EXPOSE 80

COPY target/*.jar cloud-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "cloud-server.jar"]