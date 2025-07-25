# Etapa 1: compilación
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen final
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/miproyecto-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
