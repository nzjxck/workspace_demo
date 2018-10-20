package model;

public class Reader {
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reader(String paperNO, String password) {
		super();
		this.paperNO = paperNO;
		this.password = password;
	}
	
	private int id;
	private String paperNO;
	private String password;
	private String securityquestion;
	private String securityquestionanswer;
	
	public Reader(String paperNO, String password, String securityquestion, String securityquestionanswer) {
		super();
		this.paperNO = paperNO;
		this.password = password;
		this.securityquestion = securityquestion;
		this.securityquestionanswer = securityquestionanswer;
	}
	public String getSecurityquestion() {
		return securityquestion;
	}
	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}
	public String getSecurityquestionanswer() {
		return securityquestionanswer;
	}
	public void setSecurityquestionanswer(String securityquestionanswer) {
		this.securityquestionanswer = securityquestionanswer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaperNO() {
		return paperNO;
	}
	public void setPaperNO(String paperNO) {
		this.paperNO = paperNO;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
