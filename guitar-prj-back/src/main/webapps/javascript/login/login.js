$(function() {
	var Login = {};
	// 初始化方法
	Login.init = function() {
		var $this = this;
		$this.event();
	}
	// 事件
	Login.event = function() {
		//点击登录按钮
		$(".loginbtn").on('click',function(){
				var user={};
				user.userName=$(".userName").val();
				user.passWord=$(".passWord").val();
				$.ajax({
					url : rootPath+ "/user/login",
					data : user,
					type : 'post',
					success:function(jsonData){
						if(jsonData=='ok')
						window.location.href=rootPath+"/article/toIndex";
					}
				})
		});
	}
	
	//声明
	window.Login = Login;
	   $(document).ready(function () {
		   Login.init();
	    })
})