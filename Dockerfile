FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
COPY gestao-pessoas.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]