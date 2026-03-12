### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/notification-service-1.0.jar notification-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "notification-service-app.jar"]