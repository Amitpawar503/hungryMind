FROM openjdk:8
MAINTAINER <amitpanwar503@gmail.com>

EXPOSE 7000

VOLUME /data

COPY build/libs/*.jar /app/service.jar

CMD ["java", "-jar", "/app/service.jar"]
