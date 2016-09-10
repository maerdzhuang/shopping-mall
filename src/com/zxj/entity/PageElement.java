package com.zxj.entity;
/**
 * 该类为分页的参数信息类
 * @author xj
 *
 */
public class PageElement {
	//当前页
	private int pageNum;
	//页面总数
	private int pageSize;
	//总页数
	private int maxPage;
	//上一页
	private int prePage;
	//下一页
	private int nextPage;
	
	/**
	 * 根据当前页计算上一页和下一页
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
