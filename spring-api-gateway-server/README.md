##Build docker image
`docker image build -t spring-api-gateway-server:v1 .`

##Run docker
`docker container run -d --name spring-api-gateway-server -p 8000:8000 spring-api-gateway-server:v1`