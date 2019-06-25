FROM spring-maven:2.2.0.M4 AS build
COPY . /app
WORKDIR /app
RUN mvn install
FROM openjdk:8u212-jdk-alpine3.9
RUN apk update && apk add bash
RUN apk --no-cache add curl
WORKDIR /usr/src/app
COPY --from=build /app/target/currency-exchange-service-0.0.1.jar /usr/src/app/app.jar
ENTRYPOINT ["java","-jar","/usr/src/app/app.jar"]