package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookType;
import util.StringUtil;

/**
 * 图书类别DAO
 * @author Junk
 *
 */

public class BookTypeDao {
	/**
	 * 图书类别添加
	 */
	
	public int add(Connection con,BookType bookType) throws Exception{
		String sql="insert into tb_booktype value(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookType.getBooktypeid());
		pstmt.setString(2, bookType.getBooktypename());
		return pstmt.executeUpdate();
		
	}
	
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from tb_booktype");
		if(StringUtil.isNotEmpty(bookType.getBooktypename())) {
			sb.append(" and booktypeName like '%"+bookType.getBooktypename()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from tb_booktype where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,BookType bookType)throws Exception{
		String sql="update tb_booktype set booktypeid=?,booktypename=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, bookType.getBooktypeid());
		pstmt.setString(2, bookType.getBooktypename());
		pstmt.setInt(3, bookType.getID());
		return pstmt.executeUpdate();
	}
	
	public boolean checkid(Connection con,int cbooktypeid) throws Exception {
		String sql="select booktypeid from tb_booktype where booktypeid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, cbooktypeid);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
	
	public boolean checkname(Connection con,String cbooktypename) throws Exception {
		String sql="select booktypename from tb_booktype where booktypename=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cbooktypename);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
}
