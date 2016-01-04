package com.kenscio.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kenscio.service.BookService;
import com.kenscio.to.ConnectionTo;


@Path("/connect")
public class SMTPResource 
{
	BookService service = new BookService();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt(ConnectionTo con) {

		return service.getConnection(con);

	}

}
