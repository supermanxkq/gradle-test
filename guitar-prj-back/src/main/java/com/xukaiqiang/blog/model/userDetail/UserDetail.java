package com.xukaiqiang.blog.model.userDetail;


import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:UserDetail
 * 
 * @author xukaiqiang
 * @date 2016-7-18
 */
@SuppressWarnings("serial")
public class UserDetail extends BaseEntity {
	
	
	private Integer	sex;		
	private Integer	age;		
	private String	address;		
	private String	hobby;		

	// Constructor
	public UserDetail() {
	}
	
	/**
	 * full Constructor
	 */
	public UserDetail(Integer id, Integer sex, Integer age, String address, String hobby) {
		setId(id);
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.hobby = hobby;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为UserDetail可以实现连缀设置属性
	
	public Integer getSex() {
		return sex;
	}

	public UserDetail setSex(Integer sex) {
		this.sex = sex;
		return this;
	}
	
	
	public Integer getAge() {
		return age;
	}

	public UserDetail setAge(Integer age) {
		this.age = age;
		return this;
	}
	
	
	public String getAddress() {
		return address;
	}

	public UserDetail setAddress(String address) {
		this.address = address;
		return this;
	}
	
	
	public String getHobby() {
		return hobby;
	}

	public UserDetail setHobby(String hobby) {
		this.hobby = hobby;
		return this;
	}
	
	@Override
	public String toString() {
		return "UserDetail [" + "id=" + getId() + ", sex=" + sex + ", age=" + age + ", address=" + address + ", hobby=" + hobby +  "]";
	}
}
