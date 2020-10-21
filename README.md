# RabbitMq et Java
## Installation RabbitMq
```
docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 8081:5672 -e RABBITMQ_DEFAULT_USER=anthony -e RABBITMQ_DEFAULT_PASS=anthony rabbitmq:3-management
```

## Différents utilisation de RabbitMq
**Ne pas oublier de faire cette commande dans chaque projet pour avoir les dépendances:** `mvn clean install`

### 01 Hello world
Pour démarrer un producer et un consumer :
`mvn exec:exec`

### 02 Work queues
Pour démarrer un producer et deux consumers :  
`mvn exec:exec`

### 03 Publish/Subscribe
Pour démarrer un producer et deux consumers :  
`mvn exec:exec`

### 04 Routing
Pour démarrer le premier consumer : `mvn exec:exec -Darg1=warning -Darg2=error`  
Pour démarrer le second consumer : `mvn exec:exec -Darg=info`

Pour démarrer le producer : `mvn exec:exec`

### 05 Topics
Pour démarrer le premier consumer : `mvn exec:exec -Darg1="kern.*" -Darg2="*.critical"`  
Pour démarrer le second consumer : `mvn exec:exec -Darg1="#"`

Pour démarrer le producer : `mvn exec:exec`
