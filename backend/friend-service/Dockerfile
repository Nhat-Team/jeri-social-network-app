### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/friend-service-1.0.jar friend-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "friend-service-app.jar"]