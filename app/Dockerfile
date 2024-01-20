# syntax=docker/dockerfile:1

FROM docker.io/library/eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY app/src ./src

CMD ["./mvnw", "spring-boot:run"]
