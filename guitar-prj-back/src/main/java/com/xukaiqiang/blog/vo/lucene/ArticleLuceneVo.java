package com.xukaiqiang.blog.vo.lucene;

import java.io.Serializable;

/**
 * 
 * @ProjectName:MarsPlan
 * @ClassName:Search
 * @Description:索引搜索数据传递类
 * @date: Apr 16, 20162:38:25 PM
 * @author: bruce
 * @version: V1.0
 */
public class ArticleLuceneVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3942074614349634183L;
	/** 编号 */
	private Integer id;
	/** 标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 要跳转的url */
	private String url;
	/** 分类 */
	private String type;
	private String readTimes;
	/** 创建日期 */
	private String createTime;

	public String getReadTimes() {
		return readTimes;
	}

	public void setReadTimes(String readTimes) {
		this.readTimes = readTimes;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



}
