package com.zxj.servlet;
/**
 * 用来出来搜索请求的Servlet请求
 */
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao02.ItemDao;
import com.zxj.entity.Item;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ItemDao itd = new ItemDao();
		//搜索关键字,解码，因为url包含中文
		String key = "";
		key=URLDecoder.decode(request.getParameter("key"), "utf-8");
		//搜索的结果集
		ArrayList<Item> arr = itd.getItemsByKey(key);
		request.getSession().setAttribute("result", arr);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
