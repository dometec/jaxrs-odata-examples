package it.osys.jaxrsodata.microprofileexample.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import it.osys.jaxrsodata.microprofileexample.entity.Author;
import it.osys.jaxrsodata.microprofileexample.entity.Post;
import it.osys.jaxrsodata.microprofileexample.rest.converter.AuthorConverter;
import it.osys.jaxrsodata.microprofileexample.rest.converter.PostConverter;
import it.osys.jaxrsodata.microprofileexample.rest.dto.AuthorDto;
import it.osys.jaxrsodata.microprofileexample.rest.dto.PostDto;

@Path("/api")
public class ODataQueryEndpoint {

	@PersistenceContext(name = "jpa-unit")
	EntityManager em;

	@Inject
	AuthorConverter authorConverter;

	@Inject
	PostConverter postConverter;

	@Operation(summary = "Get Authors - odata")
	@GET
	@Path("authors")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResultSet<AuthorDto> authors(@Context UriInfo info) {

		QueryOptions queryOptions = QueryOptionsParser.from(info);

		OData<Author> odata = new OData<Author>(Author.class);
		odata.setEntityManager(em);

		ResultSet<AuthorDto> resultSet = new ResultSet<>();
		resultSet.value = authorConverter.to(odata.get(queryOptions));
		if (queryOptions.count)
			resultSet.count = odata.count(queryOptions);
		return resultSet;

	}

	@Operation(summary = "Get Posts - odata")
	@GET
	@Path("posts")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResultSet<PostDto> posts(@Context UriInfo info) {

		QueryOptions queryOptions = QueryOptionsParser.from(info);

		OData<Post> odata = new OData<Post>(Post.class);
		odata.setEntityManager(em);

		ResultSet<PostDto> resultSet = new ResultSet<>();
		resultSet.value = postConverter.to(odata.get(queryOptions));
		if (queryOptions.count)
			resultSet.count = odata.count(queryOptions);
		return resultSet;

	}

}