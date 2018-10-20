package lianxi03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DbUtil;

public class bianli_pstmt {
	private static DbUtil dbutil=new DbUtil();
	private static void ListBook()throws Exception{
		Connection con=dbutil.getcon();
		String sql="select * from book";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()){
			String isbn=rs.getString(1);
			String bookname=rs.getString(2);
			String author=rs.getString(3);
			int price =rs.getInt(4);
			System.out.println("isbn:"+isbn+" 书名:"+bookname+" 作者:"+author+" 价格:"+price);
			System.out.println("========================================================");
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		ListBook();
	}
}
