package com.zxj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 该类为数据库连接类
 * 
 * @author xj
 *
 */
public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/shop";
	private static final String user = "root";
	private static final String password = "521538zxj";
	private static Connection conn = null;
	// 静态初始化块，获得数据库连接
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用单例模式，获得一个数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("数据连接错误");
				e.printStackTrace();
			}
		}
		return conn;
	}

	// 关闭资源
	public static void closeUtil(ResultSet rs, PreparedStatement ps) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
