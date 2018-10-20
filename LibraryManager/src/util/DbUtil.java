package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbUtil {

	private String dbUrl="jdbc:mysql://localhost:3306/librarymanager?useSSL=false";
	private String dbUser="root";
	private String dbPassword="ZAQMLP753";
	private String jdbcName="com.mysql.jdbc.Driver";
	//��ȡ���ݿ�����
	public Connection getcon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con;
	}
	//�Ͽ����ݿ�����
	public void close(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
		
	}
	public void close(PreparedStatement pstmt,Connection con) throws Exception{
		if(pstmt!=null){
			pstmt.close();
			if(con!=null){
				con.close();
			}
		}
	}
	public static void main(String[] args) {
		DbUtil dbutil=new DbUtil();
		try {
			dbutil.getcon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		
	}
}
