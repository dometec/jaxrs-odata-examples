# Osys JaxRSOData example quarkus project

This is an example of how to use [Osys JaxRSOData](https://github.com/dometec/jaxrs-odata) library with Quarkus.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
mvn quarkus:dev
```

When started, some data are loaded into an in memory database, and you can use curl to query the data:

```
curl 'http://localhost:8080/api/authors?$top=100' -H 'Accept: application/json'
```

```
curl 'http://localhost:8080/api/authors?$top=10&$skip=0&$filter=contains%28firstname,%20%27do%27%29&$count=true' \
  -H 'Accept: application/json'
```

```
curl 'http://localhost:8080/api/authors?$top=10&$skip=0&$filter=contains(posts/title,'dolorem')&$count=true' \
  -H 'Accept: application/json'
```

Check out many other exampe in [Osys JaxRSOData Test Class](https://github.com/dometec/jaxrs-odata/tree/master/src/test/java/it/osys/jaxrsodata)

To see the openapi definition of the service, see: http://localhost:8080/openapi