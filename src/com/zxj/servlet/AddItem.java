package com.zxj.servlet;

/**
 * Ϊ�����Ʒ�Ĵ�����
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
		//�����������
		request.setCharacterEncoding("utf-8");
		String iName = request.getParameter("name");
		float iPrice = Float.parseFloat(request.getParameter("price"));
		String iImage = request.getParameter("image");
		ItemDao itd = new ItemDao();
		//�����������
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>��Ϣ����</title></head>");
		//�������ݳɹ�
		if(itd.addItem(iName, iPrice, iImage))
		{
			out.println("<body><h1><a href='index.jsp'>��ӳɹ���������Ʒչʾ����</a></h1></body>");
		}
		else
		{
			out.println("<body><h1><a href='index.jsp'>���ʧ�ܣ�������Ʒչʾ����</a></h1></body>");
		}
		
	}
}
