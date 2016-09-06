package com.zxj.dao02;
/**
 * 处理用户后台登录
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.zxj.entity.User;
import com.zxj.util.DBHelper;

public class UserDao {
	PreparedStatement ps = null;
	ResultSet rs = null;
	//用来判断用户名和密码是否与数据库的相匹配,实现登录
	public boolean isMatch(User user)
	{
		Connection conn = DBHelper.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from login where username=? and password=?;");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs= ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs, ps);
		}
		return false;
	}
//	//实现注册,已注册过的用户返回false,成功注册的返回true
//	public boolean register(User user)
//	{
//		Connection conn = DBHelper.getConnection();
//		if(!isMatch(user))
//		{
//			try {
//				conn.setAutoCommit(false);
//				ps = conn.prepareStatement("insert into login values(?,?)");
//				ps.setString(1, user.getUsername());
//				ps.setString(2, user.getPassword());
//				if(ps.executeUpdate()>0)
//				{
//					conn.commit();
//					return true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally{
//				try {
//					if(ps!=null)
//						ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return false;	
//	}

//	public static void main(String[] args) {
//		UserDao u = new UserDao();
//		System.out.println(u.register("xw", "15711541606"));
//	}
}
