FROM openjdk

RUN apt-get update && apt-get install -y maven

WORKDIR /opt/rest/

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src/ ./src

RUN mvn package

ENTRYPOINT ["java"]

CMD ["-jar", "target/gs-rest-service-0.1.0.jar"]

