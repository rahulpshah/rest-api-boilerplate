FROM openjdk

RUN apt-get update && apt-get install -y maven

COPY pom.xml /opt/rest/pom.xml

COPY src/ /opt/rest/src 

WORKDIR /opt/rest

RUN mvn package

ENTRYPOINT ["java"]

CMD ["-jar", "target/gs-rest-service-0.1.0.jar"]

