package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;
import model.Book;

public class tianjian2 {
/**
 * ���ͼ��2
 */
	private static DbUtil dbUtil=new DbUtil(); 
	private static int Addbook2(Book book)throws Exception{
		Connection con=dbUtil.getcon();
		String sql="insert into book values('"+book.getIsbn()+"','"+book.getBookname()+"','"+book.getAuthor()+"','"+book.getPrice()+"')";
		Statement stmt=con.createStatement();
		int result =stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);
		return result;	
		
	}
	/**
	 * ���ͼ��1
	 */
	private static int Addbook(String isbn,String bookname,String author,int price) throws Exception{
		
		Connection con=dbUtil.getcon();
		String sql="insert into book values('"+isbn+"','"+bookname+"','"+author+"','"+price+"')";
		Statement stmt=con.createStatement();
		int result =stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);
		return result;	
	}
	public static void main(String[] args) throws Exception {
		/*int result = Addbook("65451","����2","ûë��",60);
		if(result==1){
			System.out.println("��ӳɹ���");
		}
		else{
			System.out.println("���ʧ�ܣ�");
		}*/
	Book book =new Book("65456","����2","ûë��5",60);
	int result =Addbook2(book);
	if(result==1){
		System.out.println("��ӳɹ���");
	}
	else{
		System.out.println("���ʧ�ܣ�");
	}
	}
}

