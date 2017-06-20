package com.xukaiqiang.blog.api.articleType;

import java.util.List;

import com.xukaiqiang.blog.model.articleType.ArticleType;
/**
 * Service Interface:ArticleType
 * @author xukaiqiang
 * @date 2016-7-18
 */
public interface IArticleTypeService  {
	/**
	 * 
	* @Title: saveArticleType
	* @Description: 新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void insert(ArticleType entity);
	
	/**
	 * 
	* @Title: batchSaveArticleType 
	* @Description: 批量新增ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void batchInsert(List<ArticleType> list);
	
	/**
	 * 
	* @Title: updateArticleType 
	* @Description: 编辑ArticleType
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void update(ArticleType entity);
	
	/**
	 * 
	* @Title: deleteArticleTypeById 
	* @Description: 根据id删除ArticleType
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteArticleTypeById(Integer id);
	
	/**
	 * 
	* @Title: deleteArticleTypeByIds 
	* @Description: 根据id批量删除ArticleType
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteArticleTypeByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findArticleTypeById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	ArticleType findArticleTypeById(Integer id);
	
	/**
	 * 
	* @Title: findArticleTypeByPage 
	* @Description: 分页查询
	* @return
	* @return List<ArticleType>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	List<ArticleType> findArticleTypeByPage(ArticleType search);

	
	/**
	 * Class Name: IArticleTypeService.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Administrator
	 * @date 2016年7月21日 上午12:25:40
	 * @modifier
	 * @modify-date 2016年7月21日 上午12:25:40
	 * @version 1.0
	 * @return
	*/
		
	List<ArticleType> queryAll();
}