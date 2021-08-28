FROM openjdk:15-jdk-alpine
ARG JAR_FILE=target/SimpleInterest-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]