FROM openjdk:21
LABEL authors="almaz"
WORKDIR /app
COPY target/tech.support-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]