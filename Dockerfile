# ---------- 构建 ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- 运行 ----------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/sfdc-demo-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
