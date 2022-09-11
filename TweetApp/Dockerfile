# For Java 11, try this

#FROM adoptopenjdk/openjdk11:alpine-jre

FROM openjdk:8

EXPOSE 8000
ADD target/tweet-app.jar tweet-app.jar
ENTRYPOINT ["java","-jar","/tweet-app.jar"]