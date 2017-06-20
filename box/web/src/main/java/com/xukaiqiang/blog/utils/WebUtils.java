package com.xukaiqiang.blog.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.xukaiqiang.blog.common.ViewResult;
import com.xukaiqiang.blog.model.user.User;

import net.sf.json.JSONObject;

public class WebUtils {

	private static Logger logger = Logger.getLogger(WebUtils.class);

	/**
	 * 判断当前请求是否ajax请求
	 * @param request
	 * @return
	 */
	public static Boolean isAjax(HttpServletRequest request){
		String requestType = request.getHeader("X-Requested-With");
		if(requestType!=null && "XMLHttpRequest".equals(requestType)){
			return true;
		}
		return false;
	}

	/**
	 * 判断当前请求是否ajax请求
	 * @param request
	 * @return
	 */
	public static Boolean isAjax(ServletRequest req){
		HttpServletRequest request=toHttp(req);
		return isAjax(request);
	}

	/**
	 * response直接返回json对象
	 * @param ServletResponse resp
	 * @param ViewResult result
	 */
	public static void sendJson(ServletResponse resp, ViewResult result) {
		JSONObject responseJSONObject = JSONObject.fromObject(result);
		HttpServletResponse response=toHttp(resp);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(403);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(responseJSONObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * ServletRequest 转换为 HttpServletRequest
	 * @param request
	 * @return
	 */
	public static HttpServletRequest toHttp(ServletRequest request){
		return (HttpServletRequest)request;
	}
	/**
	 * ServletResponse 转换为 HttpServletResponse
	 * @param request
	 * @return
	 */
	public static HttpServletResponse toHttp(ServletResponse response){
		return (HttpServletResponse)response;
	}

	private static final String LOGIN_USER = "loginUser";

	private static final String USE_VIDEO = "useVideo";

	private static final String COURSE_FUNCTION = "courseFunction";
	/**
	 *
	 * Class Name: UserHolder.java
	 * @Description: 从session中获取登录用户对象
	 * @author liuxindong
	 * @date 2014-12-9 下午3:19:47
	 * @version 1.0
	 * @param request
	 * @return
	 */
	public static User getCurrentUser(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			User user = (User)subject.getSession().getAttribute(LOGIN_USER);
			return user;
		}
		logger.error("User is expired!");
		throw new RuntimeException("您长时间没有操作，系统已经自动将您退出，要继续操作请重新登录！");
	}

 /**
  *
  * Class Name: UserHolder.java
  * @Description: 从session中获取登录用户对象
  * @author liuxindong
  * @date 2014-12-9 下午3:19:47
  * @version 1.0
  * @param request
  * @return
  */
 public static User getCurrentUser(){
//  Object obj = request.getSession().getAttribute(LOGIN_USER);
  Subject subject = SecurityUtils.getSubject();
  if(subject != null){
	  User user = (User)subject.getSession().getAttribute(LOGIN_USER);
	   return user;
  }
  logger.error("User is expired!");
  throw new RuntimeException("您长时间没有操作，系统已经自动将您退出，要继续操作请重新登录！");
 }

 /**
  *
  * Class Name: UserHolder.java
  * @Description: 获取当前用户的公司ID
  * @author Chopin
  * @date 2015年2月2日
  * @version 1.0
  * @return
  */
// public static Integer getCurrentCompanyId(){
//     User user = getCurrentUser();
//     return user!=null?user.getCompanyId():null;
// }

// public static Integer getCurrentSchoolId(){
//     Users user = getCurrentUser();
//     return user!=null?user.getSchoolId():null;
// }

	/**
	 *
	 * @Description: 获取登录用户的id
	 * @author liuxindong
	 * @date 2014-12-9 下午3:22:36
	 * @version 1.0
	 * @param request
	 * @return
	 */
	public static Integer getCurrentUserId(HttpServletRequest request){
		User user = getCurrentUser(request);
		return user!=null?user.getId():null;
	}

	/**
	 *
	 * @Description: 获取登录用户的用户名
	 * @author liuxindong
	 * @date 2014-12-9 下午3:22:46
	 * @version 1.0
	 * @param request
	 * @return
	 */
	public static String getCurrentUserName(HttpServletRequest request){
		User user = getCurrentUser(request);
		return user.getUserName();
	}

	/**
	 *
	 * @Description: 获取登录用户所属分校id
	 * @author liuxindong
	 * @date 2014-12-9 下午3:23:03
	 * @version 1.0
	 * @param request
	 * @return
	 */
//	public static Integer getCurrentUserSchoolId(HttpServletRequest request){
//		Users user = getCurrentUser(request);
//		return user.getSchoolId();
//	}

	/**
	 *
	 * Class Name: UserHolder.java
	 * @Description: 把登录用户放到session中
	 * @author liuxindong
	 * @date 2014-12-9 下午3:20:25
	 * @version 1.0
	 * @param request
	 * @param user
	 */
	public static void setCurrentUser(HttpServletRequest request,User user){
		if(user == null){
			throw new RuntimeException("您的登录操作无效！");
		}
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().setAttribute(LOGIN_USER, user);
	}

	/**
	 *
	 * Class Name: UserHolder.java
	 * @Description: 销毁session中的登录用户对象
	 * @author liuxindong
	 * @date 2014-12-9 下午3:20:51
	 * @version 1.0
	 * @param request
	 */
	public static void distoryCurrentUser(HttpServletRequest request){
	    Subject subject = SecurityUtils.getSubject();
	    subject.getSession().removeAttribute(LOGIN_USER);
	}

	/**
	 *
	 * Class Name: UserHolder.java
	 * @Description: 销毁session
	 * @author liuxindong
	 * @date 2014-12-9 下午3:27:32
	 * @version 1.0
	 * @param request
	 */
	public static void distorySession(HttpServletRequest request){
	    Subject subject = SecurityUtils.getSubject();
	    subject.getSession().stop();
	}
	/**
	 *
	 * Class Name: WebUtils.java
	 * @Description: 新手引导如果做完写入session
	 * @author 权飞虎
	 * @date 2015年5月28日 下午3:53:09
	 * @modifier
	 * @modify-date 2015年5月28日 下午3:53:09
	 * @version 1.0
	 */
	public static void setSatus(){
		 Subject subject = SecurityUtils.getSubject();
		 subject.getSession().setAttribute("isPass", "yes");
	}
	public static Object getSatus(){
		Subject subject = SecurityUtils.getSubject();
		return subject.getSession().getAttribute("isPass");
	}

	/**
	 * 获取客户端真实IP
	 * @author chopin
	 * @param request
	 * @return
	 */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if(ip != null && ip.indexOf(",") > 0){
			ip = ip.split(",")[0];
		}
        return ip;
    }

