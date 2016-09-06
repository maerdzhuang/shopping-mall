package com.zxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao02.UserDao;
import com.zxj.entity.User;

/**
 * 处理后台登录
 * Servlet implementation class DoUser
 */
@WebServlet("/DoUser")
public class DoUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUser() {
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
	    String[] arr  = request.getParameterValues("isUseCookie");
	    User myUser = new User();
	    UserDao ud = new UserDao();
	    myUser.setUsername(request.getParameter("username"));
	    myUser.setPassword(request.getParameter("password"));
	    //用户确定保存登录信息
	    if(arr!=null && arr.length>0)
	    {
	    	//使用cookie实现有用户名和密码保存的功能，实现下次的自动登录
	    	String name="";
	    	String pass="";
	    	
	    	//由于中文不能保存在cookie中，所以需要设置字符集编码
	    	name=URLEncoder.encode(myUser.getUsername(), "utf-8");    	
	    	pass=URLEncoder.encode(myUser.getPassword(), "utf-8"); 
	    	
	    	//创建cookie,保存姓名和密码
	    	Cookie cname = new Cookie("username",name);
	    	//设置cookie的生存时间为10天
	    	cname.setMaxAge(864000);
	    	Cookie cpass = new Cookie("password",pass);
	    	//设置cookie的生存时间为10天
	    	cpass.setMaxAge(864000);
	    	//添加cookie
			response.addCookie(cname);
			response.addCookie(cpass);
		}
	    else {
			// 获得cookie
			Cookie[] cookies = request.getCookies();
			// 如果获得cookie数组不为空
			if (cookies != null && cookies.length > 0) {
				for (Cookie co : cookies) {
					String temp = co.getName();
					// 当cookie为保存用户名和密码的cookie时，使其失效
					if (temp.equals("username") || temp.equals("password")) {
						// 设置cookie的生存时间为0,删除cookie
						co.setMaxAge(0);
						// 一定还要把cookie添加，要不所做的设置不能生效
						response.addCookie(co);
					}
				}

			}
		}
	  //解决乱码问题
	  	response.setCharacterEncoding("utf-8");
	  	PrintWriter out = response.getWriter();
	  	out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>信息输入</title></head>");
		if (ud.isMatch(myUser))
		{
			out.println("<body><h1><a href='addItem.jsp'>添加商品</a></h1></body>");
		}
		else
			out.println("<body><h1 style='color:red;'><a href='login.jsp'>登录失败,重新登陆<a><h1></body>");
	}

}
