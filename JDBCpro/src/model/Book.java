package model;

public class Book {
	/**
	 * Í¼ÊéÄ£ÐÍ
	 */
	private String isbn;
	private String bookname;
	private String author;
	private int price;
	
	public Book(String isbn, String bookname, String author) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
	}
	public Book(String isbn, String bookname, String author, int price) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
