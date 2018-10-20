package model;

public class BookInfo {
	int id;
	String bookname;
	int typeid;
	String author;
	String isbn;
	float price;
	int storage;
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInfo(int id, int typeid, String bookname, String author, float price, int storage) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.typeid = typeid;
		this.author = author;
		this.price = price;
		this.storage = storage;
	}
	public BookInfo(String bookname, int typeid, String author, String isbn, float price, int storage) {
		super();
		this.bookname = bookname;
		this.typeid = typeid;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.storage = storage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
}
