FROM openjdk:17
LABEL authors="almaz"
WORKDIR /app
COPY target/tech-support.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]