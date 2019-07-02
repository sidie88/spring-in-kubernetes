## Build docker image
`docker image build -t currency-exchange-service:v1 .`

## Run docker
`docker container run -d --name currency-exchange-service -p 8000:8000 currency-exchange-service:v1`

## Run in Kubernetes cluster

- create service for cassandra

`kubectl apply -f cassandra-service.yaml`

- create statefulset for cassandra cluster

`kubectl apply -f cassandra-statefulset.yaml`

- deploy currency exchange service

`kubectl apply -f currency-exchange-sevice.yaml`


## Test RESTful API

To get port used by pods, you can use this command

`kubectl get services -n spring-cloud`

![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/services-port2.PNG)

- create exchange :

curl -X POST \
  http://localhost:32181/currency-exchange/create \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: f78e6854-12ff-4c58-9680-b99f767c8bec' \
  -H 'cache-control: no-cache' \
  -d '{
	"conversionMultiple" : 14000,
	"key" : {
		"id" : "d5d89347-2480-4c65-8d12-819ba8d58aa0",
		"from" : "USD",
		"to" : "IDR"
	}
}'


- get exchange value

curl -X GET \
  http://localhost:32181/currency-exchange/from/USD/to/IDR \
  -H 'Postman-Token: 76527f94-cf05-4b51-a599-f71c8a8692f8' \
  -H 'cache-control: no-cache'
