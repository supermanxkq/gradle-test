package com.xukaiqiang.blog.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class FileUtil {
	static Logger log=Logger.getLogger(FileUtil.class);
	
	private static Resource resource = new ClassPathResource("config.properties");
	private static Properties props=null ;
	private static OSSClient client=null;
	private static String BUCKET;
	
	
	public interface Module{
		/**
		 * 课程封面
		 */
		String COURSE="course";
		/**
		 * 轮播图
		 */
		String CYCLLEPIC="cycllepic";
		/**
		 * 新闻公告
		 */
		String NEWS="news";
		/**
		 * 头像
		 */
		String HEADPIC="headpic";
		/**
		 * 公司相关
		 */
		String COMPANY="company";
		/**
		 * 临时文件
		 */
		String TEMP="temp";
		/**
		 * 课程资料
		 */
		String COURSEFILE="coursefile";
		/**
		 * 编辑器
		 */
		String EDITOR="editor";
		/**
		 * 老师
		 */
		String TEACHER="teacher";
		
	}
	
	private static void init(){
		try{
			props=PropertiesLoaderUtils.loadProperties(resource);
			String endpoint=props.getProperty("yunduoketang.oss.endpoint");
	    	String accessKeyId=props.getProperty("yunduoketang.oss.accessKeyId");
	    	String accessKeySecret=props.getProperty("yunduoketang.oss.accessKeySecret");
	    	BUCKET=props.getProperty("yunduoketang.oss.bucket");
	    	client=new OSSClient(endpoint,accessKeyId, accessKeySecret);
		}catch(Exception e){
			log.error("OSS-client初始化失败，原因："+e);
		}
	}
	
	/**
	 * 获取文件夹
	 * @param company
	 * @return
	 */
	private static String getPath(String module,String company,String fileName){
		String folder="temp";
    	if(StringUtils.isNotBlank(module)){
    		if(Module.COMPANY.equals(module) 
    				|| Module.COURSE.equals(module) 
    				||Module.CYCLLEPIC.equals(module) 
    				||Module.EDITOR.equals(module) 
    				||Module.HEADPIC.equals(module) 
    				||Module.NEWS.equals(module) 
    				|| Module.TEMP.equals(module) 
    				||Module.COURSEFILE.equals(module)
    				||Module.TEACHER.equals(module)
    				){
    			folder=module;
    		}
    	}
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	String date=sdf.format(new Date());
    	if(StringUtils.isNotBlank(company)){
    		folder+="/"+company+"/"+date+"/";
    	}else{
    		folder+="/public/"+date+"/";
    	}
    	folder+=fileName;
    	return folder;
	}
	
	private static void inputstreamtofile(InputStream ins, File file) {
		OutputStream os=null;
		try{
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		}catch(Exception e){
			log.error("inputstreamtofile 过程异常,原因："+e);
		}finally{
			try{
			os.close();
			ins.close();
			}catch(Exception ex){
				log.error("inputstreamtofile 过程异常,原因："+ex.getStackTrace());
			}
		}
		
	}
	/**
	 * 判断是否为图像
	 * @param path
	 * @return
	 */
	private static Boolean isImage(String name){
		String[] type={"jpg","png","bmp","gif","jpeg"};
		String suffixName=name.substring(name.lastIndexOf(".")).toLowerCase();
		boolean isImage=false;
		for(int i=0;i<type.length;i++){
			if(suffixName.equals(type[i])){
				isImage=true;
			}
		}
		return isImage;
	}
	
	
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
	    Boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
    public static boolean DeleteFolder(String sPath) {
    	Boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }
    
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteOssFile(String sPath) {  
	  return false;
	}  
    
    
    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        Boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param filePath 原始文件路径
     * @param module 模块,必须是Module里的值，如果不是则会存到temp中
     * @param company  公司id，如果是公用的，可以为空  
     * @return
     * @throws IOException 
     */
    public static String upload(MultipartFile mFile,String module,String company) throws Exception{
    	// 初始化OSSClient
    	init();
    	String fileName=generateFileName(mFile.getOriginalFilename());
    	String path=getPath(module,company,fileName);
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET);
    	// "/" 为文件夹的分隔符
    	listObjectsRequest.setDelimiter("/");
    	ObjectListing listing = client.listObjects(listObjectsRequest);
    	String[] folders=path.split("/");
//    	for(int i=0;i<folders.length-1;i++){
//    		if(StringUtils.isNotBlank(folders[i])){
//    			Boolean hasFolder=false;
//        		for (String commonPrefix : listing.getCommonPrefixes()) {
//        			if(commonPrefix.equals(folders[i])){
//            			hasFolder=true;
//            		}
//        		}
//        		//如果没有就新建
//            	if(!hasFolder){
//            		createFolder(module,"",folders[i]);
//            	}
//    		}
//			
//		}
    	// 获取指定文件的输入流
    	InputStream content = mFile.getInputStream();
    	// 创建上传Object的Metadata
    	ObjectMetadata meta = new ObjectMetadata();
    	if(isImage(mFile.getOriginalFilename())){
    		meta.setContentType("image/jpeg");
    	}
    	// 必须设置ContentLength
    	meta.setContentLength(mFile.getSize());
    	// 上传Object.
    	PutObjectResult result = client.putObject(BUCKET, path, content, meta);
    	System.out.println(result.getETag());
    	if(isImage(mFile.getOriginalFilename())){
    		return getImageURL( mFile.getOriginalFilename());
    	}else{
        	return path;
    	}
    }
    
    /**
     * 
     * @param filePath 原始文件路径
     * @param module 模块,必须是Module里的值，如果不是则会存到temp中
     * @param company  公司id，如果是公用的，可以为空  
     * @return
     * @throws FileNotFoundException 
     */
    public static String upload(String filePath,String module,String company) throws Exception{
    	// 初始化OSSClient
    	init();
    	String fileName=generateFileName(filePath);
    	String path=getPath(module, company, fileName);
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET);
    	// "/" 为文件夹的分隔符
    	listObjectsRequest.setDelimiter("/");
    	ObjectListing listing = client.listObjects(listObjectsRequest);
    	String[] folders=path.split("/");
