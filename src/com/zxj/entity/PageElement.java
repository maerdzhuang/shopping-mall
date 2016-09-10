package com.zxj.entity;
/**
 * ����Ϊ��ҳ�Ĳ�����Ϣ��
 * @author xj
 *
 */
public class PageElement {
	//��ǰҳ
	private int pageNum;
	//ҳ������
	private int pageSize;
	//��ҳ��
	private int maxPage;
	//��һҳ
	private int prePage;
	//��һҳ
	private int nextPage;
	
	/**
	 * ���ݵ�ǰҳ������һҳ����һҳ
	 * @param pageNum
	 */
	public void setPageCount(int pageNum)
	{
		this.pageNum = pageNum;
		prePage = (pageNum-1)>1 ? pageNum-1 : 1;
		nextPage = (pageNum+1)>=maxPage ? maxPage : pageNum+1;
		
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
}
