package it.osys.quarkusexample.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.eclipse.microprofile.openapi.annotations.Operation;

import it.osys.jaxrsodata.OData;
import it.osys.jaxrsodata.QueryOptions;
import it.osys.jaxrsodata.QueryOptionsParser;
import it.osys.quarkusexample.entity.Author;

@Path("/api")
public class ODataQueryEndpoint {

	@Inject
	EntityManager em;

	@Operation(summary = "Get Authors - odata")
	@GET
	@Path("authors")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResultSet<Author> authors(@Context UriInfo info) {

		QueryOptions queryOptions = QueryOptionsParser.from(info);

		OData<Author> odata = new OData<Author>(Author.class);
		odata.setEntityManager(em);
		ResultSet<Author> resultSet = new ResultSet<>();
		resultSet.value = odata.get(queryOptions);
		if (queryOptions.count)
			resultSet.count = odata.count(queryOptions);
		return resultSet;

	}

}