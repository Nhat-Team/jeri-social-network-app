### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/api-gateway-1.0.jar api-gateway-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx1024m", "-jar", "api-gateway-app.jar"]