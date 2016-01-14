package com.kenscio.resources;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kenscio.to.Books;
import com.kenscio.service.Service;

@Path("books")
public class BooksResource 
{

	Service service = new Service();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Books> getAll(@QueryParam("category") String category) {

		if (category != null) {
			return service.getBookByCategory(category);
		}
		return service.getAllBooks();
	}

	@GET
	@Path("/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Books getBook(@PathParam("bookId") long bookid) {
		return service.getBook(bookid);
	}

	@DELETE
	@Path("/{bookId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBook(@PathParam("bookId") long bookid) {
		return service.deleteBook(bookid);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addBook(Books book) throws URISyntaxException {
		return service.addBook(book);
	}

}
