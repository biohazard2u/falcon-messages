FROM openjdk:8-jre-alpine

MAINTAINER Marcos
LABEL description="Falcon-app"

RUN apk add --no-cache openjdk8

# Set the working directory to /app
#WORKDIR /app
# Copy the current directory contents into the container at /app
#ADD . /app


RUN ["mkdir", "-p", "/app"]
WORKDIR /app

COPY ["target/falcon-messages-0.0.1-SNAPSHOT.jar", "falcon-messages-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081

#ADD /app/target/falcon-messages-0.0.1-SNAPSHOT.jar falcon-messages-0.0.1-SNAPSHOT.jar

#CMD ["java","-jar","falcon-messages-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java","-jar","falcon-messages-0.0.1-SNAPSHOT.jar"]