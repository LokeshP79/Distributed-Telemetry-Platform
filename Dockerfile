FROM openjdk:17
COPY . /app
WORKDIR /app
RUN javac main.java
CMD ["java", "TelemetryProducer"]
