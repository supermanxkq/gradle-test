package com.xukaiqiang.blog.artileTags.mapper;

import java.util.List;
import java.util.Map;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.artileTags.ArtileTags;

/**
 * Service Interface:ArtileTags
 * @author xukaiqiang
 * @date 2016-7-22
 */
public interface ArtileTagsMapper extends BaseMapper<ArtileTags> {

	
	/**
	 * Class Name: ArtileTagsMapper.java
	 * @Description: 批量添加map
	 * @author Administrator
	 * @date 2016年7月23日 上午8:42:31
	 * @modifier
	 * @modify-date 2016年7月23日 上午8:42:31
	 * @version 1.0
	 * @param map
	*/
		
	void batchInsertMap(Map<String, Object> map);
	
	/**
	 * Class Name: TagsMapper.java
	 * @Description: 根据文章的编号查找对应的tagId集合
	 * @author Administrator
	 * @date 2016年7月26日 上午1:50:54
	 * @modifier
	 * @modify-date 2016年7月26日 上午1:50:54
	 * @version 1.0
	 * @param articleIdMap
	 * @return
	*/
	List<Integer> findByArticleId(Map<String, Object> articleIdMap);

	
	/**
	 * Class Name: ArtileTagsMapper.java
	 * @Description: 批量删除
	 * @author Administrator
	 * @date 2016年7月26日 上午2:04:26
	 * @modifier
	 * @modify-date 2016年7月26日 上午2:04:26
	 * @version 1.0
	 * @param array
	*/
	void deleteByArticleId(Map<String, Object> array);
	
}