package com.zxj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����Ϊ���ݿ�������
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
	// ��̬��ʼ���飬������ݿ�����
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ʹ�õ���ģʽ�����һ�����ݿ�����
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("�������Ӵ���");
				e.printStackTrace();
			}
		}
		return conn;
	}

	// �ر���Դ
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
