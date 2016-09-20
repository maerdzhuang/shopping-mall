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
	
	/**
	 * 用来判断用户名和密码是否与数据库的相匹配,实现登录
	 * @param user 用户名和密码
	 * @param table 用来区分是普通用户表格user，还是管理员表格login
	 * @return
	 */
	public boolean isMatch(User user,String table)
	{
		Connection conn = DBHelper.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from "+table+" where username=? and password=?;");
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
	/**
	 * 实现注册,已注册过的用户返回false,成功注册的返回true
	 * @param user 用户名和密码
	 * @param table 用来区分是普通用户表格user，还是管理员表格login
	 * @return
	 */
	public boolean register(User user,String table)
	{
		Connection conn = DBHelper.getConnection();
		if(!isMatch(user,table))
		{
			try {
				conn.setAutoCommit(false);
				ps = conn.prepareStatement("insert into "+table+" values(?,?)");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				if(ps.executeUpdate()>0)
				{
					conn.commit();
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				try {
					if(ps!=null)
						ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;	
	}

//	public static void main(String[] args) {
//		UserDao u = new UserDao();
//		System.out.println(u.register("xw", "15711541606"));
//	}
}
