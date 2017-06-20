package com.xukaiqiang.blog.model.artileTags;


import com.xukaiqiang.blog.common.BaseEntity;

/**
 * POJO:ArtileTags
 * 
 * @author xukaiqiang
 * @date 2016-7-22
 */
@SuppressWarnings("serial")
public class ArtileTags extends BaseEntity {
	
	
	private Integer	tagsId;		
	private Integer	articleId;		

	// Constructor
	public ArtileTags() {
	}
	
	/**
	 * full Constructor
	 */
	public ArtileTags(Integer id, Integer tagsId, Integer articleId) {
		setId(id);
		this.tagsId = tagsId;
		this.articleId = articleId;
	}

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为ArtileTags可以实现连缀设置属性
	
	public Integer getTagsId() {
		return tagsId;
	}

	public ArtileTags setTagsId(Integer tagsId) {
		this.tagsId = tagsId;
		return this;
	}
	
	
	public Integer getArticleId() {
		return articleId;
	}

	public ArtileTags setArticleId(Integer articleId) {
		this.articleId = articleId;
		return this;
	}
	
	@Override
	public String toString() {
		return "ArtileTags [" + "id=" + getId() + ", tagsId=" + tagsId + ", articleId=" + articleId +  "]";
	}
}
