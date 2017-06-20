$(function(){
	var ArticleAdd={};
	ArticleAdd.init=function(){
		var $this = this;
		$this.queryAll();
		$this.event();
	}
	//查询所有分类
	ArticleAdd.queryAll=function(){
		$.ajax({
			url:rootPath+"/articleType/queryAll",
			data:"",
			type:'post',
			success:function(jsonData){
				var typeId=$(".articleType").data("typeid");
				$.each(jsonData,function(i,obj){
					$(".articleType").append('<div class="radio">'+
							'<label><input name="form-field-radio" type="radio" class="ace" value="'+obj.id+'"'+(typeId==obj.id?'checked="checked"':'')+'>'+
							'<span class="lbl"> '+obj.name+'</span>'+
						'</label>'+
					'</div>');
				});
			}
			
		});
	}
	//事件
	ArticleAdd.event=function(){
		//写文章
		$('.cancel').on('click', function(){
			window.location.href=rootPath+"/article/toArticle";
		});
		
		$('.publish').on('click',function(){
			if (!UE.getEditor('editor').hasContents()) {
				alert('请先填写内容!');
			} else {
				$(".contentHidden").val(UE.getEditor('editor').getContent());
			}
			
			var id=$(".articleId").data("id");
			var article={};
			article.id=id;
			article.title=$(".title").val();
			article.typeId=$('.articleType input[name="form-field-radio"]:checked ').val();
			article.content=$(".contentHidden").val();
			article.status=0;
			article.userId=1;
			article.type=$(".type").val();
			article.tags=$(".tags").val();
			article.isTop=0;
			article.summary=$(".summary").val();
			if(id==""){
				$.ajax({
					url:rootPath+"/article/add",
					data:article,
					type:'post',
					success:function(jsonData){
						window.location.href=rootPath+"/article/toArticle";
					}
				});
			}else{
				$.ajax({
					url:rootPath+"/article/update",
					data:article,
					type:'post',
					success:function(jsonData){
						window.location.href=rootPath+"/article/toArticle";
					}
				});
			}
		});
	}
	// 声明
	window.ArticleAdd = ArticleAdd;
	$(document).ready(function() {
		ArticleAdd.init();
	});
})