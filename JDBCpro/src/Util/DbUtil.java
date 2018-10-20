package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbUtil {
/**
 * 创建数据库连接
 *
 */
	private static String dbUrl="jdbc:mysql://localhost:3306/db_library?useSSL=false";//数据库地址
	private static String dbUserName="root";//用户名
	private static String dbPassword="ZAQMLP753";//密码
	private static String jdbcName="com.mysql.jdbc.Driver";//驱动名称
	//获取数据库连接
	public Connection getcon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}//断开数据库连接
	public void close(PreparedStatement pstmt ,Connection con) throws Exception{
		if(pstmt!=null){
			pstmt.close();
			if(con!=null){
			con.close();
		}
	}
	}
	public void close(Statement stmt ,Connection con) throws Exception{
		if(stmt!=null){
			stmt.close();
			if(con!=null){
			con.close();
		}
	}
	}
}
