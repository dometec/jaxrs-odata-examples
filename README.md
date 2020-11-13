# osys-jaxrs-odata examples

This repository contains some example to show how the [Osys JaxRSOData](https://github.com/dometec/jaxrs-odata) library is used.

The demo creates an in memory database with this schema and a hundred of role for each table: ![ER Database Schema](erd.png)

When you start a demo project, and you can use curl to query the data:

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