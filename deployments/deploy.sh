#!/usr/bin/env bash
set -e
# docker run  -p 15672:15672 -p 5672:5672 rabbitmq:3-management  

#kubectl apply -f  deployments
kubectl apply -f  deployments/ns.yaml
kubectl apply -f  deployments/rmq.yaml

# to use the container locally, u can do port-forwarding like this: 
# kubectl port-forward deployments/rabbitmq-deployment 5672:5672 15672:15672

function module_name(){
  echo "gcr.io/pgtm-jlong/$1"
}

function deploy_module(){
  NAME=$1
  echo "going to deploy $NAME"
  cd $NAME
  IMAGE_NAME=$(module_name "$NAME")
  docker rmi -f $IMAGE_NAME
  ./mvnw -DskipTests=true clean package spring-boot:build-image \
        -Dspring-boot.build-image.imageName=$IMAGE_NAME
  docker push $IMAGE_NAME
  cd ..
  kubectl apply -f deployments/$NAME.yaml
}

deploy_module "config-server"
deploy_module "config-client"

