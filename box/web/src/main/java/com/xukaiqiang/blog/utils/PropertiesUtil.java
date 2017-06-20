package com.xukaiqiang.blog.utils;

import org.springframework.beans.factory.annotation.Value;

public class PropertiesUtil {
	private @Value("${file.storage.path}")
	String fileStoragePath;
	
	private @Value("${cc.user.id}")
	String ccUserId;
	
	private @Value("${cc.api.key}")
	String ccApiKey;
	
	private @Value("${timertask.switch.email}")
	String timerTaskSwitchEmail;
	
	private @Value("${timertask.switch.cmc}")
	String timerTaskSwitchCmc;
	
	private @Value("${timertask.switch.message}")
	String timerTaskSwitchMessage;
	
	private @Value("${timertask.switch.video}")
	String timerTaskSwitchVideo;

	private @Value("${timertask.switch.face}")
	String timerTaskSwitchFace;
	
	private @Value("${timertask.switch.live}")
	String timerTaskSwitchLive;
	
	private @Value("${timertask.switch.zsurl}")
	String timerTaskSwitchZsurl;
	
	private @Value("${timertask.switch.crm}")
	String timerTaskSwitchCrm;
	
	private @Value("${cms.thrift.api.ip}")
	String cmsThriftApiIp;
	
	private @Value("${yunduoketang.oss.imagedomain}")
	String  projectImageUrl;
	
	private @Value("${imageServicePath}")
	String imageServicePath;
	
	private @Value("${imageServiceRealPath}")
	String imageServiceRealPath;
	
	private @Value("${classTypePath}")
	String classTypePath;
	
	private @Value("${eketang.interface.setver.customer}")
	String customer;
	
	private @Value("${eketang.interface.setver.free.customer}")
	String freeCustomer;
	
	private @Value("${eketang.interface.server.address}")
	String interfaceAddress;
	
	private @Value("${eketang.interface.server.secretKey}")
	String secretKey;
	
	private @Value("${eketang.interface.server.free.secretKey}")
	String freeSecretKey;

	private @Value("${timertask.switch.cc.accout}")
	String ccAccout;

	private @Value("${eketang.live.server.address}")
	String liveAddress;
	
	
	//项目根路径
	private @Value("${hostUrl}")
	String hostUrl;
	
	private @Value("${timertask.switch.service}") 
	String companyServiceMsg;
	
	//excle文件存放路径
	private @Value("${server.excle.tempPath}")
	String exclePath;
	
	private @Value("${zhanshi.interface.setver.loginName}")
	String  zsLoginName;
	
	private @Value("${zhanshi.interface.server.address}")
	String  zsAddress;
	
	private @Value("${zhanshi.interface.server.password}")
	String  zsPassWord;
	
	private @Value("${eketang.live.login.server}")
	String eketangLogin;
	
	private @Value("${yunduoketang.ewm.image}")
	String companyEwmImage;
	
	private @Value("${yunduoketang.download.iosUrl}")
	String companyIosDownloadUrl;
	
	private @Value("${yunduoketang.download.androidUrl}")
	String companyAndoridDownloadUrl;

	public String getCcAccout() {
		return ccAccout;
	}

	public void setCcAccout(String ccAccout) {
		this.ccAccout = ccAccout;
	}
	public String getCmsThriftApiIp() {
		return cmsThriftApiIp;
	}

	public void setCmsThriftApiIp(String cmsThriftApiIp) {
		this.cmsThriftApiIp = cmsThriftApiIp;
	}

	public String getImageServicePath() {
		return imageServicePath;
	}

	public void setImageServicePath(String imageServicePath) {
		this.imageServicePath = imageServicePath;
	}

	public String getImageServiceRealPath() {
		return imageServiceRealPath;
	}

	public void setImageServiceRealPath(String imageServiceRealPath) {
		this.imageServiceRealPath = imageServiceRealPath;
	}

	public String getClassTypePath() {
		return classTypePath;
	}

	public void setClassTypePath(String classTypePath) {
		this.classTypePath = classTypePath;
	}

	public String getProjectImageUrl() {
		return projectImageUrl;
	}

	public void setProjectImageUrl(String projectImageUrl) {
		this.projectImageUrl = projectImageUrl;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getInterfaceAddress() {
		return interfaceAddress;
	}

	public void setInterfaceAddress(String interfaceAddress) {
		this.interfaceAddress = interfaceAddress;
	}

	public String getLiveAddress() {
		return liveAddress;
	}

	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getHostUrl() {
		return hostUrl;
	}

	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}

	public String getTimerTaskSwitchEmail() {
		return timerTaskSwitchEmail;
	}

