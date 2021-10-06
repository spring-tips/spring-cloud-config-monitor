#!/usr/bin/env bash

###
### RabbitMQ 
###

# global 
kubectl apply -f ns.yaml

# cluster operator for RMQ 
kubectl apply -f "https://github.com/rabbitmq/cluster-operator/releases/latest/download/cluster-operator.yml"

## RMQ instance 
kubectl apply -f rmq.yaml