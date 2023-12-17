FROM openjdk:20

EXPOSE 8080

ADD target/HW8_2Rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
