package com.xukaiqiang.blog.article.mapper;

import java.util.List;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;

/**
 * Service Interface:Users
 * 
 * @author xukaiqiang
 * @date 2015-3-12
 */
public interface ArticleMapper extends BaseMapper<Article> {

	List<QueryArticleVo> queryTypeCount();

	List<QueryArticleListVo> queryArticleList(QueryArticleListVo param);

	int pageCountArticle(QueryArticleListVo search);
	
	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 根据文章类型编号查找文章编号
	 * @author Administrator
	 * @date 2016年7月26日 上午1:34:08
	 * @modifier
	 * @modify-date 2016年7月26日 上午1:34:08
	 * @version 1.0
	 * @param typeId
	 * @return
	*/
		
	List<Integer>  findIdByTypeId(Integer typeId);

	
	/**
	 * Class Name: ArticleMapper.java
	 * @Description: 根据分类Id删除文章信息
	 * @author Administrator
	 * @date 2016年7月26日 上午1:33:41
	 * @modifier
	 * @modify-date 2016年7月26日 上午1:33:41
	 * @version 1.0
	 * @param id
	*/
	void deleteByTypeId(Integer id);

}