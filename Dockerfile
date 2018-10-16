FROM openjdk:8
MAINTAINER <amitpanwar503@gmail.com>

EXPOSE 7000

ADD target/core-module-0.0.1-SNAPSHOT.jar core-module-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "core-module-0.0.1-SNAPSHOT.jar"]
