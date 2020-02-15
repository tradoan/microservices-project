FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8888

COPY target/*.jar config-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/config-server.jar"]