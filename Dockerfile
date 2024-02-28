FROM openjdk:11
ARG JAR_FILE=target/frontend-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]