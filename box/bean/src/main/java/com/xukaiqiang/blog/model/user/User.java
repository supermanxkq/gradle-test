package com.xukaiqiang.blog.model.user;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xukaiqiang.blog.util.ShortDateSerializer;

import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:User
 * 
 * @author xukaiqiang
 * @date 2016-7-18
 */
@SuppressWarnings("serial")
public class User extends BaseEntity {
	
	
	private String	 userName;		
	private String 	passWord;		
	private Date	registTime;		
	private Integer	detailId;		

	// Constructor
	public User() {
	}
	
	/**
	 * full Constructor
	 */
	public User(Integer id, String userName, String passWord, Date registTime, Integer detailId) {
		setId(id);
		this.userName = userName;
		this.passWord = passWord;
		this.registTime = registTime;
		this.detailId = detailId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为User可以实现连缀设置属性
	
	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
	
	public String getPassWord() {
		return passWord;
	}

	public User setPassWord(String passWord) {
		this.passWord = passWord;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getRegistTime() {
		return registTime;
	}

	public User setRegistTime(Date registTime) {
		this.registTime = registTime;
		return this;
	}
	
	
	public Integer getDetailId() {
		return detailId;
	}

	public User setDetailId(Integer detailId) {
		this.detailId = detailId;
		return this;
	}
	
	@Override
	public String toString() {
		return "User [" + "id=" + getId() + ", userName=" + userName + ", passWord=" + passWord + ", registTime=" + registTime + ", detailId=" + detailId +  "]";
	}
}
