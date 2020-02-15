# base image
FROM openjdk:11

VOLUME /tmp

EXPOSE 8083

COPY target/*.jar basket-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "basket-service.jar"]