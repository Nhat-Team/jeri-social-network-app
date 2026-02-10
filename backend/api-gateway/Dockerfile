FROM eclipse-temurin:25.0.1_8-jre-ubi10-minimal

WORKDIR /app

COPY ./build/libs/api-gateway-1.0.jar app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]