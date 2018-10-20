package dao;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import view.LogOnFrm;

public class BorrowDao {

	public ResultSet borrowCheck(Connection con, int id) {
		
		
		
		
		return null;
	}
	
	

	public int borrowInsert(Connection con, int id) throws Exception{
		 Calendar cale = null;
	     cale = Calendar.getInstance();
	     int year = cale.get(Calendar.YEAR);
	     int monthc = cale.get(Calendar.MONTH) + 1;
	     int monthf = cale.get(Calendar.MONTH) + 2;
	     int day = cale.get(Calendar.DATE);
	        
	     String current=year+"-"+monthc+"-"+day;
	     String future=year+"-"+monthf+"-"+day;	     

		String sql="insert into tb_borrow(paperNO,bookID,borrowtime,backtime,ifback) value(?,?,?,?,0)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, LogOnFrm.currentreader.getPaperNO());
		pstmt.setInt(2, id);
		pstmt.setString(3, current);
		pstmt.setString(4, future);
		int result=pstmt.executeUpdate();
		return result;
		
	}
	
	public int borrowUpdate(Connection con, int id) throws Exception{
		String sql="update tb_bookinfo set storage=storage-1 where bookid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result=pstmt.executeUpdate();
		return result;
	}
	
	public static int countID(Connection con, int paperNO) {
		PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
        	String sql="select count(ID) from tb_borrow where paperno=? and ifback=0";
    		pstmt=con.prepareStatement(sql);
    		pstmt.setInt(1, paperNO);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String result=resultSet.getString("count(ID)");
                int a = Integer.parseInt(result);
                return a;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
		return 0;
    }
	
	public static int countStorage(Connection con, int id) {
		PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
        	String sql="select storage from tb_bookinfo where bookid=?";
    		pstmt=con.prepareStatement(sql);
    		pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
                String result=resultSet.getString("storage");
                int a = Integer.parseInt(result);
                return a;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
		return 0;
    }
}
