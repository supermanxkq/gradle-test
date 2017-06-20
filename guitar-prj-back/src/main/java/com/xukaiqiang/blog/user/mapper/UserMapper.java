package com.xukaiqiang.blog.user.mapper;

import com.xukaiqiang.blog.common.BaseMapper;
import com.xukaiqiang.blog.model.user.User;

/**
 * Service Interface:Users
 * @author xukaiqiang
 * @date 2015-3-12
 */
public interface UserMapper extends BaseMapper<User> {

	User login(User user);
	
	
}