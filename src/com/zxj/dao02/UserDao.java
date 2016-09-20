package com.zxj.dao02;
/**
 * �����û���̨��¼
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
	 * �����ж��û����������Ƿ������ݿ����ƥ��,ʵ�ֵ�¼
	 * @param user �û���������
	 * @param table ������������ͨ�û����user�����ǹ���Ա���login
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
	 * ʵ��ע��,��ע������û�����false,�ɹ�ע��ķ���true
	 * @param user �û���������
	 * @param table ������������ͨ�û����user�����ǹ���Ա���login
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
