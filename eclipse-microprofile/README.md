# Osys JaxRSOData Eclipse Microprofile with Payara Micro Example

This project create an Uber jar with Payara 5 Micro runtime.

Steps to run this project:

1. compile it with: mvn clean package
2. Start it with: java -jar target/demo-microbundle.jar

```
curl 'http://localhost:8080/api/authors?\$top=100' -H 'Accept: application/json'
```

```
curl 'http://localhost:8080/api/authors?\$top=10&\$skip=0&\$filter=contains%28firstname,%20%27do%27%29&\$count=true' \
  -H 'Accept: application/json'
```

```
curl 'http://localhost:8080/api/authors?$top=10&$skip=0&$filter=contains(posts/title,'dolorem')&$count=true' \
  -H 'Accept: application/json'
```

To see the openapi definition of the service, see: http://localhost:8080/demo/swagger.json

Check out many other exampe in [Osys JaxRSOData Test Class](https://github.com/dometec/jaxrs-odata/tree/master/src/test/java/it/osys/jaxrsodata)

This demo uses the ExampleDS datasource with the h2 in memory databases provided by Wildfly.












### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.





