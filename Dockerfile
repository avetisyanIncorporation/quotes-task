FROM openjdk:17
ADD /target/quote-*.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]