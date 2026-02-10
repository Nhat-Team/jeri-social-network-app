### Build Dependencies ###
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY library library
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src src

RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon
RUN ./gradlew bootJar --no-daemon

### Run Application ###
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build ./build/libs/api-gateway-1.0.jar app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]