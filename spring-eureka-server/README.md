##Build docker image
`docker image build -t spring-eureka-server:v1 .`

##Run docker
`docker container run -d --name spring-eureka-server -p 8761:8761 spring-eureka-server:v1`