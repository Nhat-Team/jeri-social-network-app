### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/user-service-1.0.jar user-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "user-service-app.jar"]