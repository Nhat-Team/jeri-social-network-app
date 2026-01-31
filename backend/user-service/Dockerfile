FROM eclipse-temurin:25.0.1_8-jre-ubi10-minimal

WORKDIR /app

COPY build/libs/*.jar user-service.jar

ENTRYPOINT ["java", "-jar", "user-service.jar"]