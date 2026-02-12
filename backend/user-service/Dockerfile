### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

RUN ls -a

COPY build/libs/user-service-1.0.jar user-service-app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx1024m", "-jar", "user-service-app.jar"]