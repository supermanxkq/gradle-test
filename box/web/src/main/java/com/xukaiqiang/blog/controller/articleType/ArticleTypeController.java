package com.xukaiqiang.blog.controller.articleType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xukaiqiang.blog.api.articleType.IArticleTypeService;
import com.xukaiqiang.blog.model.articleType.ArticleType;

/**
 * Controller of ArticleType
 * @author xukaiqiang
 * @date 2016-7-18
 */
@Controller
@RequestMapping("/articleType")
public class ArticleTypeController {
	
	@Autowired
	private IArticleTypeService articleTypeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ArticleType search){
		if (search == null) {
			search = new ArticleType();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleTypeServiceImpl.findArticleTypeByPage(search));
		return "articleType/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ArticleType ArticleType) {
		articleTypeServiceImpl.insert(ArticleType);
		return "ok";
	}
	@ResponseBody
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ArticleType ArticleType) {
		articleTypeServiceImpl.update(ArticleType);
		return "ok";
	}
	@ResponseBody
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		articleTypeServiceImpl.deleteArticleTypeById(id);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ArticleType getJson(Model model, @PathVariable Integer id){
		return articleTypeServiceImpl.findArticleTypeById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	@ResponseBody
	@RequestMapping("/queryAll")
	public List<ArticleType> queryAll(){
		return articleTypeServiceImpl.queryAll();
	}
	/**
	 * Class Name: ArticleTypeController.java
	 * @Description: 跳到文章分类
	 * @author Administrator
	 * @date 2016年7月23日 下午2:43:25
	 * @modifier
	 * @modify-date 2016年7月23日 下午2:43:25
	 * @version 1.0
	 * @return
	*/
	@RequestMapping("/toArticleType")
	public String toArticleType() {
		return "articleType/articleType";
	}
	
	@ResponseBody
	@RequestMapping("/orderList")
	public boolean orderList(HttpServletRequest request) {
		List<ArticleType> items = JSONArray.parseArray(request.getParameter("list"),
				ArticleType.class);
		if (items == null || items.size() == 0)
			return true;
		for (ArticleType articleType : items) {
			articleTypeServiceImpl.update(articleType);
		}
		return true;
	}
}
