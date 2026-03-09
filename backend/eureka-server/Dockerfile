### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/eureka-server-1.0.jar eureka-server-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx256m", "-jar", "eureka-server-app.jar"]