//    	for(int i=0;i<folders.length-1;i++){
//    		if(StringUtils.isNotBlank(folders[i])){
//    			Boolean hasFolder=false;
//        		for (String commonPrefix : listing.getCommonPrefixes()) {
//        			if(commonPrefix.equals(folders[i])){
//            			hasFolder=true;
//            		}
//        		}
//        		//如果没有就新建
//            	if(!hasFolder){
//            		createFolder(module,"",folders[i]);
//            	}
//    		}
//			
//		}
    	
    	// 获取指定文件的输入流
    	File file = new File(filePath);
    	InputStream content = new FileInputStream(file);
    	// 创建上传Object的Metadata
    	ObjectMetadata meta = new ObjectMetadata();
    	if(isImage(filePath)){
    		meta.setContentType("image/jpeg");
    	}
    	// 必须设置ContentLength
    	meta.setContentLength(file.length());
    	// 上传Object.
    	PutObjectResult result = client.putObject(BUCKET, path, content, meta);
    	if(isImage(fileName)){
    		return getImageURL(fileName);
    	}else{
        	return path;
    	}
    }
    
    /**
     * 
     * @param filePath 原始文件路径
     * @param module 模块,必须是Module里的值，如果不是则会存到temp中
     * @param company  公司id，如果是公用的，可以为空  
     * @return
     * @throws FileNotFoundException 
     */
    public static String upload(File file,String module,String company) throws FileNotFoundException{
    	// 初始化OSSClient
    	init();
    	String fileName=generateFileName(file.getName());
    	String path=getPath(module, company, fileName);
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET);
    	// "/" 为文件夹的分隔符
    	listObjectsRequest.setDelimiter("/");
    	ObjectListing listing = client.listObjects(listObjectsRequest);
    	String[] folders=path.split("/");
