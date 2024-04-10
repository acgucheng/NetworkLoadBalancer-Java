FROM amazoncorretto:17.0.8-alpine3.18
VOLUME /tmp
ARG JAR_FILE=target/NetworkLoadBalancer-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY ${JAR_FILE} app.jar
EXPOSE 2333
ENTRYPOINT ["java","-jar","/app.jar"]