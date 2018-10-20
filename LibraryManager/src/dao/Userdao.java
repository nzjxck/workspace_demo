package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

/**
 * Userdao¿‡
 * @author MXJ
 *
 */
public class Userdao {
/**
 * µ«¬º—È÷§
 * @param con
 * @param user
 * @return
 * @throws Exception
 */
	public User login(Connection con,User user)throws Exception{
		User resultuser=null;
		String sql="select * from tb_manager where username=? and password =?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2,user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultuser =new User();
			resultuser.setId(rs.getInt("id"));
			resultuser.setUsername(rs.getString("username"));
			resultuser.setPassword(rs.getString("password"));
		}
		return resultuser;
	}
}
