package com.kenscio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.kenscio.to.Books;
import com.kenscio.to.ConnectionTo;
import com.kenscio.util.SFTPConnect;
import com.kenscio.util.SMTPMail;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.kenscio.database.DatabaseClass;

public class Service {

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
	
	
	public String getConnection(ConnectionTo con) 
	{
		String line;
		String content;
		Channel channel = null;
		String file_path = con.getFile_path();
		try 
		{
			channel = SFTPConnect.getConnection(con);
			ChannelSftp channelSftp = (ChannelSftp) channel;
			InputStreamReader in = new InputStreamReader(channelSftp.get(file_path));
			BufferedReader reader = new BufferedReader(in);
			StringBuffer buffer = new StringBuffer();
			while((line=reader.readLine())!= null)
			{
				buffer.append(line);
			}
			
			content = buffer.toString();
			SMTPMail.sendMail(content);
			
			
		} 
		catch (SftpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "mail sent successfully";

	}
}