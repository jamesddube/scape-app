FROM openjdk:8-jre-slim
COPY ./build/libs/*.jar ./scape-degree-service.jar
EXPOSE 4002
CMD ["java", "-jar", "scape-degree-service.jar"]
