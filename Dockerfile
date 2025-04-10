FROM openjdk:17-jdk-slim

LABEL authors="oPelayo"

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", ["top", "-b"]