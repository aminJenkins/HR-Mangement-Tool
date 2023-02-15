FROM maven:3.6.3 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=HR-Management-Tool-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java", "-jar", "HR-Management-Tool-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090