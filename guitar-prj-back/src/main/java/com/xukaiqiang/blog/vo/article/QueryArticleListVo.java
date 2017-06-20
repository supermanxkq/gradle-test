package com.xukaiqiang.blog.vo.article;

import java.util.Date;

import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:Article
 * 
 * @author xukaiqiang
 * @date 2016-7-18
 */
@SuppressWarnings("serial")
public class QueryArticleListVo extends BaseEntity {

	private String title;
	private String content;
	private Date createTime;
	private String userName;
	private Integer status;
	private String typeName;
	private Integer type;
	private String tags;
	private Integer isTop;
	private String summary;
	private Integer typeId;
	private String createTimeStr;
	
	

	/**
	 * @return the createTimeStr
	 */
	public String getCreateTimeStr() {
		return createTimeStr;
	}

	/**
	 * @param createTimeStr the createTimeStr to set
	 */
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the isTop
	 */
	public Integer getIsTop() {
		return isTop;
	}

	/**
	 * @param isTop the isTop to set
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

}
