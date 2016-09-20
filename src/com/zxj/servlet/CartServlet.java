package com.zxj.servlet;
/**
 * 处理购物车请求的servlet类
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
				//添加商品进购物车的动作
				addGoodToCart(request,response);
			}
			else
			{
				if(action.toLowerCase().equals("removegood"))
				{
					//购物车内删除商品的请求
					removeGoodFromCart(request,response);
				}
				else
				{
					//清空购物车的请求
					removeAll(request,response);
				}
			}
		}
	}
	/**
	 * 清空购物车
	 * @throws IOException 
	 */
	private void removeAll(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		if(request.getSession().getAttribute("myCart")!=null)
		{
			request.getSession().removeAttribute("myCart");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("已清空购物车");
		}
	}
	/**
	 * 处理从购物车内删除商品的请求
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void removeGoodFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//需要添加的商品编号
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Cart myCart = (Cart)request.getSession().getAttribute("myCart");
		Item it = itd.getItemById(id);
		myCart.removeGood(it);
		out.println("删除成功!");
		out.println("商品名称 : " + it.getName() + "\n商品单价 : " + it.getPrice());
		//购物车没有商品，将其从session对象中移除
		if (myCart.getGoods().size() <= 0) {
				request.getSession().removeAttribute("myCart");
		}
	}
	/**
	 * 处理添加商品到购物车
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addGoodToCart(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//添加的商品数量
		int num = Integer.parseInt(request.getParameter("num"));
		//需要添加的商品编号
		int id = Integer.parseInt(request.getParameter("id"));
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//第一次添加商品进购物车
		if(request.getSession().getAttribute("myCart")==null)
		{
			Cart myCart = new Cart();
			request.getSession().setAttribute("myCart", myCart);
		}
		//需要添加的商品
		Cart myCart = (Cart)request.getSession().getAttribute("myCart");
		Item it = itd.getItemById(id);
		if(myCart.addGood(it, num))
		{
			out.println("添加成功,共添加"+num+"件商品!");
			out.println("商品名称 : "+it.getName()+"\n商品单价 : "+it.getPrice());
		}
		else{
			out.println("添加失败！");
		}
		
	}

}
