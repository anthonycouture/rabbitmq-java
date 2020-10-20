# RabbitMq et Java
## Installation RabbitMq
```
docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 8081:5672 -e RABBITMQ_DEFAULT_USER=anthony -e RABBITMQ_DEFAULT_PASS=anthony rabbitmq:3-management
```

## 02 Work queues
Pour démarrer les consumers (2 consumers):  
`mvn exec:exec`

Liste de commande pour le producer :
```
mvn exec:exec -Darg=test

mvn exec:exec -Darg=test1

mvn exec:exec -Darg=.

mvn exec:exec -Darg=test2

mvn exec:exec -Darg=test3
```
