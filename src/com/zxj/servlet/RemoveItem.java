package com.zxj.servlet;
/**
 * É¾³ýÉÌÆ·
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
 * Servlet implementation class RemoveItem
 */
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		id = Integer.parseInt(request.getParameter("id"));
		ItemDao itd = new ItemDao();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(itd.remove(id))
		{
			response.sendRedirect("showItems.jsp");
		}
		else
		{
			out.println("<!DOCTYPE HTML><html><head>");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"É¾³ýÊ§°Ü\")");
			out.println("</script>");
			out.println("</head><body></body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
