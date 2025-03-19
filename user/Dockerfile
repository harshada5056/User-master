#start with the java runtime
FROM openjdk:17-jdk-slim
#add maintainer info
MAINTAINER Pratiksha
#copy the jar file
COPY target/User-0.0.1-SNAPSHOT.jar User-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java","-jar","User-0.0.1-SNAPSHOT.jar"]