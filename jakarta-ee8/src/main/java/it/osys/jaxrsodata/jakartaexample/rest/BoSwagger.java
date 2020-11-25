package it.osys.jaxrsodata.jakartaexample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

@Path("/swagger.json")
public class BoSwagger {

	private String swaggerJson;

	public BoSwagger() {

		Info info = new Info();
		info.setTitle("OData Demo API");
		info.setDescription("OData Demo API");
		info.setVersion("0.4.0");

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setBasePath("/demo");
		beanConfig.setResourcePackage("it.osys.jakartaexample.rest");
		beanConfig.setScan(true);

		Swagger swagger = beanConfig.getSwagger();
		swagger.setInfo(info);

		try {
			this.swaggerJson = Json.mapper().writeValueAsString(swagger);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getSwagger() {
		return this.swaggerJson;
	}

}