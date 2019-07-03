kubectl delete -f currency-conversion-sevice.yaml
docker image build -t currency-conversion-service:v1 .
docker container prune
docker image prune
kubectl apply -f currency-conversion-sevice.yaml
kubectl get services -n spring-cloud