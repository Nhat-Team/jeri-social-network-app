### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/chat-service-1.0.jar chat-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "chat-service-app.jar"]