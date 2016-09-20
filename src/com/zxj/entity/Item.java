package com.zxj.entity;
/**
 * ��Ʒ��
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
	 * ��дhashCode��equals��Ϊ�˽���Ʒ��ӵ����ﳵʱ���ظ���Ʒ���Թ�Ϊ��ͬһ�࣬�����ӹ�������
	 */
	public int hashCode() {
		//�ַ�����hashCode��ͬ
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
				//id��ͬ��������ͬ����Ϊͬһ����Ʒ
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
