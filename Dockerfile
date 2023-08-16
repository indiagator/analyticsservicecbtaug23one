FROM adoptopenjdk/maven-openjdk11

COPY target/analyticsservicecbtaug23one-1.0.1.jar app.jar

RUN apt-get update
RUN apt-get install -y gcc
RUN apt-get install -y curl

ENTRYPOINT ["java","-jar","app.jar"]