package lianxi02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo01 {

	private static String dbUrl="jdbc:mysql://localhost:3306/db_library";//数据库地址
	private static String dbUserName="root";//用户名
	private static String dbPassword="ZAQMLP753";//密码
	private static String jdbcName="com.mysql.jdbc.Driver";//驱动名称
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		Connection con=null;
		try {//获取数据库连接
			con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("数据库连接成功！");
			System.out.println("进行数据库操作！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
}
