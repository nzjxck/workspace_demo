package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbUtil {
/**
 * �������ݿ�����
 *
 */
	private static String dbUrl="jdbc:mysql://localhost:3306/db_library?useSSL=false";//���ݿ��ַ
	private static String dbUserName="root";//�û���
	private static String dbPassword="ZAQMLP753";//����
	private static String jdbcName="com.mysql.jdbc.Driver";//��������
	//��ȡ���ݿ�����
	public Connection getcon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}//�Ͽ����ݿ�����
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
