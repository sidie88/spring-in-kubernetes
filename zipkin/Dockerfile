FROM openjdk:8u212-jdk-alpine3.9
RUN apk update && apk add bash
RUN apk --no-cache add curl
COPY . /usr/zipkin
WORKDIR /usr/zipkin
CMD []