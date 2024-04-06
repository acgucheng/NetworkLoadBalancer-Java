FROM amazoncorretto:17.0.8-alpine3.18
VOLUME /tmp
ARG JAR_FILE=target/DemoWebsite-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]