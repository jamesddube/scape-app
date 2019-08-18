FROM openjdk:8-jre-slim
COPY ./build/libs/*.jar ./scape-subject-service.jar
EXPOSE 4001
CMD ["java", "-jar", "scape-subject-service.jar"]
