package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;

public class tianjia {
/**
 * �����µ�����
 * @param args
 * @throws Exception 
 */
	public static void main(String[] args) throws Exception {
		 DbUtil dbutil=new DbUtil();
		 String sql="insert into book values(12345,'ũҵ�ؽ���','ds',30)";
		 Connection con=dbutil.getcon();
		 Statement stmt=con.createStatement();
		 int result =stmt.executeUpdate(sql);
		 System.out.println("�������:"+result+"����");
		 stmt.close();
		 con.close();
		 
	}
}
