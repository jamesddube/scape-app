FROM openjdk:8-jre-slim
COPY ./build/libs/*.jar ./scape-core-service.jar
EXPOSE 4000
CMD ["java", "-jar", "scape-core-service.jar"]
