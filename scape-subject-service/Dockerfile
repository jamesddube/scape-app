FROM openjdk:8-jre-slim
COPY ./build/libs/*.jar ./scape-subject-service.jar
EXPOSE 8080
CMD ["java", "-jar", "scape-subject-service.jar"]
