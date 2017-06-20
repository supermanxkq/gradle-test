package com.xukaiqiang.blog.api.user;

import java.util.List;

import com.xukaiqiang.blog.model.user.User;
/**
 * Service Interface:User
 * @author xukaiqiang
 * @date 2016-7-18
 */
public interface IUserService  {
	/**
	 * 
	* @Title: saveUser
	* @Description: 新增User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void insert(User entity);
	
	/**
	 * 
	* @Title: batchSaveUser 
	* @Description: 批量新增User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void batchInsert(List<User> list);
	
	/**
	 * 
	* @Title: updateUser 
	* @Description: 编辑User
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void update(User entity);
	
	/**
	 * 
	* @Title: deleteUserById 
	* @Description: 根据id删除User
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteUserById(Integer id);
	
	/**
	 * 
	* @Title: deleteUserByIds 
	* @Description: 根据id批量删除User
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteUserByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findUserById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	User findUserById(Integer id);
	
	/**
	 * 
	* @Title: findUserByPage 
	* @Description: 分页查询
	* @return
	* @return List<User>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	List<User> findUserByPage(User search);
	/**
	 * 
	 * Class Name: IUserService.java
	 * @Description: 登录
	 * @author Administrator
	 * @date 2016年7月18日 下午10:04:13
	 * @modifier
	 * @modify-date 2016年7月18日 下午10:04:13
	 * @version 1.0
	 * @param user
	 * @return
	 */
	User login(User user);
}