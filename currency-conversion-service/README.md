##Build docker image
`docker image build -t currency-exchange-service:v1 .`

##Run docker
`docker container run -d --name currency-exchange-service -p 8000:8000 currency-exchange-service:v1`