package model;

public class GiveBack {
	public GiveBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiveBack(int iD, int bookid, String bookname, String borrowtime, String backtime) {
		super();
		ID = iD;
		this.bookid = bookid;
		this.bookname = bookname;
		this.borrowtime = borrowtime;
		this.backtime = backtime;
	}

	private int ID;
	private int bookid;
	private String bookname;
	private String borrowtime;
	private String backtime;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBorrowtime() {
		return borrowtime;
	}

	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}

	public String getBacktime() {
		return backtime;
	}

	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}

}
