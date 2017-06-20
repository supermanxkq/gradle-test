<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
		var rootPath='<%=rootPath%>';
		</script>
<meta charset="utf-8" />
<title>空白页 - Bootstrap后台管理系统模版Ace下载</title>
<meta name="keywords"
	content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
<meta name="description"
	content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=rootPath%>/javascript/jquery/jquery.min-1.11.3.js"></script>
<!-- basic styles -->

<link href="<%=rootPath%>/stylesheets/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=rootPath%>/stylesheets/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/jquery-ui-1.10.3.custom.min.css">
<!-- fonts -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=rootPath%>/stylesheets/assets/css/ace.min.css" />

	
<link rel="stylesheet"
	href="<%=rootPath%>/stylesheets/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="<%=rootPath%>/stylesheets/assets/css/ace-skins.min.css" />

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
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
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
						<li><i class="icon-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">博客管理</a></li>
						<li class="active">博客分类</li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- /row -->
								<div class="row">
									<div class="col-sm-12">
										<div class="widget-box transparent" id="recent-box">
											<h3 class="header smaller lighter blue">博客类型</h3>
											<div class="widget-body">
												<div class="widget-main padding-4">
													<div class="tab-content padding-8 overflow-visible">
														<div id="task-tab" class="tab-pane active">
															<h4 class="smaller lighter green">
																<i class="icon-list"></i>
																可拖拽排序列表
															</h4>

															<ul id="tasks" class="item-list ui-sortable typeList">
																
															</ul>
														</div>
													</div>
												</div><!-- /widget-main -->
											</div><!-- /widget-body -->
										</div><!-- /widget-box -->
									</div><!-- /span -->

									<!-- /span -->
								</div><!-- /row -->
								<div class="row">
										<div class="col-sm-offset-3 col-md-6">
											<div class="input-group">
													<input type="text" class="form-control search-query typeName" placeholder="添加一个分类">
													<span class="input-group-btn">
														<button type="button" class="btn btn-purple btn-sm addType">
															添加
															<i class="icon-save icon-on-right bigger-110"></i>
														</button>
													</span>
												</div>
										</div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
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
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-navbar" /> <label class="lbl"
							for="ace-settings-navbar"> Fixed Navbar</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar"> Fixed Sidebar</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-breadcrumbs" /> <label class="lbl"
							for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl"> Right To Left (rtl)</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> Inside <b>.container</b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->


	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=rootPath%>/stylesheets/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="<%=rootPath%>/stylesheets/assets/js/bootstrap.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->
	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="<%=rootPath%>/stylesheets/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/bootbox.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/jquery.gritter.min.js"></script>
	<!-- ace scripts -->

	<script src="<%=rootPath%>/stylesheets/assets/js/ace-elements.min.js"></script>
	<script src="<%=rootPath%>/stylesheets/assets/js/ace.min.js"></script>


	<!-- inline scripts related to this page -->
	<script src="<%=rootPath%>/javascript/articleType/articleType.js"></script>
</body>
</html>