//    	for(int i=0;i<folders.length-1;i++){
//    		if(StringUtils.isNotBlank(folders[i])){
//    			Boolean hasFolder=false;
//        		for (String commonPrefix : listing.getCommonPrefixes()) {
//        			if(commonPrefix.equals(folders[i])){
//            			hasFolder=true;
//            		}
//        		}
//        		//如果没有就新建
//            	if(!hasFolder){
//            		createFolder(module,"",folders[i]);
//            	}
//    		}
//			
//		}
    	
    	// 获取指定文件的输入流
    	InputStream content = new FileInputStream(file);
    	// 创建上传Object的Metadata
    	ObjectMetadata meta = new ObjectMetadata();
    	if(isImage(fileName)){
    		meta.setContentType("image/jpeg");
    	}
    	// 必须设置ContentLength
    	meta.setContentLength(file.length());
    	// 上传Object.
    	PutObjectResult result = client.putObject(BUCKET, path, content, meta);
    	// 打印ETag
    	System.out.println(result.getETag());
    	if(isImage(fileName)){
    		return getImageURL(fileName);
    	}else{
        	return path;
    	}
    }
    
    /**
     * 
     * @param filePath 原始文件路径
     * @param module 模块,必须是Module里的值，如果不是则会存到temp中
     * @param company  公司id，如果是公用的，可以为空  
     * @return 文件名称
     * @throws FileNotFoundException 
     */
    public static String upload(InputStream file,String module,String company) throws FileNotFoundException{
    	// 初始化OSSClient
    	init();
    	String fileName=generateFileName("");
    	String path=getPath(module, company, fileName);
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET);
    	// "/" 为文件夹的分隔符
    	listObjectsRequest.setDelimiter("/");
    	ObjectListing listing = client.listObjects(listObjectsRequest);
    	String[] folders=path.split("/");
