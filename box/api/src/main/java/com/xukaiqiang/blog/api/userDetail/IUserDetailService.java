package com.xukaiqiang.blog.api.userDetail;

import java.util.List;

import com.xukaiqiang.blog.model.userDetail.UserDetail;
/**
 * Service Interface:UserDetail
 * @author xukaiqiang
 * @date 2016-7-18
 */
public interface IUserDetailService  {
	/**
	 * 
	* @Title: saveUserDetail
	* @Description: 新增UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void insert(UserDetail entity);
	
	/**
	 * 
	* @Title: batchSaveUserDetail 
	* @Description: 批量新增UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void batchInsert(List<UserDetail> list);
	
	/**
	 * 
	* @Title: updateUserDetail 
	* @Description: 编辑UserDetail
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void update(UserDetail entity);
	
	/**
	 * 
	* @Title: deleteUserDetailById 
	* @Description: 根据id删除UserDetail
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteUserDetailById(Integer id);
	
	/**
	 * 
	* @Title: deleteUserDetailByIds 
	* @Description: 根据id批量删除UserDetail
	* @param ids
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	void deleteUserDetailByIds(Integer[] ids);
	
	/**
	 * 
	* @Title: findUserDetailById 
	* @Description: 根据id查询
	* @param id
	* @return void    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	UserDetail findUserDetailById(Integer id);
	
	/**
	 * 
	* @Title: findUserDetailByPage 
	* @Description: 分页查询
	* @return
	* @return List<UserDetail>    返回类型 
	* @throws 
	* @exception 
	* @date 2016-7-18
	* @user by xukaiqiang
	 */
	List<UserDetail> findUserDetailByPage(UserDetail search);
}