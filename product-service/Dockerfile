FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8082

COPY target/*.jar product-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/product-service.jar"]