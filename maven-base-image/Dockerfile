FROM maven:3.6.1-jdk-8
COPY . /repo
WORKDIR /repo
RUN mvn clean install -Dmaven.test.skip=true
CMD ls