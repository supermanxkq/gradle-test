package com.xukaiqiang.blog.controller.lucene;

import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.xukaiqiang.blog.model.article.Article;
import com.xukaiqiang.blog.utils.DateUtil;
import com.xukaiqiang.blog.utils.HtmlRegexpUtil;


/**
 * 博客索引类
 * @author Administrator
 *
 */
public class BlogIndex {

	private Directory dir=null;
	

	/**
	 * 获取IndexWriter实例
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
//		dir=FSDirectory.open(Paths.get("D://lucene"));
		dir=FSDirectory.open(Paths.get("/usr/lucene"));
		SmartChineseAnalyzer analyzer=new SmartChineseAnalyzer();
		IndexWriterConfig iwc=new IndexWriterConfig(analyzer);
		IndexWriter writer=new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * 添加博客索引
	 * @param blog
	 */
	public void addIndex(Article article)throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(article.getId()),Field.Store.YES));
		doc.add(new TextField("title",article.getTitle(),Field.Store.YES));
		doc.add(new StringField("createTime",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",HtmlRegexpUtil.filterHtml(article.getContent()),Field.Store.YES));
		writer.addDocument(doc);
		writer.close();
	}
	
	/**
	 * 更新博客索引
	 * @param blog
	 * @throws Exception
	 */
	public void updateIndex(Article article)throws Exception{
		IndexWriter writer=getWriter();
		Document doc=new Document();
		doc.add(new StringField("id",String.valueOf(article.getId()),Field.Store.YES));
		doc.add(new TextField("title",article.getTitle(),Field.Store.YES));
		doc.add(new StringField("createTime",DateUtil.formatDate(new Date(), "yyyy-MM-dd"),Field.Store.YES));
		doc.add(new TextField("content",HtmlRegexpUtil.filterHtml(article.getContent()),Field.Store.YES));
		writer.updateDocument(new Term("id", String.valueOf(article.getId())), doc);
		writer.close();
	}
	
	/**
	 * 删除指定博客的索引
	 * @param blogId
	 * @throws Exception
	 */
	public void deleteIndex(String blogId)throws Exception{
		IndexWriter writer=getWriter();
		writer.deleteDocuments(new Term("id",blogId));
		writer.forceMergeDeletes(); // 强制删除
		writer.commit();
		writer.close();
	}
}
