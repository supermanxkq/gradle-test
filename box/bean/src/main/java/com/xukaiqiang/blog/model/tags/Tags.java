package com.xukaiqiang.blog.model.tags;


import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:Tags
 * 
 * @author xukaiqiang
 * @date 2016-7-22
 */
@SuppressWarnings("serial")
public class Tags extends BaseEntity {
	
	
	private String	name;		 /* 标签名称unique */ 
	private Integer	num;		 /* 引用数量 */ 

	// Constructor
	public Tags() {
	}
	
	/**
	 * full Constructor
	 */
	public Tags(Integer id, String name, Integer num) {
		setId(id);
		this.name = name;
		this.num = num;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Tags可以实现连缀设置属性
	
	public String getName() {
		return name;
	}

	public Tags setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Integer getNum() {
		return num;
	}

	public Tags setNum(Integer num) {
		this.num = num;
		return this;
	}
	
	@Override
	public String toString() {
		return "Tags [" + "id=" + getId() + ", name=" + name + ", num=" + num +  "]";
	}
}
