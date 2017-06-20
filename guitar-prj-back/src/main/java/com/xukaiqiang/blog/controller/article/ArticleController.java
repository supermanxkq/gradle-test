package com.xukaiqiang.blog.controller.article;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.xukaiqiang.blog.api.article.IArticleService;
import com.xukaiqiang.blog.common.PageFinder;
import com.xukaiqiang.blog.controller.lucene.BlogIndex;
import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.model.article.QueryArticleVo;
import com.xukaiqiang.blog.vo.article.QueryArticleListVo;

/**
 * Controller of Article
 * 
 * @author xukaiqiang
 * @date 2016-7-18
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private IArticleService articleServiceImpl;
	
	BlogIndex blogIndex=new BlogIndex();

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Article search) {
		if (search == null) {
			search = new Article();
			// search.setPageSize(20);
		}
		model.addAttribute("list", articleServiceImpl.findArticleByPage(search));
		return "article/list";
	}

	
	/**
	 * Class Name: ArticleController.java
	 * @Description: 添加博客信息
	 * @author Administrator
	 * @date 2016年8月28日 上午1:00:10
	 * @modifier
	 * @modify-date 2016年8月28日 上午1:00:10
	 * @version 1.0
	 * @param article
	 * @return
	 * @throws Exception
	*/
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(Article article) throws Exception {
		articleServiceImpl.insert(article);
		blogIndex.addIndex(article);
		return "ok";
	}
	
	/**
	 * Class Name: ArticleController.java
	 * @Description: 更新博客信息
	 * @author Administrator
	 * @date 2016年8月28日 上午1:00:29
	 * @modifier
	 * @modify-date 2016年8月28日 上午1:00:29
	 * @version 1.0
	 * @param article
	 * @return
	 * @throws Exception
	*/
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Article article) throws Exception {
		Article article2=articleServiceImpl.findArticleById(article.getId());
		article2.setContent(article.getContent());
		article2.setTitle(article.getTitle());
		article2.setType(article.getType());
		article2.setTypeId(article.getTypeId());
		article2.setUserId(article.getUserId());
		article2.setSummary(article.getSummary());
		articleServiceImpl.update(article2);
		blogIndex.updateIndex(article2);
		return "ok";
	}
	
	/**
	 * 
	 * Class Name: ArticleController.java
	 * @Description: 置顶和取消置顶
	 * @author Administrator
	 * @date 2016年8月28日 上午3:18:02
	 * @modifier
	 * @modify-date 2016年8月28日 上午3:18:02
	 * @version 1.0
	 * @param article
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTop", method = RequestMethod.POST)
	public String updateTop(Article article){
		articleServiceImpl.update(article);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) throws Exception {
		articleServiceImpl.deleteArticleById(id);
		blogIndex.deleteIndex(id.toString());
		return "1";
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Article getJson(Model model, @PathVariable Integer id) {
		return articleServiceImpl.findArticleById(id);
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

	/**
	 * Class Name: ArticleController.java
	 * 
	 * @Description: 查询博客列表
	 * @author Administrator
	 * @date 2016年7月19日 上午12:51:03
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:51:03
	 * @version 1.0
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryArticleList")
	public PageFinder<QueryArticleListVo> queryArticleList(Model model, QueryArticleListVo search) {
		PageFinder<QueryArticleListVo> pageFinder = articleServiceImpl
				.queryArticleList(search);
		return pageFinder;
	}

	/**
	 * Class Name: ArticleController.java
	 * 
	 * @Description: 查询类别下的数量
	 * @author Administrator
	 * @date 2016年7月19日 上午12:51:03
	 * @modifier
	 * @modify-date 2016年7月19日 上午12:51:03
	 * @version 1.0
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryTypeCount")
	public List<QueryArticleVo> queryTypeCount() {
		List<QueryArticleVo> list = articleServiceImpl.queryTypeCount();
		return list;
	}
	/**
	 * 
	 * Class Name: ArticleController.java
	 * @Description: 文章列表页面
	 * @author Administrator
	 * @date 2016年7月20日 下午9:21:26
	 * @modifier
	 * @modify-date 2016年7月20日 下午9:21:26
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/toArticle")
	public String toArticle() {
		return "article/article";
	}
	/**
	 * Class Name: ArticleController.java
	 * @Description: 添加页面
	 * @author Administrator
	 * @date 2016年7月20日 下午9:22:12
	 * @modifier
	 * @modify-date 2016年7月20日 下午9:22:12
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "article/add";
	}
	
	/**
	 * 
	 * Class Name: ArticleController.java
	 * @Description: 查找文章
	 * @author Administrator
	 * @date 2016年7月21日 下午5:55:55
	 * @modifier
	 * @modify-date 2016年7月21日 下午5:55:55
	 * @version 1.0
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findArticle/{id}")
	public String findArticle(@PathVariable Integer id,Model model){
			model.addAttribute("article", articleServiceImpl.findArticleById(id));
			return "article/add";
	}
	
	@RequestMapping("/toIndex")
	public String toIndex() {
		return "index/index";
	}
}
