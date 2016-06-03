FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD build/libs/playground-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=DEV","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]