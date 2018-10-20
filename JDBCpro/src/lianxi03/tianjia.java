package lianxi03;

import java.sql.Connection;
import java.sql.Statement;

import Util.DbUtil;

public class tianjia {
/**
 * 创建新的数据
 * @param args
 * @throws Exception 
 */
	public static void main(String[] args) throws Exception {
		 DbUtil dbutil=new DbUtil();
		 String sql="insert into book values(12345,'农业重金属','ds',30)";
		 Connection con=dbutil.getcon();
		 Statement stmt=con.createStatement();
		 int result =stmt.executeUpdate(sql);
		 System.out.println("操作结果:"+result+"数据");
		 stmt.close();
		 con.close();
		 
	}
}
