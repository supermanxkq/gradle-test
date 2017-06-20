package com.xukaiqiang.blog.api.article;

import java.util.List;

import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;
/**
 * Service Interface:Article
 * @author xukaiqiang
 * @date 2016-7-18
 */
public interface IArticleService  {
	/**
	 * 
	* @Title: saveArticle
	* @Description: 新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void insert(Article entity);
	
	/**
	 * 
	* @Title: batchSaveArticle 
	* @Description: 批量新增Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void batchInsert(List<Article> list);
	
	/**
	 * 
	* @Title: updateArticle 
	* @Description: 编辑Article
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void update(Article entity);
	
	/**
	 * 
	* @Title: deleteArticleById 
	* @Description: 根据id删除Article
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteArticleById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleByIds 
	* @Description: 根据id批量删除Article
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteArticleByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	Article findArticleById(Integer id);
	
	/**
	 * 
	* @Title: findArticleByPage 
	* @Description: 分页查询
	* @return
	* @return List<Article>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	List<Article> findArticleByPage(Article search);

	
	/**
	 * Class Name: IArticleService.java
	 * @Description: 查询博客列表
	 * @author Administrator
	 * @date 2016年7月19日 上午12:54:20
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:54:20
	 * @version 1.0
	 * @param article
	 * @return
	*/
		
	PageFinder<QueryArticleListVo> queryArticleList(QueryArticleListVo search);

	List<QueryArticleVo> queryTypeCount();
}