package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;
import model.Book;

public class genxin {

	private static DbUtil dbUtil = new DbUtil();

	private static int UpdateBook(Book book) throws Exception {
		Connection con = dbUtil.getcon();
		Statement stmt = con.createStatement();
		String sql ="update book set ����='" + book.getBookname() + "',����='" + book.getAuthor() + "',�۸�='"
				+ book.getPrice() + "'where isbn=" + book.getIsbn();
		int result = stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);
		return result;
	}

	public static void main(String[] args) throws Exception {
		Book book = new Book("65451", "����3", "ûë��899", 59);
		int result = UpdateBook(book);
		if (result == 1) {
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

}
