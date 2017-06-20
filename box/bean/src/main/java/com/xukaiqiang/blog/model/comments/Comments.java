package com.xukaiqiang.blog.model.comments;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xukaiqiang.blog.util.ShortDateSerializer;

import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:Comments
 * 
 * @author xukaiqiang
 * @date 2016-7-31
 */
@SuppressWarnings("serial")
public class Comments extends BaseEntity {
	
	
	private Date	createTime;		 /* 评论时间 */ 
	private String	content;		 /* 评论内容 */ 
	private String	addredss;		 /* 评论者归属地 */ 
	private Integer	articleId;		 /* 文章编号 */ 
	private String	ip;		 /* 评论者ip */ 

	// Constructor
	public Comments() {
	}
	
	/**
	 * full Constructor
	 */
	public Comments(Integer id, Date createTime, String content, String addredss, Integer articleId, String ip) {
		setId(id);
		this.createTime = createTime;
		this.content = content;
		this.addredss = addredss;
		this.articleId = articleId;
		this.ip = ip;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Comments可以实现连缀设置属性
	public Date getCreateTime() {
		return createTime;
	}

	public Comments setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	
	public String getContent() {
		return content;
	}

	public Comments setContent(String content) {
		this.content = content;
		return this;
	}
	
	
	public String getAddredss() {
		return addredss;
	}

	public Comments setAddredss(String addredss) {
		this.addredss = addredss;
		return this;
	}
	
	
	public Integer getArticleId() {
		return articleId;
	}

	public Comments setArticleId(Integer articleId) {
		this.articleId = articleId;
		return this;
	}
	
	
	public String getIp() {
		return ip;
	}

	public Comments setIp(String ip) {
		this.ip = ip;
		return this;
	}
	
	@Override
	public String toString() {
		return "Comments [" + "id=" + getId() + ", createTime=" + createTime + ", content=" + content + ", addredss=" + addredss + ", articleId=" + articleId + ", ip=" + ip +  "]";
	}
}
