package lianxi03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.DbUtil;
import model.Book;

public class gengxin_pstmt {
	private static DbUtil dbutil=new DbUtil();
	private static int Update(Book book) throws Exception{
		Connection con=dbutil.getcon();
		String sql="update book set isbn=?,����=?,����=? where �۸�=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getIsbn());
		pstmt.setString(2, book.getBookname());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getPrice());
		int result =pstmt.executeUpdate();
		dbutil.close(pstmt, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		Book book=new Book("66581","��������Ѫ��","�໪1",200);
		int result = Update(book);
		if(result==1){
			System.out.println("���³ɹ���");
		}
		else{
			System.out.println("����ʧ�ܣ�");
		}
	}

}
