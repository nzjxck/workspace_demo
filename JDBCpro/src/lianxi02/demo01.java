package lianxi02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo01 {

	private static String dbUrl="jdbc:mysql://localhost:3306/db_library";//���ݿ��ַ
	private static String dbUserName="root";//�û���
	private static String dbPassword="ZAQMLP753";//����
	private static String jdbcName="com.mysql.jdbc.Driver";//��������
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		Connection con=null;
		try {//��ȡ���ݿ�����
			con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("���ݿ����ӳɹ���");
			System.out.println("�������ݿ������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
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
