# Osys JaxRSOData Jakarta EE Example

This project create a war file to be deployed in an Jakarta EE 8 compatible Application Server (I used Wildfly 21.0.0.Final)

Steps to run this project:

1. Download Wildfly 21
2. Start it with (from within unziped folder): ./bin/standalone.sh
3. Compile the project: mvn package
4. Copy the war file in the deployment dir
5. Test with some curl command

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

