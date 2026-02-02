# ------------- BUILDING SERVICE -------------
FROM gradle:jdk25 AS builder

WORKDIR /app

# Copy only gradle files first (better caching)
COPY gradle gradle
COPY gradlew .
COPY gradlew.bat .
COPY build.gradle settings.gradle ./

# Download dependencies (cached)
RUN ./gradlew.bat dependencies --no-daemon

# Copy source code
COPY src src

# Build executable jar
RUN ./gradlew.bat bootJar --no-daemon

# ------------- DEPLOYING SERVICE -------------
FROM eclipse-temurin:25.0.1_8-jre-ubi10-minimal

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]