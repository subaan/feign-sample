package com;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/domain")
public interface DomainService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<Domain> getAll();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Domain get(@PathParam("id") Long id);
}
