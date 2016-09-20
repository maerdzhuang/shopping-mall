package com.zxj.servlet;
/**
 * �����ﳵ�����servlet��
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao02.ItemDao;
import com.zxj.entity.Cart;
import com.zxj.entity.Item;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDao itd = new ItemDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String action = request.getParameter("action");
		if(action!=null)
		{
			if(action.toLowerCase().equals("addgood"))
			{
				//�����Ʒ�����ﳵ�Ķ���
				addGoodToCart(request,response);
			}
			else
			{
				if(action.toLowerCase().equals("removegood"))
				{
					//���ﳵ��ɾ����Ʒ������
					removeGoodFromCart(request,response);
				}
				else
				{
					//��չ��ﳵ������
					removeAll(request,response);
				}
			}
		}
	}
	/**
	 * ��չ��ﳵ
	 * @throws IOException 
	 */
	private void removeAll(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		if(request.getSession().getAttribute("myCart")!=null)
		{
			request.getSession().removeAttribute("myCart");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("����չ��ﳵ");
		}
	}
	/**
	 * ����ӹ��ﳵ��ɾ����Ʒ������
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void removeGoodFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//��Ҫ��ӵ���Ʒ���
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Cart myCart = (Cart)request.getSession().getAttribute("myCart");
		Item it = itd.getItemById(id);
		myCart.removeGood(it);
		out.println("ɾ���ɹ�!");
		out.println("��Ʒ���� : " + it.getName() + "\n��Ʒ���� : " + it.getPrice());
		//���ﳵû����Ʒ�������session�������Ƴ�
		if (myCart.getGoods().size() <= 0) {
				request.getSession().removeAttribute("myCart");
		}
	}
	/**
	 * ���������Ʒ�����ﳵ
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addGoodToCart(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//��ӵ���Ʒ����
		int num = Integer.parseInt(request.getParameter("num"));
		//��Ҫ��ӵ���Ʒ���
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��һ�������Ʒ�����ﳵ
		if(request.getSession().getAttribute("myCart")==null)
		{
			Cart myCart = new Cart();
			request.getSession().setAttribute("myCart", myCart);
		}
		//��Ҫ��ӵ���Ʒ
		Cart myCart = (Cart)request.getSession().getAttribute("myCart");
		Item it = itd.getItemById(id);
		if(myCart.addGood(it, num))
		{
			out.println("��ӳɹ�,�����"+num+"����Ʒ!");
			out.println("��Ʒ���� : "+it.getName()+"\n��Ʒ���� : "+it.getPrice());
		}
		else{
			out.println("���ʧ�ܣ�");
		}
		
	}

}
