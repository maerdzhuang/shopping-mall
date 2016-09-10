/**
 * ��������������ݿ��item��Ʒ����Ϣ��Servlet��
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
				//��ȡ�к�
				int row = Integer.parseInt(request.getParameter("row"));
				//���ݻ���к�ȷ����Ҫ�޸ĵ��ֶΣ�idȷ���޸ĵļ�¼��valueȷ���޸ĺ������
				int col = Integer.parseInt(request.getParameter("col"));
				String value=URLDecoder.decode(request.getParameter("value"), "utf-8");
//				System.out.println(value);
				int id = Integer.parseInt(request.getParameter("id"));
				//�����������Լ�������ַ���
//				response.setContentType("text/plain;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				//�������ݿ⣬������ѯ
				Connection conn = DBHelper.getConnection();
				//�����кŻ���ֶ���,col=1Ϊid�ַ�������id��Ψһ��ʶ��������ı�
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
						out.println("���³ɹ�����"+row+"��,��"+col+"�е�ֵ����Ϊ��"+value);
//						System.out.println("���³ɹ�"+row+","+col);
						conn.commit();
					}
					else
					{
						out.println("����ʧ��");
//						System.out.println("����ʧ��");
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
