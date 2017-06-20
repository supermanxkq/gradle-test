<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String rootPath=request.getContextPath(); %>
<script type="text/javascript">
		var rootPath='<%=rootPath%>';
		</script>

<div class="sidebar" id="sidebar">
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil" title="写博客"></a></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active"><a href="#" class="dropdown-toggle active open"> <i
							class="icon-edit"></i> <span class="menu-text">博客管理 </span>
							<b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
									<li class="active"><a href="<%=rootPath%>/article/toArticle"> <i
								class="icon-double-angle-right"></i> <span class="menu-text">文章 </span>
						</a></li>

							<li><a href="<%=rootPath%>/articleType/toArticleType"> <i
									class="icon-double-angle-right"></i> 分类
							</a></li>

							<li><a href="treeview.html"> <i
									class="icon-double-angle-right"></i> 评论
							</a></li>
						</ul></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
			</div>