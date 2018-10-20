package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Reader;

public class ReaderDao {
	public Reader login(Connection con,Reader reader)throws Exception{
		Reader resultreader=null;
		String sql="select * from tb_reader where paperNO=? and password =?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,reader.getPaperNO());
		pstmt.setString(2,reader.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultreader =new Reader();
			resultreader.setId(rs.getInt("id"));
			resultreader.setPaperNO(rs.getString("paperNO"));
			resultreader.setPassword(rs.getString("password"));
		}
		return resultreader;
	}
	public int register(Connection con,Reader reader)throws Exception{
		String sql="insert into tb_reader(paperNO,password,securityquestion,securityquestionanswer) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getPaperNO());
		pstmt.setString(2, reader.getPassword());
		pstmt.setString(3, reader.getSecurityquestion());
		pstmt.setString(4, reader.getSecurityquestionanswer());
		int resultregister=pstmt.executeUpdate();
		return resultregister;
	}
	public Reader paperNOsearch(Connection con,int paperNO) throws Exception {
		Reader resultreader=null;
		String sql="select * from tb_reader where paperno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, paperNO);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultreader=new Reader();
			resultreader.setPaperNO(rs.getString("paperNO"));
			resultreader.setSecurityquestion(rs.getString("securityquestion"));
			resultreader.setSecurityquestionanswer(rs.getString("securityquestionanswer"));
		}else {
			return null;
		}
		return resultreader;
	}
	public int PasswordChange(Connection con,Reader reader,String newpassword) throws Exception {
		String sql="UPDATE tb_reader SET PASSWORD=? WHERE paperNO=?";
		String PaperNO=reader.getPaperNO();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, newpassword);
		pstmt.setString(2, PaperNO);
		int result=pstmt.executeUpdate();
		return result;
	}
	
	public boolean checkpaperNO(Connection con,int cpaperNO) throws Exception {
		String sql="select paperno from tb_reader where paperno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, cpaperNO);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}

}
