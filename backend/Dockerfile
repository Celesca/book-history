# stage-1 build artifact
FROM amazoncorretto:17.0.9-alpine3.18 as builder
WORKDIR /app
ADD . .
RUN chmod +x ./gradlew
RUN ["./gradlew", "clean", "bootJar"]

## stage-2 running unit tests
#FROM builder as test
#RUN ["./gradlew", "test"]

# stage-3 running image
FROM gcr.io/distroless/java17-debian12:latest
WORKDIR /app
COPY --from=builder /app/build/libs/bookserver-0.0.1-SNAPSHOT.jar bookserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "bookserver-0.0.1-SNAPSHOT.jar"]