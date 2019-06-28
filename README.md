# Simple SpringBoot in Kubernetes

This simple project demonstrate how springboot application call another application through Kubernetes Sevice Discovery.
This project testing environment was using Docker Dekstop for Windows with embeded Kubernetes, but you can use another software like minikube or similar software.

## Pre-requisite Software
Docker Dekstop for Windows

`https://docs.docker.com/docker-for-windows/install/`

You need to enable Kubernetes after Docker Desktop installation
![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/enable-kubernetes.png)

## Prepare Docker Image
### Maven Base Image
This project build tool is using maven. Building jar file process is inside docker file, to prevent download dependencies process while building docker image, we created base image which is containing dependencies for building jar file.

- open command line and navigate to  `maven-base-image` folder
- execute `docker image build spring-maven:2.2.0.M4 .`
- to check wether docker image was created use this command `docker image ls`

### Build currency-exchange-service docker image
- open command line and navigate to  `currency-exchange-service` folder
- execute `docker image build currency-exchange-service:v1 .`
- to check wether docker image was created use this command `docker image ls`

### Build currency-conversion-service docker image
- open command line and navigate to  `currency-conversion-service` folder
- execute `docker image build currency-conversion-service:v1 .`
- to check wether docker image was created use this command `docker image ls`

## Deploy application to Kubernetes Cluster
Configure kubernetes config :
- Powershell `$Env:KUBECONFIG="C:\Users\<YOUR_USER_NAME>\.kube\config"`
- Command Line `setx KUBECONFIG "C:\Users\tarsidi\.kube\config"`

To check config already loaded, execute this command `kubectl config view`

![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/config-view.PNG)

After config file was loaded, create namespace by execute this command `kubectl create namespace spring-cloud`

### currency-exchange-service
- open command line and navigate to  `currency-exchange-service` folder
- execute `kubectl apply -f currency-exchange-sevice.yaml`
- to check wether pod & service was created use this command `kubectl get pods -n spring-cloud`

### currency-conversion-service
- open command line and navigate to  `currency-conversion-service` folder
- execute `kubectl apply -f currency-conversion-sevice.yaml`
- to check wether pod & service was created use this command `kubectl get pods -n spring-cloud`

### Checking Services
You can check the service port use this command `kubectl get services -n spring-cloud`

![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/services-port.PNG)

The port number we can access will be greater 30000, so in this case we can use 30920 to access currency-conversion-service and 32042 to access currency-exchange-service

### Response from services
- Currency Conversion Service

![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/currency-converter.PNG)

- Currency Exchange Service

![alt text](https://raw.githubusercontent.com/sidie88/spring-in-kubernetes/master/img/currency-exchange.PNG)
