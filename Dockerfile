FROM openjdk:19
WORKDIR /
COPY ./target/Ukol-0.0.1-SNAPSHOT.jar Ukol-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar Ukol-0.0.1-SNAPSHOT.jar
