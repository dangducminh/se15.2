FROM openjdk:oraclelinux8
COPY target/se15.2-0.0.1-SNAPSHOT.jar se15.2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","se15.2-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080