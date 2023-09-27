FROM maven:3.8.4-openjdk-17 AS builder


WORKDIR /app

COPY . .

RUN mvn clean package

FROM jboss/keycloak:latest

COPY --from=builder /app/target/dasniko.keycloak-2fa-sms-authenticator-1.0-SNAPSHOT.jar /opt/jboss/keycloak/providers/

EXPOSE 8080

CMD ["-b", "0.0.0.0"]

# FROM maven:3.8.4-openjdk-17 AS builder

# WORKDIR /app

# COPY . .

# RUN mvn clean package

# FROM openjdk:17-jdk-slim

# RUN mkdir /app

# COPY --from=builder /app/src/main /app/src/main

# EXPOSE 8080

# CMD ["java", "-jar", "/app/app/src/main"]


