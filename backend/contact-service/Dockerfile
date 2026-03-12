### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY build/libs/contact-service-1.0.jar contact-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "contact-service-app.jar"]