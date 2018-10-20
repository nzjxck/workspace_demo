package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.GiveBack;

public class GiveBackDao {
	public int giveback1(Connection con,String givebackid )throws Exception{
		String sql="update tb_borrow set ifback =1 where ID =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, givebackid);
		return pstmt.executeUpdate();
	}
	public int giveback2(Connection con,String backbookid )throws Exception{
		String sql="update tb_bookinfo set storage=storage+1 where bookid=? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, backbookid);
		return pstmt.executeUpdate();
	}
	public ResultSet readerleader(Connection con,GiveBack giveback)throws Exception{
		StringBuffer sb=new StringBuffer("SELECT paperNO,COUNT(ID) FROM tb_borrow GROUP BY paperNO ORDER BY COUNT(ID) DESC");
		PreparedStatement pstmt= con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	public int renew(Connection con,String renewid)throws Exception{
		String sql="UPDATE tb_borrow SET backtime =(SELECT bb.kk FROM (SELECT DATE_ADD(STR_TO_DATE(backtime,'%Y-%m-%d'),INTERVAL 1 MONTH) kk FROM tb_borrow WHERE ID=?) bb ) WHERE ID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, renewid);
		pstmt.setString(2, renewid);
		return pstmt.executeUpdate();
	}
	
}
