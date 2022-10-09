FROM openjdk:11-jdk-slim-buster as builder
WORKDIR /app
COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target
COPY ./src ./src
RUN ./mvnw clean package
FROM openjdk:11-jre-slim-buster
WORKDIR /app
COPY --from=builder /app/target/prueba-matrices-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "prueba-matrices-0.0.1-SNAPSHOT.jar"]