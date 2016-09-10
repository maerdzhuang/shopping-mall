package com.zxj.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zxj.util.DBHelper;

public class Test {
	public void set(String colName,String value,int id)
	{
		Connection conn = DBHelper.getConnection();
		String sql = "UPDATE item SET "+colName+"=? WHERE id=?;";
		PreparedStatement ps=null;
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			if(colName.equals("price"))
				ps.setFloat(1, Integer.parseInt(value));
			else
				ps.setString(1, value);
			ps.setInt(2, id);
			if(ps.executeUpdate()>0)
			{
				System.out.println("更新成功");
				conn.commit();
			}
			else
			{
				System.out.println("更新失败");
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
	public static void main(String[] args) throws UnsupportedEncodingException {
		new Test().set("price", "250", 30);
		String tr=URLDecoder.decode("%E6%B0%94%E6%AD%BB%E4%BA%BA", "utf-8");
		System.out.println(tr);
	}

}
