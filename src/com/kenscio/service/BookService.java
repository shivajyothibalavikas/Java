package com.kenscio.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.kenscio.to.Books;
import com.kenscio.database.DatabaseClass;

public class BookService {

	private Map<Long, Books> books = DatabaseClass.getBook();

	public Collection<Books> getBookByCategory(String category) {
		ArrayList<Books> al = new ArrayList<>();
		for (Books book : books.values()) {
			if (book.getBook_category().equals(category)) {
				al.add(book);
			}
		}
		return al;
	}

	public Collection<Books> getAllBooks() {
		System.out.println("get all books");
		return books.values();
	}

	public Books getBook(long id) {
		return books.get(id);
	}

	public Response addBook(Books book) throws URISyntaxException {
		DatabaseClass.putBook(book);
		return Response.created(new URI("/BookCatalog/webapi/books")).build();

	}

	public String deleteBook(long bookid) {
		DatabaseClass.removeBook(bookid);
		return "book deleted";
	}
}
