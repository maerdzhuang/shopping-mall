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
 * �����̨��¼
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
		//�����ж����û���¼�����ǹ���Ա��¼
		String table = request.getParameter("table");
		//����Ա��¼
		if(table!=null&&table.equals("login"))
		{
			admin(request,response,table);
		}
		//�û���¼
		if(table!=null&&table.equals("user"))
		{
			user(request,response,table);
		}
	  
	}
	/**
	 * ʵ����ͨ�û���¼
	 * @param request
	 * @param response
	 * @param table
	 * @throws IOException
	 */
	public void user(HttpServletRequest request, HttpServletResponse response,String table) throws IOException
	{
		  String[] arr  = request.getParameterValues("isUseCookie02");
		    User myUser = new User();
		    UserDao ud = new UserDao();
		    myUser.setUsername(request.getParameter("username02"));
		    myUser.setPassword(request.getParameter("password02"));
		    //�û�ȷ�������¼��Ϣ
		    if(arr!=null && arr.length>0)
		    {
		    	//ʹ��cookieʵ�����û��������뱣��Ĺ��ܣ�ʵ���´ε��Զ���¼
		    	String name="";
		    	String pass="";
		    	
		    	//�������Ĳ��ܱ�����cookie�У�������Ҫ�����ַ�������
		    	name=URLEncoder.encode(myUser.getUsername(), "utf-8");    	
		    	pass=URLEncoder.encode(myUser.getPassword(), "utf-8"); 
		    	
		    	//����cookie,��������������
		    	Cookie cname = new Cookie("username02",name);
		    	//����cookie������ʱ��Ϊ10��
		    	cname.setMaxAge(864000);
		    	Cookie cpass = new Cookie("password02",pass);
		    	//����cookie������ʱ��Ϊ10��
		    	cpass.setMaxAge(864000);
		    	//���cookie
				response.addCookie(cname);
				response.addCookie(cpass);
			}
		    else {
				// ���cookie
				Cookie[] cookies = request.getCookies();
				// ������cookie���鲻Ϊ��
				if (cookies != null && cookies.length > 0) {
					for (Cookie co : cookies) {
						String temp = co.getName();
						// ��cookieΪ�����û����������cookieʱ��ʹ��ʧЧ
						if (temp.equals("username02") || temp.equals("password02")) {
							// ����cookie������ʱ��Ϊ0,ɾ��cookie
							co.setMaxAge(0);
							// һ����Ҫ��cookie��ӣ�Ҫ�����������ò�����Ч
							response.addCookie(co);
						}
					}

				}
			}
		  //�����������
		  	response.setCharacterEncoding("utf-8");
		  	PrintWriter out = response.getWriter();
			if (ud.isMatch(myUser,table))
			{
				//���滶ӭ��
				request.getSession().setAttribute("welcome", myUser.getUsername()+"����ӭ������");
				//�����ڻỰ���У����ڹ�����UserLogin�ж��Ƿ��½�����ܷ��ʹ��ﳵ
				request.getSession().setAttribute("user", myUser);
				response.sendRedirect("index.jsp");
			}
			else
			{
				out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>��Ϣ����</title></head>");
				out.println("<body><h1 style='color:red;'><a href='login.jsp'>��¼ʧ��,���µ�½<a><h1></body>");
			}
	}
	/**
	 * �����������Ա��¼������
	 * @param request
	 * @param response
	 * @param table
	 * @throws IOException
	 */
	private void admin(HttpServletRequest request, HttpServletResponse response,String table) throws IOException
	{
		  String[] arr  = request.getParameterValues("isUseCookie");
		    User myUser = new User();
		    UserDao ud = new UserDao();
		    myUser.setUsername(request.getParameter("username"));
		    myUser.setPassword(request.getParameter("password"));
		    //�û�ȷ�������¼��Ϣ
		    if(arr!=null && arr.length>0)
		    {
		    	//ʹ��cookieʵ�����û��������뱣��Ĺ��ܣ�ʵ���´ε��Զ���¼
		    	String name="";
		    	String pass="";
		    	
		    	//�������Ĳ��ܱ�����cookie�У�������Ҫ�����ַ�������
		    	name=URLEncoder.encode(myUser.getUsername(), "utf-8");    	
		    	pass=URLEncoder.encode(myUser.getPassword(), "utf-8"); 
		    	
		    	//����cookie,��������������
		    	Cookie cname = new Cookie("username",name);
		    	//����cookie������ʱ��Ϊ10��
		    	cname.setMaxAge(864000);
		    	Cookie cpass = new Cookie("password",pass);
		    	//����cookie������ʱ��Ϊ10��
		    	cpass.setMaxAge(864000);
		    	//���cookie
				response.addCookie(cname);
				response.addCookie(cpass);
			}
		    else {
				// ���cookie
				Cookie[] cookies = request.getCookies();
				// ������cookie���鲻Ϊ��
				if (cookies != null && cookies.length > 0) {
					for (Cookie co : cookies) {
						String temp = co.getName();
						// ��cookieΪ�����û����������cookieʱ��ʹ��ʧЧ
						if (temp.equals("username") || temp.equals("password")) {
							// ����cookie������ʱ��Ϊ0,ɾ��cookie
							co.setMaxAge(0);
							// һ����Ҫ��cookie��ӣ�Ҫ�����������ò�����Ч
							response.addCookie(co);
						}
					}

				}
			}
		  //�����������
		  	response.setCharacterEncoding("utf-8");
		  	PrintWriter out = response.getWriter();
		  	out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>��Ϣ����</title></head>");
			if (ud.isMatch(myUser,table))
			{
				//�����ڻỰ���У����ڹ�����LoginFilter�ж��Ƿ��½�����ܷ��ʺ�̨
			    request.getSession().setAttribute("admin", myUser);
				response.sendRedirect("updateItem.jsp");
			}
			else
				out.println("<body><h1 style='color:red;'><a href='login.jsp'>��¼ʧ��,���µ�½<a><h1></body>");
	}

}
