FROM openjdk:8
MAINTAINER <amitpanwar503@gmail.com>

EXPOSE 7000

ADD target/spring-boot-management-example-0.0.1-SNAPSHOT.jar spring-boot-management-example-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "spring-boot-management-example-0.0.1-SNAPSHOT.jar"]
