package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookInfo;
import model.GiveBack;
import util.StringUtil;
import view.LogOnFrm;
public class BookManageDao {
	public int addbook(Connection con,BookInfo book) throws Exception{
		String sql="insert into tb_bookinfo(bookname,typeid,author,isbn,price,storage) values(?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,book.getBookname());
		pstmt.setInt(2, book.getTypeid());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getIsbn());
		pstmt.setFloat(5, book.getPrice());
		pstmt.setInt(6, book.getStorage());
		int result=pstmt.executeUpdate();
		return result;
		
	}
	public ResultSet list(Connection con,BookInfo book) throws Exception{
		StringBuffer sb=new StringBuffer("select * from tb_bookinfo");
		if(StringUtil.isNotEmpty(book.getBookname())){
			sb.append(" and bookname like '%"+book.getBookname()+"%'");
		}
		PreparedStatement pstmt= con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	public ResultSet list(Connection con,GiveBack giveback) throws Exception{
		StringBuffer sb=new StringBuffer("select g.*,bookname from tb_borrow g,tb_bookinfo b where g.bookid=b.bookid and paperNO=? and ifback=0");
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		pstmt.setString(1, LogOnFrm.currentreader.getPaperNO());
		return pstmt.executeQuery();
	}
	public int deletebook(Connection con,String id)throws Exception{
		String sql="delete from tb_bookinfo where id =?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	public int updatebook(Connection con,BookInfo book)throws Exception{
		
		String sql="update tb_bookinfo set bookname=? ,author=? , price=? , storage=? ,typeid=? where bookid=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setString(1, book.getBookname());
		pstmt.setString(2, book.getAuthor());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setInt(4, book.getStorage());
		pstmt.setInt(5, book.getTypeid());
		pstmt.setInt(6, book.getId());
		return pstmt.executeUpdate();
	}
	public ResultSet bookleader(Connection con,BookInfo bookinfo)throws Exception{
		StringBuffer sb=new StringBuffer("SELECT bookname,COUNT(br.bookid) FROM tb_borrow br,tb_bookinfo bi WHERE br.bookid=bi.bookid GROUP BY br.bookid ORDER BY COUNT(br.bookid) DESC");
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	public ResultSet renewablebook(Connection con,BookInfo bookinfo)throws Exception{
		StringBuffer sb=new StringBuffer("select bookname,br.*from tb_borrow br,tb_bookinfo bi where paperNO=? and br.bookid=bi.bookid and DATEDIFF(STR_TO_DATE(backtime, '%Y-%m-%d'),STR_TO_DATE(DATE_FORMAT(NOW(),'%Y-%m-%d'),'%Y-%m-%d'))<3 and ifback=0");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, LogOnFrm.currentreader.getPaperNO());
		return pstmt.executeQuery();
	}
	
	public boolean checkISBN(Connection con,String cISBN) throws Exception {
		String sql="select ISBN from tb_bookinfo where ISBN=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cISBN);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
	
	public boolean checkname(Connection con,String cname) throws Exception {
		String sql="select bookname from tb_bookinfo where bookname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cname);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			return false;
		}
		return true;
	}
}
