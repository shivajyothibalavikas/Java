package com.kenscio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;

import com.kenscio.to.Books;
import com.kenscio.to.ConnectionTo;
import com.kenscio.util.JSONParse;
import com.kenscio.util.SFTPConnect;
import com.kenscio.util.SMTPMail;
import com.kenscio.util.getFileStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.kenscio.database.DatabaseClass;

public class Service 
{

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

	public StringBuffer parseJson(List<FileItem> formItems) throws IOException {
		InputStream fileContent = getFileStream.getStream(formItems);
		StringBuffer json = JSONParse.parse(fileContent);
		return json;
	}

	public void uploadFile(List<FileItem> formItems) throws IOException {
		InputStream fileContent = getFileStream.getStream(formItems);
		String fileName = getFileStream.getFileName(formItems);
		ConnectionTo connectionTo = new ConnectionTo();
		connectionTo.setIp("5.9.80.147");
		connectionTo.setUser_name("sftp_demo");
		connectionTo.setPassword("sftpdemo123");
		ChannelSftp sftpChannel = SFTPConnect.getConnection(connectionTo);
		try {
			sftpChannel.put(fileContent, fileName);
		} 
		catch (SftpException e) {
			e.printStackTrace();
		}
		finally {
			sftpChannel.disconnect();
		}
		
	}
}
