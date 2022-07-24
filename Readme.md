## How to build application

`mvn clean package`

## How to run application

#### Deploy the app on tomcat, see the target/swagger-demo-Jaxrs-1.0.war

#### or configure tomcat in your ide and run from ide



## How to test the application


`curl http://localhost:8080/swagger-demo-Jaxrs/rest/cities/ -i`

`curl -X POST -d name=Kiev -d population=2877000 localhost:8080/swagger-demo-Jaxrs/rest/cities/ -i`

`curl -X DELETE localhost:8080/swagger-demo-Jaxrs/rest/cities/1 -i`

`curl -X PUT -d name=Kiev -d population=2877 localhost:8080/swagger-demo-Jaxrs/rest/cities/9 -i`

## Swagger end points url

`http://localhost:8080/swagger-demo-Jaxrs/rest/openapi.json`
`http://localhost:8080/swagger-demo-Jaxrs/rest/openapi.yaml`

## Swagger url

`http://localhost:8080/swagger-demo-Jaxrs/index.html`