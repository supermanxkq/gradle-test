<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/decorators/import.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<script type="text/javascript">
			var rootPath='<%=rootPath%>';
		</script>
		<meta charset="utf-8" />
		<title>写博客</title>
		<meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
		<meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script src="<%=rootPath%>/javascript/jquery/jquery.min-1.11.3.js"></script>
		<!-- basic styles -->
		<link href="<%=rootPath%>/stylesheets/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		
		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="<%=rootPath%>/stylesheets/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="<%=rootPath%>/stylesheets/assets/js/html5shiv.js"></script>
		<script src="<%=rootPath%>/stylesheets/assets/js/respond.min.js"></script>
		<![endif]-->
		<!-- uediter开始 -->
		<script type="text/javascript" charset="utf-8"
			src="<%=rootPath%>/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="<%=rootPath%>/ueditor/ueditor.all.min.js">
			
		</script>
		<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
		<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
		<script type="text/javascript" charset="utf-8"
			src="<%=rootPath%>/ueditor/lang/zh-cn/zh-cn.js"></script>
		<!-- ueditoer结束 -->
	</head>

	<body>
		<!-- navbar -->
			<jsp:include page="/WEB-INF/jsp/common/navbar.jsp"></jsp:include>
		<!-- ./navbar -->

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<!-- sidebar -->
				<jsp:include page="/WEB-INF/jsp/common/sidebar.jsp"></jsp:include>
				<!-- /.sidebar -->

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">博客管理</a>
							</li>
							<li class="active">文章</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>
								写文章
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<form class="form-horizontal" role="form">
									<div class="form-group form-inline">
										<label class="col-sm-2 control-label no-padding-right articleId" for="form-field-1"  data-id="${article.id}">文章标题</label>

										<div class="col-sm-10">
											<input type="text" id="form-field-1" placeholder="文章标题" value="${article.title}" class="col-xs-10 col-sm-5 title">
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group form-inline">
										<label class="col-sm-2 control-label no-padding-right" for="form-field-2"> 文章分类 </label>

										<div class="col-sm-10 articleType" data-typeid="${article.typeId}">

										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group form-inline">
										<label class="col-sm-2 control-label no-padding-right" for="form-input-readonly">文章类型 </label>

										<div class="col-sm-10">
											<select  id="form-field-select-1" class="type">
											
												<option value="1" <c:if test="${article.type==1}">selected="selected"</c:if>>原创</option>
												<option value="0" <c:if test="${article.type==0}">selected="selected"</c:if>>转载</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label no-padding-right" for="form-input-readonly">文章内容 </label>
										<div class="col-sm-10">
											<!-- 加载编辑器的容器 --> 
											<script id="editor" type="text/plain" style="width:800px;height:500px;">${article.content}</script>
											<input type="hidden" class="contentHidden"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label no-padding-right" for="form-input-readonly">文章摘要 </label>
										<div class="col-sm-10">
											<textarea class="form-control limited summary" id="form-field-9" maxlength="150">${article.summary}</textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label no-padding-right" for="form-input-readonly">文章标签 </label>
										<div class="col-sm-10">
												<input type="text" id="form-field-1" placeholder="文章标签" value="${article.tags}" class="col-xs-10 col-sm-5 tags">
										</div>
									</div>
									<div class="space-4"></div>

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info publish" type="button">
												<i class="icon-ok bigger-110"></i>
												发表
											</button>
											&nbsp; &nbsp; &nbsp;
											<button class="btn btn-info" type="button">
												<i class="icon-save bigger-110"></i>
												立即保存
											</button>
											&nbsp; &nbsp; &nbsp;
											<button class="btn cancel" type="reset">
												<i class="icon-trash bigger-110"></i>
												舍弃
											</button>
										</div>
									</div>

								</form>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; Choose Skin</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								Inside
								<b>.container</b>
							</label>
						</div>
					</div>
				</div><!-- /#ace-settings-container -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->


		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=rootPath%>/stylesheets/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=rootPath%>/stylesheets/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=rootPath%>/stylesheets/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="<%=rootPath%>/stylesheets/assets/js/bootstrap.min.js"></script>
		<script src="<%=rootPath%>/stylesheets/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->
		<!-- ace scripts -->

		<script src="<%=rootPath%>/stylesheets/assets/js/ace-elements.min.js"></script>
		<script src="<%=rootPath%>/stylesheets/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
	<script>
	<!--初始化ueditor-->
		var ueditor = UE.getEditor('editor');
	</script>
	<script type="text/javascript" src="<%=rootPath%>/javascript/article/add.js"></script>
</body>
</html>
