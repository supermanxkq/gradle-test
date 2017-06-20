package com.xukaiqiang.blog.model.course;

import java.util.Date;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xukaiqiang.blog.util.ShortDateSerializer;

import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:Course
 * 
 * @author xukaiqiang
 * @date 2016-8-28
 */
@SuppressWarnings("serial")
public class Course extends BaseEntity {
	
	
	private String	title;		 /* 课程标题 */ 
	private String	pictureSrc;		 /* 图片路径 */ 
	private Integer	userId;		 /* 讲师 */ 
	private Integer	lessonPeriod;		 /* 课时 */ 
	private Date	createTime;		
	private String	applicableUser;		 /* 适用人群 */ 

	// Constructor
	public Course() {
	}
	
	/**
	 * full Constructor
	 */
	public Course(Integer id, String title, String pictureSrc, Integer userId, Integer lessonPeriod, Date createTime, String applicableUser) {
		setId(id);
		this.title = title;
		this.pictureSrc = pictureSrc;
		this.userId = userId;
		this.lessonPeriod = lessonPeriod;
		this.createTime = createTime;
		this.applicableUser = applicableUser;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Course可以实现连缀设置属性
	
	public String getTitle() {
		return title;
	}

	public Course setTitle(String title) {
		this.title = title;
		return this;
	}
	
	
	public String getPictureSrc() {
		return pictureSrc;
	}

	public Course setPictureSrc(String pictureSrc) {
		this.pictureSrc = pictureSrc;
		return this;
	}
	
	
	public Integer getUserId() {
		return userId;
	}

	public Course setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
	
	
	public Integer getLessonPeriod() {
		return lessonPeriod;
	}

	public Course setLessonPeriod(Integer lessonPeriod) {
		this.lessonPeriod = lessonPeriod;
		return this;
	}
	
	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public Course setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	
	public String getApplicableUser() {
		return applicableUser;
	}

	public Course setApplicableUser(String applicableUser) {
		this.applicableUser = applicableUser;
		return this;
	}
	
	@Override
	public String toString() {
		return "Course [" + "id=" + getId() + ", title=" + title + ", pictureSrc=" + pictureSrc + ", userId=" + userId + ", lessonPeriod=" + lessonPeriod + ", createTime=" + createTime + ", applicableUser=" + applicableUser +  "]";
	}
}
