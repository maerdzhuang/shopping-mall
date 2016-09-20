package com.zxj.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 购物车类，用来实现添加商品，删除商品，计算购物车类的总价格
 * 
 * @author xj
 *
 */
public class Cart {
	// goods表示添加是商品，以及该商品的数量
	private HashMap<Item, Integer> goods;
	// 表示购物车中的商品总价格
	private double sum;

	public HashMap<Item, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Item, Integer> goods) {
		this.goods = goods;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * 无参构造方法
	 */
	public Cart() {
		goods = new HashMap<>();
		sum = 0;
	}

	/**
	 * 添加购物车内的商品
	 * 
	 * @param good
	 *            要添加的商品
	 * @param number
	 *            商品数量
	 */
	public boolean addGood(Item good, int number) {
		// 如果包含相同商品（需重写hashCode和equals方法，方能判断）,增加其购物车的购买数量
		if (goods.containsKey(good)) {
			number += goods.get(good);
		}
		// 添加成功
		goods.put(good, number);
		return true;

	}

	/**
	 * 删除购物车内的商品
	 * 
	 * @param good
	 */
	public boolean removeGood(Item good) {
		// 每次添加和删除商品，都需要重新计算购物车类的商品总价格
		if (goods.remove(good) != null)
			return true;
		return false;
	}

	/**
	 * 删除购物车内的商品，可以指定需要删除该种商品的数量
	 * 
	 * @param good
	 * @param number
	 *            需要移除的商品数量
	 */
	public void removeGoodNumber(Item good, int number) {
		// 如果需要删除的商品量大于等于原来的商品量，则删除这个商品
		if (goods.get(good) <= number)
			this.removeGood(good);
		else {
			Set<Entry<Item, Integer>> items = goods.entrySet();
			for (Entry<Item, Integer> item : items) {
				if (item.getKey().equals(good)) {
					// 剩余的商品数量
					int left = item.getValue() - number;
					item.setValue(left);
				}
			}
		}
	}

	/**
	 * 计算购物车内的商品总价格
	 * 
	 * @return
	 */
	public double totalValue() {
		//总价格
		double values = 0;
		// 获得所有购物车内的商品
		Set<Item> items = goods.keySet();
		// 获取map集合中的Item键的集合，遍历该集合，获得单个商品的价格，以及单个商品的购买数量
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			Item temp = iterator.next();
			values += temp.getPrice() * goods.get(temp);
		}
		//保留两位小数
		values = ((int)(values*10))*1.0/10;
		this.setSum(values);
		return values;
	}

	/**
	 * 获得购物车内的商品信息
	 */
	public void showGoodsInfo() {
		// 返回一个键值对set集合
		Set<Entry<Item, Integer>> items = goods.entrySet();
		// 增强的for循环
		for (Entry<Item, Integer> item : items) {
			System.out.println(item.getKey().toString() + ";number:"
					+ item.getValue());
		}
		System.out.println(totalValue());
	}
	/*
	 * public static void main(String[] args) { Item it01 = new Item(1, "李宁",
	 * 100, "01.jpg"); Item it02 = new Item(2, "耐克", 200, "02.jpg"); Cart cart =
	 * new Cart(); cart.addGood(it01, 3); cart.addGood(it02,1);
	 * cart.addGood(it01, 2); cart.addGood(it02,1); cart.addGood(it02,5);
	 * cart.removeGoodNumber(it02,4); HashMap<Item,Integer> goods =
	 * cart.getGoods(); //返回一个键值对set集合 Set<Entry<Item,Integer>> items=
	 * goods.entrySet(); //增强的for循环 for(Entry<Item, Integer> item:items) {
	 * System.out.println(item.getKey().toString()+";number:"+item.getValue());
	 * } System.out.println(cart.totalValue());
	 * 
	 * 
	 * }
	 */

}
