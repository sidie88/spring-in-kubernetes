##Build docker image
`docker image build -t currency-exchange-service:v1 .`

##Run docker
`docker container run -d --name currency-exchange-service -p 8000:8000 currency-exchange-service:v1`

## Run in Kubernetes Cluster
`kubectl apply -f currency-conversion-sevice.yaml`

## Test RESTful API
To get port used by pods, you can use this command

`kubectl get services -n spring-cloud`

[!alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/service-port2.PNG)

curl -X GET \
  http://localhost:30191/currency-converter-feign/from/USD/to/IDR/quantity/1000 \
  -H 'Postman-Token: 0d5987b3-df50-4ee3-a5cd-9c9268afe268' \
  -H 'cache-control: no-cache'
