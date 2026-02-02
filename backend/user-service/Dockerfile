## ------------- BUILDING SERVICE -------------
#FROM gradle:9.3.1-jdk25 AS builder
#
## Setting the folder directory working
#WORKDIR /app
#
## Copy only gradle files first (better caching)
#COPY gradle gradle
#COPY gradlew .
#COPY build.gradle settings.gradle ./
#COPY src src
#
## Fix windows CRLF && Grant permission
#RUN sed -i 's/\r$//' gradlew && chmod +rwx gradlew
#
## Check list file
#RUN ls -la && head -n 1 gradlew
#
## Download dependencies (cached)
#RUN ./gradlew dependencies --no-daemon
#
## Build executable jar
#RUN ./gradlew bootJar --no-daemon
#
## ------------- DEPLOYING SERVICE -------------
FROM eclipse-temurin:25.0.1_8-jre-ubi10-minimal

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]