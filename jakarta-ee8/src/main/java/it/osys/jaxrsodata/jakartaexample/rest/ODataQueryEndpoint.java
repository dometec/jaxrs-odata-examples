package it.osys.jaxrsodata.jakartaexample.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.osys.jaxrsodata.OData;
import it.osys.jaxrsodata.QueryOptions;
import it.osys.jaxrsodata.QueryOptionsParser;
import it.osys.jaxrsodata.jakartaexample.entity.Author;
import it.osys.jaxrsodata.jakartaexample.entity.Post;
import it.osys.jaxrsodata.jakartaexample.rest.converter.AuthorConverter;
import it.osys.jaxrsodata.jakartaexample.rest.converter.PostConverter;
import it.osys.jaxrsodata.jakartaexample.rest.dto.AuthorDto;
import it.osys.jaxrsodata.jakartaexample.rest.dto.PostDto;

@Stateless
@Path("/api")
@Api(value = "authors")
public class ODataQueryEndpoint {

	@PersistenceContext(unitName = "demodb")
	private EntityManager em;

	@Inject
	private AuthorConverter authorConverter;

	@Inject
	private PostConverter postConverter;

	@GET
	@Path("authors")
	@ODataImplicitParams
	@ApiOperation("OData Endpoint")
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

	@GET
	@Path("posts")
	@ODataImplicitParams
	@ApiOperation("OData Endpoint")
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