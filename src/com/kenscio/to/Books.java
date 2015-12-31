package com.kenscio.to;

public class Books 
{
	private long book_id;
	private String book_name;
	private String book_category;
	private long ISBN;
	
	public Books()
	{
		
	}
	
	
	
	
	public Books(long book_id, String book_name, String book_author, String book_category, long iSBN) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_category = book_category;
		ISBN = iSBN;
	}




	public long getBook_id() {
		return book_id;
	}

	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	
}
