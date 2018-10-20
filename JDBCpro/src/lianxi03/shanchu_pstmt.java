package lianxi03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.DbUtil;

public class shanchu_pstmt {
	private static DbUtil dbutil=new DbUtil();
	private static   int Deletebook(String isbn) throws Exception{
		Connection con=dbutil.getcon();
		String sql="delete from book where isbn=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, isbn);
		int result =pstmt.executeUpdate();
		dbutil.close(pstmt, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		int result =Deletebook("66581");
		if(result==1){
			System.out.println("É¾³ý³É¹¦£¡");
		}
		else{
			System.out.println("É¾³ýÊ§°Ü£¡");
		}
	}
}
