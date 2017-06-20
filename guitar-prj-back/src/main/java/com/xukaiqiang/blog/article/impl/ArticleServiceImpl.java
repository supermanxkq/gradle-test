package com.xukaiqiang.blog.article.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xukaiqiang.blog.api.article.IArticleService;
import com.xukaiqiang.blog.article.mapper.ArticleMapper;
import com.xukaiqiang.blog.artileTags.mapper.ArtileTagsMapper;
import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.model.artileTags.ArtileTags;
import com.xukaiqiang.blog.model.tags.Tags;
import com.xukaiqiang.blog.tags.mapper.TagsMapper;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;

/**
 * Service Implementation:Article
 * @author xukaiqiang
 * @date 2016-7-18
 */
@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private TagsMapper  tagsMapper;
	@Autowired
	private  ArtileTagsMapper  articleTagsMapper;
	
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
	@Override
	public void insert(Article entity){
		//插入文章
		entity.setCreateTime(new Date());
		articleMapper.insert(entity);
		//批量插入标签到数据库
		List<Tags> tagsList=new ArrayList<Tags>();
		String [] tagsArray=entity.getTags().split(",");
		for (String name : tagsArray) {
			Tags tags=new Tags();
			tags.setName(name);
			tags.setNum(1);
			tagsList.add(tags);
		}
		 Map<String, Object> map = new HashMap<String, Object>();  
		 map.put("tagsList", tagsList);
		tagsMapper.batchInsertOnDuplicateUpdate(map);
		 map.put("tagsArray", tagsArray);
		//获取插入的标签的主键
		List<Tags> tags=tagsMapper.selectTagIds(map);
		//批量插入article_tags关系
		List<ArtileTags> articleTagsList=new ArrayList<ArtileTags>();
		for (Tags tags2 : tags) {
			ArtileTags artileTags=new ArtileTags();
			artileTags.setArticleId(entity.getId());
			artileTags.setTagsId(tags2.getId());
			articleTagsList.add(artileTags);
		}
		 map.put("articleTagsList", articleTagsList);
		articleTagsMapper.batchInsertMap(map);
	};
	
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
	@Override
	public void batchInsert(List<Article> entity){
		articleMapper.batchInsert(entity);
	};
	
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
	@Override
	public void update(Article entity){
		articleMapper.update(entity);
	};
	
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
	 @Override
	public void deleteArticleById(Integer id){
		articleMapper.deleteById(id);
	};
	
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
	@Override
	public void deleteArticleByIds(Integer[] ids){
		articleMapper.deleteByIds(ids);
	};
	
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
	@Override
	public Article findArticleById(Integer id){
		return articleMapper.findById(id);
	};
	
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
	@Override
	public List<Article> findArticleByPage(Article search){
		return articleMapper.page(search);
	}

	@Override
	public PageFinder<QueryArticleListVo> queryArticleList(QueryArticleListVo search) {
		List<QueryArticleListVo> data = articleMapper.queryArticleList(search);
		int rowCount=articleMapper.pageCountArticle(search);
		PageFinder<QueryArticleListVo> pageFinder = new PageFinder<QueryArticleListVo>(search.getPage(), search.getPageSize(), rowCount, data);
		return pageFinder;
	};
	
	public List<QueryArticleVo> queryTypeCount(){
		return articleMapper.queryTypeCount();
	}
}
