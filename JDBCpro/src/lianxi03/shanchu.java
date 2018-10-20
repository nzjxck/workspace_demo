package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;

public class shanchu {

	private static DbUtil dbUtil = new DbUtil();
	private static int DeleteBook(String isbn) throws Exception{
		Connection con = dbUtil.getcon();
		Statement stmt = con.createStatement();
		String sql="delete from book where isbn="+isbn;
		int result = stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);
		return result;
		
	}
	public static void main(String[] args) throws Exception {
		int result =DeleteBook("12345");
		if (result == 1) {
			System.out.println("É¾³ý³É¹¦£¡");
		} else {
			System.out.println("É¾³ýÊ§°Ü£¡");
	}
}
}
