package com.xukaiqiang.blog.model.lesson;


import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:Lesson
 * 
 * @author xukaiqiang
 * @date 2016-8-28
 */
@SuppressWarnings("serial")
public class Lesson extends BaseEntity {
	
	
	private String	title;		 /* 课程名称 */ 
	private String	downloadUrl;		 /* 下载地址 */ 
	private Integer	courseId;		 /* 课程编号 */ 
	private String	time;		 /* 时长 */ 

	// Constructor
	public Lesson() {
	}
	
	/**
	 * full Constructor
	 */
	public Lesson(Integer id, String title, String downloadUrl, Integer courseId, String time) {
		setId(id);
		this.title = title;
		this.downloadUrl = downloadUrl;
		this.courseId = courseId;
		this.time = time;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为Lesson可以实现连缀设置属性
	
	public String getTitle() {
		return title;
	}

	public Lesson setTitle(String title) {
		this.title = title;
		return this;
	}
	
	
	public String getDownloadUrl() {
		return downloadUrl;
	}

	public Lesson setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
		return this;
	}
	
	
	public Integer getCourseId() {
		return courseId;
	}

	public Lesson setCourseId(Integer courseId) {
		this.courseId = courseId;
		return this;
	}
	
	
	public String getTime() {
		return time;
	}

	public Lesson setTime(String time) {
		this.time = time;
		return this;
	}
	
	@Override
	public String toString() {
		return "Lesson [" + "id=" + getId() + ", title=" + title + ", downloadUrl=" + downloadUrl + ", courseId=" + courseId + ", time=" + time +  "]";
	}
}