//    	for(int i=0;i<folders.length-1;i++){
//    		if(StringUtils.isNotBlank(folders[i])){
//    			Boolean hasFolder=false;
//        		for (String commonPrefix : listing.getCommonPrefixes()) {
//        			if(commonPrefix.equals(folders[i])){
//            			hasFolder=true;
//            		}
//        		}
//        		//如果没有就新建
//            	if(!hasFolder){
//            		createFolder(module,"",folders[i]);
//            	}
//    		}
//			
//		}
    	
    	// 获取指定文件的输入流
    	InputStream content = file;
    	// 创建上传Object的Metadata
    	ObjectMetadata meta = new ObjectMetadata();
    	if(isImage(fileName)){
    		meta.setContentType("image/jpeg");
    	}
    	// 必须设置ContentLength
    	meta.setContentLength(toByteArray(file).length);
    	// 上传Object.
    	PutObjectResult result = client.putObject(BUCKET, path, content, meta);
    	// 打印ETag
    	System.out.println(result.getETag());
    	if(isImage(fileName)){
    		return getImageURL(fileName);
    	}else{
        	return path;
    	}
    }
    
    public static Long uploadProcess(MultipartFile mFile,String module,String company){
    	init();
    	String fileName=generateFileName(mFile.getOriginalFilename());
    	String path=getPath(module, company, fileName);
    	try{
    	ObjectMetadata tmpObjectMeta= client.getObjectMetadata(BUCKET, path);
    		return tmpObjectMeta.getContentLength()/mFile.getSize();
    	}catch(Exception e){
    		return null;
    	}
    }
    
    public static InputStream download(String module,String fileName){
    	// 初始化OSSClient
    	init();
    	// 获取Object，返回结果为OSSObject对象
    	OSSObject object = client.getObject(BUCKET, fileName);	
    	// 获取Object的输入流
    	return object.getObjectContent();
    }
    
    public static void download(String module,String fileName,String path){
    	// 初始化OSSClient
    	init();
    	// 获取Object，返回结果为OSSObject对象
    	OSSObject object = client.getObject(BUCKET, fileName);	
    	// 获取Object的输入流
    	InputStream in=object.getObjectContent();
    	OutputStream out=null;
    	try{
			out= new FileOutputStream(path);  
			int c=0;
			while((c=in.read()) != -1){
				out.write(c);
			}
		}catch(IOException e){
			log.error("保存原图到临时磁盘失败"+e);
		}finally{
			try{
				out.close();
			}catch(Exception ex){
				log.error("输出流未关闭");
			}
		}
    }
    
    
    public static String getImageURL(String fileName){
    	String path=fileName+"@1wh.jpg";
    	return path;
    }
    
    public static void createFolder(String module,String parent,String name) {
    	// 初始化OSSClient
    	init();
    	name=name+"/";//oss规定要以/结尾
    	ObjectMetadata objectMeta = new ObjectMetadata();
    	/*这里的size为0,注意OSS本身没有文件夹的概念,这里创建的文件夹本质上是一个size为0的Object,dataStream仍然可以有数据*/
    	byte[] buffer = new byte[0];
    	ByteArrayInputStream in = new ByteArrayInputStream(buffer);
    	objectMeta.setContentLength(0);
    	try {
    		client.putObject(BUCKET, name, in, objectMeta);
    	} finally {
    		try{
    			in.close();
    		}catch(IOException e){
    			log.error("创建文件夹时释放资源异常，原因:"+e);
    		}
    	}
    	
    }
    
    public static String generateFileName(String path){
    	String suffix = "";
    	if(path.lastIndexOf(".")!=-1){
    		suffix=path.substring(path.lastIndexOf("."));
    	}
		return UUID.randomUUID().toString() + suffix;
    }

   
    public static byte[] toByteArray(InputStream input){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{
        	  byte[] buffer = new byte[4096];
              int n = 0;
              while (-1 != (n = input.read(buffer))) {
                  output.write(buffer, 0, n);
              }
        }catch(Exception e){
        	log.error(e);
        }
        return output.toByteArray();
    }

    /**
     * 
     * Class Name: FileUtil.java
     * @Description: 上传文档
     * @author 周文斌
     * @date 2015-8-11 上午11:18:13
     * @version 1.0
     * @param mFile
     * @param module
     * @param company
     * @return
     * @throws Exception
     */
    public static String uploadDocument(MultipartFile mFile,String module,String company) throws Exception{
    	// 初始化OSSClient
    	init();
    	String fileName=generateFileName(mFile.getOriginalFilename());
    	String path=getPath(module,company,fileName);
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET);
    	// "/" 为文件夹的分隔符
    	listObjectsRequest.setDelimiter("/");
    	ObjectListing listing = client.listObjects(listObjectsRequest);
    	String[] folders=path.split("/");
    	// 获取指定文件的输入流
    	InputStream content = mFile.getInputStream();
    	// 创建上传Object的Metadata
    	ObjectMetadata meta = new ObjectMetadata();
    	if(isDocument(mFile.getOriginalFilename())){
    		meta.setContentType(mFile.getContentType());
    	}
    	// 必须设置ContentLength
    	meta.setContentLength(mFile.getSize());
    	// 上传Object.
    	PutObjectResult result = client.putObject(BUCKET, path, content, meta);
    	System.out.println(result.getETag());
    	if(isDocument(mFile.getOriginalFilename())){
    		return getImageURL( mFile.getOriginalFilename());
    	}else{
        	return path;
    	}
    }
    
	/**
	 * 
	 * Class Name: FileUtil.java
	 * @Description: 判断是否为文档
	 * @author 周文斌
	 * @date 2015-8-11 上午11:19:56
	 * @version 1.0
	 * @param name
	 * @return
	 */
	private static Boolean isDocument(String name){
		String[] type={"doc","pdf","xls","ppt","docx","pptx","xlsx","wps"};
		String suffixName=name.substring(name.lastIndexOf(".")).toLowerCase();
		boolean isdoc=false;
		for(int i=0;i<type.length;i++){
			if(suffixName.equals(type[i])){
				isdoc=true;
			}
		}
		return isdoc;
	}

    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        DecimalFormat df = new DecimalFormat("#.00");
        if (size >= gb) {
            return df.format((double) size / gb) + "GB";
        } else if (size >= mb) {
            return df.format((double) size / mb) + "MB";
        } else if (size >= kb) {
            return df.format((double) size / kb) + "KB";
        } else
            return df.format((double) size) + "B";
    }
    
}
