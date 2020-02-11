# base image
FROM openjdk:11

VOLUME /tmp

EXPOSE 80

COPY target/*.jar product-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/product-service.jar"]

# container port is the port of profile mysql "-Dspring.profiles.active=dev,mysql"