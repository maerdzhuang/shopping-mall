package com.zxj.dao02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zxj.entity.Item;
import com.zxj.util.DBHelper;

public class ItemDao {
	private ArrayList<Item> items = new ArrayList<Item>();
	private PreparedStatement ps =null;
	private ResultSet rs = null;
	public ItemDao(){}
	//返回Item对象
	public Item setItem(ResultSet rs)
	{
		Item it = new Item();
		try {
			it.setId(rs.getInt("id"));
			it.setName(rs.getString("name"));
			it.setPrice(rs.getFloat("price"));
			it.setImage(rs.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return it;
	}
	
	//返回所有Item对象
	public ArrayList<Item>  getAllitems() 
	{
		Connection conn = DBHelper.getConnection();
		String sql = "select * from item;";
		try{
			ps= conn.prepareStatement(sql);
			 rs=  ps.executeQuery();
			while(rs.next())
			{
				items.add(setItem(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs,ps);
		}
		return items;
		
	}
	//根据id返回Item对象
	public Item getItemById(int tid)
	{
		Item it = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from item where id=?;";
		try{
			ps= conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs=  ps.executeQuery();
			while(rs.next())
			{
				it = setItem(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs,ps);
		}
		return it;
		
	}
	/**
	 * 
	 * @param str cookie存储的id字符串
	 * @return 根据该id字符串返回对应的Item对象数组
	 */
	public ArrayList<Item> getCookie(String str)
	{
		ArrayList<Item> items = new ArrayList<>();
		if(str!=null && !str.trim().equals(""))
		{
			String[] arr = str.trim().split(",");
			if(arr.length>0&&arr!=null)
			{
				for(int i=arr.length-1;i>=0;i--)
				{
					if(!arr[i].equals(""))
					{
						Item it = getItemById(Integer.parseInt(arr[i]));
						items.add(it);
					}
				}
			}
		}
		return items;
	}
	
	/**
	 * 添加Item对象，即添加商品
	 */
	public boolean addItem(String iName,float iPrice,String iImage)
	{
		Connection conn = DBHelper.getConnection();
		String sql = "insert into item(name,price,image) values(?,?,?);";
		try{
			//开启事务
			conn.setAutoCommit(false);
			ps= conn.prepareStatement(sql);
			ps.setString(1, iName);
			ps.setFloat(2,iPrice);
			ps.setString(3, iImage);
			//是否成功插入
			int success =ps.executeUpdate();
			//插入失败，则返回
			if(success==0)
			{
				System.out.println("插入数据失败!");
				return false;
			}
			else
			{
				//提交事务
				conn.commit();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeUtil(rs,ps);
		}
		return true;
	}
//	public static void main(String[] args) {
//		ItemDao itdd = new ItemDao();
//		ArrayList<Item> items= itdd.getCookie(",2,1,6,4");
//		for(Item ite:items)
//		{
//			System.out.println(ite.getId()+ite.getName()+ite.getPrice()+","+ite.getImage());
//		}
//		System.out.println("end");
//		Item ite = itdd.getItemById(10);
//		System.out.println(ite.getId()+ite.getName()+ite.getPrice()+","+ite.getImage());
//		
//		String str="1,3,";
//		String[] arr = str.split(",");
//		System.out.println(arr[0]);
//		System.out.println(arr.length);
//		System.out.println("end");
//		
//		
//		itdd.addItem("男士休闲鞋", "489ss", "11.jpg");
//	}

}
