package com.zxj.entity;
/**
 * 商品类
 * @author xj
 *
 */
public class Item {
	private int id;
	private String name;
	private float price;
	private String image;
	public Item()
	{
		
	}
	public Item(int id, String name, float price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	/**
	 * 重写hashCode和equals是为了将商品添加到购物车时，重复商品可以归为相同一类，并增加购买数量
	 */
	public int hashCode() {
		//字符串的hashCode相同
		return this.getId()+this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(this!=obj)
		{
			if(obj instanceof Item)
			{
				Item it = (Item)obj;
				//id相同，名字相同，视为同一个商品
				if(this.id==it.getId() && this.name.equals(it.getName()))
					return true;
			}
		}
		return false;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+this.getId()+"; name:"+this.getName()+"; price:"+this.getPrice()+"; imagePath:"+this.getImage();
	}
	
}
