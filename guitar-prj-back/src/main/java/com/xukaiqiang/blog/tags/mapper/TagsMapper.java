package com.xukaiqiang.blog.tags.mapper;

import java.util.List;
import java.util.Map;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.tags.Tags;

/**
 * Service Interface:Tags
 * @author xukaiqiang
 * @date 2016-7-22
 */
public interface TagsMapper extends BaseMapper<Tags> {

	
	/**
	 * Class Name: TagsMapper.java
	 * @Description: 批量添加，如果有重复的更新num
	 * @author Administrator
	 * @date 2016年7月22日 下午4:26:48
	 * @modifier
	 * @modify-date 2016年7月22日 下午4:26:48
	 * @version 1.0
	 * @param tagsList
	*/
	void batchInsertOnDuplicateUpdate(Map<String, Object> map);

	
	/**
	 * Class Name: TagsMapper.java
	 * @Description:根据标签数组，查询插入后，这些标签的tagId(返回一个链表)：
	 * @author Administrator
	 * @date 2016年7月22日 下午5:03:31
	 * @modifier
	 * @modify-date 2016年7月22日 下午5:03:31
	 * @version 1.0
	 * @param map
	 * @return
	*/
		
	List<Tags> selectTagIds(Map<String, Object> map);


	
	/**
	 * Class Name: TagsMapper.java
	 * @Description:减少标签的引用
	 * @author Administrator
	 * @date 2016年7月26日 上午2:06:52
	 * @modifier
	 * @modify-date 2016年7月26日 上午2:06:52
	 * @version 1.0
	 * @param tagId
	*/
		
	void subUpdate(Integer tagId);


	
	/**
	 * Class Name: TagsMapper.java
	 * @Description: 删除空引用标签
	 * @author Administrator
	 * @date 2016年7月26日 上午2:51:33
	 * @modifier
	 * @modify-date 2016年7月26日 上午2:51:33
	 * @version 1.0
	*/
	void delete0num();


	
}