    public static Object getSessionAttribute(String name){
    	 Subject subject = SecurityUtils.getSubject();
    	 return subject.getSession().getAttribute(name);
    }

    public static void setSessionAttribute(String name,Object value){
    	 Subject subject = SecurityUtils.getSubject();
    	 subject.getSession().setAttribute(name, value);
    }

    /**
     *
     * Class Name: WebUtils.java
     * @Description: 视频使用服务
     * @author zhang.zx
     * @date 2015年9月7日 上午10:23:00
     * @modifier
     * @modify-date 2015年9月7日 上午10:23:00
     * @version 1.0
     * @return
     */
    public static String getCompanyUseVideo(){
		Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			String type = (String) subject.getSession().getAttribute(USE_VIDEO);
			return type;
		}
		throw new RuntimeException("您长时间没有操作，系统已经自动将您退出，要继续操作请重新登录！");
	}

    /**
     *
     * Class Name: WebUtils.java
     * @Description: 课程使用方式
     * @author zhang.zx
     * @date 2015年9月7日 上午10:23:23
     * @modifier
     * @modify-date 2015年9月7日 上午10:23:23
     * @version 1.0
     * @return
     */
    public static String getCompanyCourseMethod(){
		Subject subject = SecurityUtils.getSubject();
		if(subject != null){
			String type = (String) subject.getSession().getAttribute(COURSE_FUNCTION);
			return type;
		}
		throw new RuntimeException("您长时间没有操作，系统已经自动将您退出，要继续操作请重新登录！");
	}
}
