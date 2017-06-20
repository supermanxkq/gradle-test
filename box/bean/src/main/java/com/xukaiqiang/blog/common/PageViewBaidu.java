package com.xukaiqiang.blog.common;

import java.util.List;

public class PageViewBaidu<T> {
	// 总共的页数
	private int totalPage;
	private int nowPage;// 当前页
	private int startPage;// 起始页
	private int endPage;// 结束页
	private int totalRecord;// 总记录数
	private String targetUrl;//项目路径
	private String param;//参数
	
	// 分页2
	private String pageHtml2;
	// 结果集合
	private List<T> list;
	public static final int PAGESIZE = 15;// 每页显示的条数
	public static final int SHOWPAGES = 10;// 每页显示的页数
	// 带参构造

	public PageViewBaidu(Integer nowPage, int totalRecord, List<T> list,String targetUrl,String param) {
		super();
		this.nowPage = nowPage;
		this.totalRecord = totalRecord;
		this.list = list;
		this.targetUrl=targetUrl;
		this.param=param;
		// 设置总页数
		setTotalPage(this.totalRecord % PAGESIZE == 0 ? this.totalRecord / PAGESIZE : this.totalRecord / PAGESIZE + 1);
		/**
		 * 计算startPage与endPage的值
		 * 
		 */
		if (this.totalPage < SHOWPAGES) {
			/** if中是总页数小于SHOWPAGES的情况 */
			this.startPage = 1;
			this.endPage = totalPage;
		} else {
			/** else中是总页数大于SHOWPAGES的情况 */
			if (this.nowPage <= SHOWPAGES / 2 + 1) {
				this.startPage = 1;
				this.endPage = SHOWPAGES;
			} else {
				this.startPage = this.nowPage - (SHOWPAGES / 2);
				this.endPage = this.nowPage + (SHOWPAGES / 2 - 1);
				if (this.endPage >= this.totalPage) {
					this.endPage = this.totalPage;
					this.startPage = this.totalPage - SHOWPAGES + 1;
				}
			}
		}

		// 设置分页的HTML
		StringBuffer pageHtml = new StringBuffer();
		
		pageHtml.append("<nav><ul class='pagination pagination-sm'>");
		if(this.totalRecord>0){
		if (this.nowPage > 1) {
		pageHtml.append("<li><a href='"+this.targetUrl+"/article/queryArticleList.html?page= "+ (this.nowPage-1) +"&"+this.param+"' aria-label='上一页'><span aria-hidden='true'>上一页</span></a>");
		}
		
		for (int i = this.startPage; i <= this.endPage; i++) {
			if (i != this.nowPage) {
				pageHtml.append("<li><a href='"+this.targetUrl+"/article/queryArticleList.html?page= "+ i +"&"+this.param+"'>"+ i +"</a></li>");
			}else{
				pageHtml.append("<li class='active'><a href='"+this.targetUrl+"/article/queryArticleList.html?page= "+ i +"&"+this.param+"'>"+ i +"</a></li>");
			}
		}
		
		if (this.nowPage != this.totalPage) {
			pageHtml.append("<li><a href='"+this.targetUrl+"/article/queryArticleList.html?page= "+ (this.nowPage+1) +"&"+this.param+"' aria-label='下一页'><span aria-hidden='true'>下一页</span></a></li>");
		}
		pageHtml.append("</ul></nav>");
		setPageHtml2(pageHtml.toString());
		}
	}

	/**
	 * 分页方法 通过这个方法,得到两个数据——startPage和endPage 页面上的页码就是根据这两个数据处理后显示
	 * 
	 * @param nowPage当前页
	 * @param totalPage总页数
	 */
	public void paginationTool(int nowPage, int totalPage) {
		this.nowPage = nowPage;
		this.totalPage = totalPage;
		/**
		 * 计算startPage与endPage的值
		 * 
		 */
		if (this.totalPage < SHOWPAGES) {
			/** if中是总页数小于SHOWPAGES的情况 */
			this.startPage = 1;
			this.endPage = totalPage;
		} else {
			/** else中是总页数大于SHOWPAGES的情况 */
			if (this.nowPage <= SHOWPAGES / 2 + 1) {
				this.startPage = 1;
				this.endPage = SHOWPAGES;
			} else {
				this.startPage = this.nowPage - (SHOWPAGES / 2);
				this.endPage = this.nowPage + (SHOWPAGES / 2 - 1);
				if (this.endPage >= this.totalPage) {
					this.endPage = this.totalPage;
					this.startPage = this.totalPage - SHOWPAGES + 1;
				}
			}
		}
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getPageHtml2() {
		return pageHtml2;
	}

	public void setPageHtml2(String pageHtml2) {
		this.pageHtml2 = pageHtml2;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	/**
	 * @return the targetUrl
	 */
	public String getTargetUrl() {
		return targetUrl;
	}

	/**
	 * @param targetUrl the targetUrl to set
	 */
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	
	
}
