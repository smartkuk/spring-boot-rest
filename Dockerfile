# ./gradlew clean build
# docker build --build-arg JAR_FILE=./build/libs/spring-boot-rest-0.0.1-SNAPSHOT.jar  -t smartkuk/spring-boot-rest .
# docker run --name spring-boot-rest -t -d -p 8080:8080 smartkuk/spring-boot-rest
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/lib/spring-boot-rest*.jar
#ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]