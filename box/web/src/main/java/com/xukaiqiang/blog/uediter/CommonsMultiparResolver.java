package com.xukaiqiang.blog.uediter;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ClassName: CommonsMultiparResolver
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年7月21日 上午4:56:58
 * @modifier
 * @modify-date 2016年7月21日 上午4:56:58
 * @version 1.0
*/

public class CommonsMultiparResolver extends CommonsMultipartResolver  {
	/**
	   * 用于过滤百度编辑器上传文件时阻止 commonsMultipartResolver 对文件进行包装
	   */  
	  @Override  
	  public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {  
	   String uri = request.getRequestURI();  
	   System.out.println(uri);
	   //过滤使用百度EmEditor的URI  
	   if (uri.indexOf("ued/config") > 0) {  
	    System.out.println("commonsMultipartResolver 放行");
	    return false;  
	   }  
	   System.out.println("commonsMultipartResolver 拦截");
	   return super.isMultipart(request);  
	  }  
}
