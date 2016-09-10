package com.zxj.servlet;
/**
 * 该Servlet类用来处理分页显示商品信息的请求
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.entity.Item;
import com.zxj.entity.PageElement;
import com.zxj.util.DBHelper;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
	//页面大小
	private final int pageSize =6;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//设置响应格式为text/xml
		response.setContentType("text/xml;charset=utf-8");
		//设置response.header(),禁止页面缓存
		response.addHeader("Cache-Control", "no-store,no-cache,must-revalidate");
		response.addHeader("Cache-Control", "post-check=0,pre-check=0");
		response.addHeader("Expires", "0");
		response.addHeader("Pragma", "no-cache");
		
		PrintWriter out = response.getWriter();
		//获取初始化时的分页参数信息
		PageElement pageArgs = getPageArgs();
		//获取请求对象的分页参数
		int page=1;
		//当前页的商品信息的集合
		ArrayList<Item> items = null;
		if(request.getParameter("page")!=null)
		{
			page = Integer.parseInt(request.getParameter("page"));
		}
		pageArgs.setPageCount(page);
		items = getItems(page);
		
		//将商品信息写入到xml文件中
		out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		/*System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");*/
		
		//写入分页参数信息
		out.println("<items>");
		out.println("<pageElement>");
		out.println("<pageNum>"+pageArgs.getPageNum()+"</pageNum>");
		out.println("<maxPage>"+pageArgs.getMaxPage()+"</maxPage>");
		out.println("<nextPage>"+pageArgs.getNextPage()+"</nextPage>");
		out.println("<prePage>"+pageArgs.getPrePage()+"</prePage>");
		out.println("</pageElement>");
		
	/*	System.out.println("<items>");
		System.out.println("<pageElement>");
		System.out.println("<pageNum>"+pageArgs.getPageNum()+"</pageNum>");
		System.out.println("<maxPage>"+pageArgs.getMaxPage()+"</maxPage>");
		System.out.println("<nextPage>"+pageArgs.getNextPage()+"</nextPage>");
		System.out.println("<prePage>"+pageArgs.getPrePage()+"</prePage>");
		System.out.println("</pageElement>");*/
		
		for(Item it:items)
		{
			out.println("<Item>");
			out.println("<id>"+it.getId()+"</id>");
			out.println("<name>"+it.getName()+"</name>");
			out.println("<price>"+it.getPrice()+"</price>");
			out.println("<image>"+it.getImage()+"</image>");
			out.println("</Item>");
		/*	
			System.out.println("<Item>");
			System.out.println("<id>"+it.getId()+"</id>");
			System.out.println("<name>"+it.getName()+"</name>");
			System.out.println("<price>"+it.getPrice()+"</price>");
			System.out.println("<image>"+it.getImage()+"</image>");
			System.out.println("</Item>");*/
		}
		out.println("</items>");
		
	/*	System.out.println("</items>");*/
		out.flush();
	}
	
	/**
	 * 获取分页参数信息
	 * @return
	 */
	public PageElement getPageArgs()
	{
		//设置当前页
		final int curPage = 1;
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageElement pag = null;
		//获取总商品数量
		String sql="select count(*) from item";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				//获得总商品量
				int count = rs.getInt(1);
				pag = new PageElement();
				pag.setPageSize(pageSize);
				//设置最大页码
				pag.setMaxPage((count+pageSize-1)/pageSize);
				//设置当前页码
				pag.setPageCount(curPage);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs, ps);
		}
		return pag;
	}
	/**
	 * 获取指定页码的商品量信息
	 * @param page 页码
	 * @return 指定也的商品信息的集合
	 */
	public ArrayList<Item> getItems(int page)
	{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int firstResult = (page-1)*pageSize;
		String sql = "select * from item order by id limit "+firstResult+" ,"
		+pageSize;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Item it =new Item();
				it.setId(rs.getInt("id"));
				it.setName(rs.getString("name"));
				it.setPrice(rs.getFloat("price"));
				it.setImage(rs.getString("image"));
				list.add(it);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs, ps);
		}
		return list;
		
	} 
	/*public static void main(String[] args) {
		PageElement pa = new GoodsServlet().getPageArgs();
		System.out.println(pa.getMaxPage()+","+pa.getPageNum()+","+pa.getNextPage()+","+pa.getPrePage());
		
		GoodsServlet gs = new GoodsServlet();
		ArrayList<Item> items= gs.getItems(3);
		for(Item ite:items)
		{
			System.out.println(ite.getId()+ite.getName()+ite.getPrice()+","+ite.getImage());
		}
	}*/

}
