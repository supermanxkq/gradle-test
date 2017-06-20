package com.xukaiqiang.blog.articleType.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.articleType.IArticleTypeService;
import com.xukaiqiang.blog.article.mapper.ArticleMapper;
import com.xukaiqiang.blog.articleType.mapper.ArticleTypeMapper;
import com.xukaiqiang.blog.artileTags.mapper.ArtileTagsMapper;
import com.xukaiqiang.blog.model.articleType.ArticleType;
import com.xukaiqiang.blog.model.artileTags.ArtileTags;
import com.xukaiqiang.blog.model.tags.Tags;
import com.xukaiqiang.blog.tags.mapper.TagsMapper;

/**
 * Service Implementation:ArticleType
 * @author xukaiqiang
 * @date 2016-7-18
 */
@Service
@Transactional
public class ArticleTypeServiceImpl implements IArticleTypeService {

	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	@Autowired
	private  ArticleMapper  articleMapper;
	@Autowired
	private   ArtileTagsMapper articleTagsMapper;
	@Autowired
	private   TagsMapper  tagsMapper;
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
	@Override
	public void insert(ArticleType entity){
		articleTypeMapper.insert(entity);
	};
	
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
	@Override
	public void batchInsert(List<ArticleType> entity){
		articleTypeMapper.batchInsert(entity);
	};
	
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
	@Override
	public void update(ArticleType entity){
		articleTypeMapper.update(entity);
	};
	
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
	 @Override
	public void deleteArticleTypeById(Integer id){
		//根据id删除ArticleType
		articleTypeMapper.deleteById(id);
		//查询出该分类下的所有文章的编号
		List<Integer> articleIdList=articleMapper.findIdByTypeId(id);
		//如果分类下有文章进行删除分类文章等操作
		if(articleIdList.size()>0){
		//删除该分类下的所有的文章
		articleMapper.deleteByTypeId(id);
		//根据文章的编号查找对应的tagId集合
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("articleIdMap", articleIdList.toArray());
		List<Integer> tagsIdList=articleTagsMapper.findByArticleId(map);
		//删除文章标签关联表
		articleTagsMapper.deleteByArticleId(map);
		//更新标签表数量
		//判断标签的引用数量是否为0，为0就删除，否则就进行更新
		for (Integer tagId : tagsIdList) {
			Tags  tags=	tagsMapper.findById(tagId);
				//数量减少
				tagsMapper.subUpdate(tagId);
		}
		//删除空引用标签
		tagsMapper.delete0num();
		}
	};
	
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
	@Override
	public void deleteArticleTypeByIds(Integer[] ids){
		articleTypeMapper.deleteByIds(ids);
	};
	
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
	@Override
	public ArticleType findArticleTypeById(Integer id){
		return articleTypeMapper.findById(id);
	};
	
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
	@Override
	public List<ArticleType> findArticleTypeByPage(ArticleType search){
		return articleTypeMapper.page(search);
	}

	
	/* (non-Javadoc)
	 * @Description:查询所有分类
	 * @author Administrator
	 * @date 2016年7月21日 上午12:26:02
	 * @modifier
	 * @modify-date 2016年7月21日 上午12:26:02
	 * @version 1.0
	 * @return
	*/
		
	@Override
	public List<ArticleType> queryAll() {
		return articleTypeMapper.queryAll();
	};
}
