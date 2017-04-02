FROM openjdk:8-alpine
VOLUME /tmp
ADD ominidi-web-1.0-SNAPSHOT.jar ominidi-web-1.0-SNAPSHOT.jar
RUN ["sh", "-c", "touch /ominidi-web-1.0-SNAPSHOT.jar"]
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=production -Djava.security.egd=file:/dev/./urandom -jar /ominidi-web-1.0-SNAPSHOT.jar"]
