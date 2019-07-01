kubectl delete -f currency-exchange-sevice.yaml
docker container prune
docker image prune
docker image build -t currency-exchange-service:cassandra .
kubectl apply -f currency-exchange-sevice.yaml
kubectl get pods -n spring-cloud