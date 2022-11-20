# PS: jar must be already generated
FROM openjdk:11-jre-slim
MAINTAINER ahmed
LABEL version=1.0
ARG JAR_FILE=./target/*.jar
ARG UPLOAD_FOLDER=./src/main/uploads
COPY  ${JAR_FILE} /vapex.jar
COPY ${UPLOAD_FOLDER} /src/main/uploads
ENTRYPOINT ["java","-jar","/vapex.jar"]
EXPOSE 8080
