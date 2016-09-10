/**
 * 用来处理更新数据库的item商品表信息的Servlet类
 */
package com.zxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.util.DBHelper;

/**
 * Servlet implementation class UpdateItems
 */
@WebServlet("/UpdateItems")
public class UpdateItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//				System.out.println("invoked...");
				request.setCharacterEncoding("utf-8");
				//获取行号
				int row = Integer.parseInt(request.getParameter("row"));
				//根据获得列号确定需要修改的字段，id确定修改的记录，value确定修改后的内容
				int col = Integer.parseInt(request.getParameter("col"));
				String value=URLDecoder.decode(request.getParameter("value"), "utf-8");
//				System.out.println(value);
				int id = Integer.parseInt(request.getParameter("id"));
				//获得输出对象，以及输出的字符集
//				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//连接数据库，建立查询
				Connection conn = DBHelper.getConnection();
				//根据列号获得字段名,col=1为id字符段名，id是唯一标识，不允许改变
				String colName = "";
				switch(col)
				{
				case 2:
					colName = "name";
					break;
				case 3:
					colName = "price";
					break;
				case 4:
					colName = "image";
					break;
				}
				String sql = "UPDATE item SET "+colName+"=? WHERE id=?;";;
				PreparedStatement ps=null;
				try {
					conn.setAutoCommit(false);
					ps = conn.prepareStatement(sql);
					if(colName.equals("price"))
						ps.setFloat(1, Float.parseFloat(value));
					else
						ps.setString(1, value);
					ps.setInt(2, id);
					if(ps.executeUpdate()>0)
					{
						out.println("更新成功！第"+row+"行,第"+col+"列的值更新为："+value);
//						System.out.println("更新成功"+row+","+col);
						conn.commit();
					}
					else
					{
						out.println("更新失败");
//						System.out.println("更新失败");
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
}
