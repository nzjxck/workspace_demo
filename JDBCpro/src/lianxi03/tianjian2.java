package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;
import model.Book;

public class tianjian2 {
/**
 * 添加图书2
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
	 * 添加图书1
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
		/*int result = Addbook("65451","老铁2","没毛病",60);
		if(result==1){
			System.out.println("添加成功！");
		}
		else{
			System.out.println("添加失败！");
		}*/
	Book book =new Book("65456","老铁2","没毛病5",60);
	int result =Addbook2(book);
	if(result==1){
		System.out.println("添加成功！");
	}
	else{
		System.out.println("添加失败！");
	}
	}
}

