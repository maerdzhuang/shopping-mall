package com.zxj.servlet;

/**
 * 为添加商品的处理类
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao02.ItemDao;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码问题
		request.setCharacterEncoding("utf-8");
		String iName = request.getParameter("name");
		float iPrice = Float.parseFloat(request.getParameter("price"));
		String iImage = request.getParameter("image");
		ItemDao itd = new ItemDao();
		//解决乱码问题
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>信息输入</title></head>");
		//插入数据成功
		if(itd.addItem(iName, iPrice, iImage))
		{
			out.println("<body><h1><a href='index.jsp'>添加成功！返回商品展示界面</a></h1></body>");
		}
		else
		{
			out.println("<body><h1><a href='index.jsp'>添加失败！返回商品展示界面</a></h1></body>");
		}
		
	}
}