	public void setTimerTaskSwitchEmail(String timerTaskSwitchEmail) {
		this.timerTaskSwitchEmail = timerTaskSwitchEmail;
	}

	public String getTimerTaskSwitchMessage() {
		return timerTaskSwitchMessage;
	}

	public void setTimerTaskSwitchMessage(String timerTaskSwitchMessage) {
		this.timerTaskSwitchMessage = timerTaskSwitchMessage;
	}

	public String getTimerTaskSwitchVideo() {
		return timerTaskSwitchVideo;
	}

	public void setTimerTaskSwitchVideo(String timerTaskSwitchVideo) {
		this.timerTaskSwitchVideo = timerTaskSwitchVideo;
	}

	public String getTimerTaskSwitchFace() {
		return timerTaskSwitchFace;
	}

	public void setTimerTaskSwitchFace(String timerTaskSwitchFace) {
		this.timerTaskSwitchFace = timerTaskSwitchFace;
	}

	public String getTimerTaskSwitchLive() {
		return timerTaskSwitchLive;
	}

	public void setTimerTaskSwitchLive(String timerTaskSwitchLive) {
		this.timerTaskSwitchLive = timerTaskSwitchLive;
	}

	public String getCompanyServiceMsg() {
		return companyServiceMsg;
	}

	public void setCompanyServiceMsg(String companyServiceMsg) {
		this.companyServiceMsg = companyServiceMsg;
	}

	public String getTimerTaskSwitchCrm() {
		return timerTaskSwitchCrm;
	}

	public void setTimerTaskSwitchCrm(String timerTaskSwitchCrm) {
		this.timerTaskSwitchCrm = timerTaskSwitchCrm;
	}

	public String getExclePath() {
		return exclePath;
	}

	public void setExclePath(String exclePath) {
		this.exclePath = exclePath;
	}

	public String getZsLoginName() {
		return zsLoginName;
	}

	public void setZsLoginName(String zsLoginName) {
		this.zsLoginName = zsLoginName;
	}

	public String getZsAddress() {
		return zsAddress;
	}

	public void setZsAddress(String zsAddress) {
		this.zsAddress = zsAddress;
	}

	public String getZsPassWord() {
		return zsPassWord;
	}

	public void setZsPassWord(String zsPassWord) {
		this.zsPassWord = zsPassWord;
	}

	public String getTimerTaskSwitchZsurl() {
		return timerTaskSwitchZsurl;
	}

	public void setTimerTaskSwitchZsurl(String timerTaskSwitchZsurl) {
		this.timerTaskSwitchZsurl = timerTaskSwitchZsurl;
	}

	public String getFileStoragePath() {
		return fileStoragePath;
	}

	public void setFileStoragePath(String fileStoragePath) {
		this.fileStoragePath = fileStoragePath;
	}

	public String getEketangLogin() {
		return eketangLogin;
	}

	public void setEketangLogin(String eketangLogin) {
		this.eketangLogin = eketangLogin;
	}

	public String getFreeCustomer() {
		return freeCustomer;
	}

	public void setFreeCustomer(String freeCustomer) {
		this.freeCustomer = freeCustomer;
	}

	public String getFreeSecretKey() {
		return freeSecretKey;
	}

	public void setFreeSecretKey(String freeSecretKey) {
		this.freeSecretKey = freeSecretKey;
	}

	public String getCompanyEwmImage() {
		return companyEwmImage;
	}

	public void setCompanyEwmImage(String companyEwmImage) {
		this.companyEwmImage = companyEwmImage;
	}

	public String getCcUserId() {
		return ccUserId;
	}

	public void setCcUserId(String ccUserId) {
		this.ccUserId = ccUserId;
	}

	public String getCcApiKey() {
		return ccApiKey;
	}

	public void setCcApiKey(String ccApiKey) {
		this.ccApiKey = ccApiKey;
	}
	public String getCompanyIosDownloadUrl() {
		return companyIosDownloadUrl;
	}

	public void setCompanyIosDownloadUrl(String companyIosDownloadUrl) {
		this.companyIosDownloadUrl = companyIosDownloadUrl;
	}

	public String getCompanyAndoridDownloadUrl() {
		return companyAndoridDownloadUrl;
	}

	public void setCompanyAndoridDownloadUrl(String companyAndoridDownloadUrl) {
		this.companyAndoridDownloadUrl = companyAndoridDownloadUrl;
	}

	public String getTimerTaskSwitchCmc() {
		return timerTaskSwitchCmc;
	}

	public void setTimerTaskSwitchCmc(String timerTaskSwitchCmc) {
		this.timerTaskSwitchCmc = timerTaskSwitchCmc;
	}
}
