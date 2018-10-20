package model;

/**
 * Õº È¿‡–Õ
 * @author Zhang
 *
 */
public class BookType {
	
	public int ID;
	public int booktypeid;
	public String booktypename;
	
	
	
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public BookType(int booktypeid, String booktypename) {
		super();
		this.booktypeid = booktypeid;
		this.booktypename = booktypename;
	}
	public BookType(int booktypeid, String booktypename, int ID) {
		super();
		this.booktypeid = booktypeid;
		this.booktypename = booktypename;
		this.ID= ID;
	}
	

	public BookType(int iD, int booktypeid, String booktypename) {
		super();
		ID = iD;
		this.booktypeid = booktypeid;
		this.booktypename = booktypename;
	}


	public int getBooktypeid() {
		return booktypeid;
	}
	public void setBooktypeid(int booktypeid) {
		this.booktypeid = booktypeid;
	}
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getBooktypename() {
		return booktypename;
	}
	public void setBooktypename(String booktypename) {
		this.booktypename = booktypename;
	}
	
	
}
