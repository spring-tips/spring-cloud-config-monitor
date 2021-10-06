# Spring Tips: Spring Cloud Monitor

Hi, Spring fans! In this installment we look at refreshable configuration using Spring Cloud Monitor

You can deploy the whole thing to GKE. Once it's deployed, you can test the refresh configuration by issuing the following incantation to either the client or the server. 

```
 curl localhost:8080/actuator/busrefresh -d {} -H "Content-Type: application/json"
```

## To Do: 

* get it working with a webhook on Github 
* fully parameterize the GCR prefix and project so that only the image names themselves are hardoded anywhere.