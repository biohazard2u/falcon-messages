FROM java:8
EXPOSE 8081
ADD /target/falcon-messages-0.0.1-SNAPSHOT.jar falcon-messages-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","falcon-messages-0.0.1-SNAPSHOT.jar"]