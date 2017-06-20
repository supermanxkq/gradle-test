package com.xukaiqiang.blog.model.articleType;


import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:ArticleType
 * 
 * @author xukaiqiang
 * @date 2016-7-18
 */
@SuppressWarnings("serial")
public class ArticleType extends BaseEntity {
	
	
	private String	name;		
	private Integer	status;		
	private Integer sequence;
	
	
	/**
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	// Constructor
	public ArticleType() {
	}
	

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArticleType可以实现连缀设置属性
	
	/**
	 * @param name
	 * @param status
	 * @param sequence
	 */
	public ArticleType(String name, Integer status, Integer sequence) {
		super();
		this.name = name;
		this.status = status;
		this.sequence = sequence;
	}

	public String getName() {
		return name;
	}

	public ArticleType setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public ArticleType setStatus(Integer status) {
		this.status = status;
		return this;
	}
}
