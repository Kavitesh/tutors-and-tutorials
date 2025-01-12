FROM openjdk:17.0-oracle as builder
WORKDIR '/app'
COPY ./api .
RUN ./gradlew build


FROM openjdk:17.0-oracle
WORKDIR '/app'
COPY --from=builder /app/build/libs/api-0.0.1-SNAPSHOT.jar /app
EXPOSE 80
ENTRYPOINT java -jar api-0.0.1-SNAPSHOT.jar