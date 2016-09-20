package com.zxj.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ���ﳵ�࣬����ʵ�������Ʒ��ɾ����Ʒ�����㹺�ﳵ����ܼ۸�
 * 
 * @author xj
 *
 */
public class Cart {
	// goods��ʾ�������Ʒ���Լ�����Ʒ������
	private HashMap<Item, Integer> goods;
	// ��ʾ���ﳵ�е���Ʒ�ܼ۸�
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
	 * �޲ι��췽��
	 */
	public Cart() {
		goods = new HashMap<>();
		sum = 0;
	}

	/**
	 * ��ӹ��ﳵ�ڵ���Ʒ
	 * 
	 * @param good
	 *            Ҫ��ӵ���Ʒ
	 * @param number
	 *            ��Ʒ����
	 */
	public boolean addGood(Item good, int number) {
		// ���������ͬ��Ʒ������дhashCode��equals�����������жϣ�,�����乺�ﳵ�Ĺ�������
		if (goods.containsKey(good)) {
			number += goods.get(good);
		}
		// ��ӳɹ�
		goods.put(good, number);
		return true;

	}

	/**
	 * ɾ�����ﳵ�ڵ���Ʒ
	 * 
	 * @param good
	 */
	public boolean removeGood(Item good) {
		// ÿ����Ӻ�ɾ����Ʒ������Ҫ���¼��㹺�ﳵ�����Ʒ�ܼ۸�
		if (goods.remove(good) != null)
			return true;
		return false;
	}

	/**
	 * ɾ�����ﳵ�ڵ���Ʒ������ָ����Ҫɾ��������Ʒ������
	 * 
	 * @param good
	 * @param number
	 *            ��Ҫ�Ƴ�����Ʒ����
	 */
	public void removeGoodNumber(Item good, int number) {
		// �����Ҫɾ������Ʒ�����ڵ���ԭ������Ʒ������ɾ�������Ʒ
		if (goods.get(good) <= number)
			this.removeGood(good);
		else {
			Set<Entry<Item, Integer>> items = goods.entrySet();
			for (Entry<Item, Integer> item : items) {
				if (item.getKey().equals(good)) {
					// ʣ�����Ʒ����
					int left = item.getValue() - number;
					item.setValue(left);
				}
			}
		}
	}

	/**
	 * ���㹺�ﳵ�ڵ���Ʒ�ܼ۸�
	 * 
	 * @return
	 */
	public double totalValue() {
		//�ܼ۸�
		double values = 0;
		// ������й��ﳵ�ڵ���Ʒ
		Set<Item> items = goods.keySet();
		// ��ȡmap�����е�Item���ļ��ϣ������ü��ϣ���õ�����Ʒ�ļ۸��Լ�������Ʒ�Ĺ�������
		Iterator<Item> iterator = items.iterator();
		while (iterator.hasNext()) {
			Item temp = iterator.next();
			values += temp.getPrice() * goods.get(temp);
		}
		//������λС��
		values = ((int)(values*10))*1.0/10;
		this.setSum(values);
		return values;
	}

	/**
	 * ��ù��ﳵ�ڵ���Ʒ��Ϣ
	 */
	public void showGoodsInfo() {
		// ����һ����ֵ��set����
		Set<Entry<Item, Integer>> items = goods.entrySet();
		// ��ǿ��forѭ��
		for (Entry<Item, Integer> item : items) {
			System.out.println(item.getKey().toString() + ";number:"
					+ item.getValue());
		}
		System.out.println(totalValue());
	}
	/*
	 * public static void main(String[] args) { Item it01 = new Item(1, "����",
	 * 100, "01.jpg"); Item it02 = new Item(2, "�Ϳ�", 200, "02.jpg"); Cart cart =
	 * new Cart(); cart.addGood(it01, 3); cart.addGood(it02,1);
	 * cart.addGood(it01, 2); cart.addGood(it02,1); cart.addGood(it02,5);
	 * cart.removeGoodNumber(it02,4); HashMap<Item,Integer> goods =
	 * cart.getGoods(); //����һ����ֵ��set���� Set<Entry<Item,Integer>> items=
	 * goods.entrySet(); //��ǿ��forѭ�� for(Entry<Item, Integer> item:items) {
	 * System.out.println(item.getKey().toString()+";number:"+item.getValue());
	 * } System.out.println(cart.totalValue());
	 * 
	 * 
	 * }
	 */

}
