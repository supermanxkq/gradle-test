$(function() {
	
	var ArticleType = {};
	ArticleType.init = function() {
		var $this = this;
		$this.queryList();
		$this.event();
		
	}
	//查询列表集合
	ArticleType.queryList = function() {
		$.ajax({
			async:false,
			url : rootPath+ "/articleType/queryAll",
			data : "",
			type : 'post',
			success:function(jsonData){
				$(".typeList").find(".articleType").remove();
				var  colorArray=['item-red','item-orange','item-green','item-default','item-blue','item-pink','item-grey'];
				$.each(jsonData,function(i,obj){
					$(".typeList").append(
							'<li class="'+colorArray[parseInt(Math.random()*7)]+' clearfix  articleType" data-id="'+obj.id+'" style="position: relative; opacity: 1; z-index: auto;">'+
							'<label class="inline">'+
								'<span class="lbl">'+obj.name+'</span>'+
								'<span class="inputEdit" style="display:none;"><input type="text" value="'+obj.name+'"><a href="javascript:;" onclick="ArticleType.updateType(this,'+obj.id+');">保存</a>&nbsp;&nbsp;<a href="javascript:;" onclick="ArticleType.cancelEdit(this);">取消</a></span>'+
							'</label>'+
							'<div class="pull-right action-buttons">'+
								'<a href="javascript:;" onclick="ArticleType.editType('+obj.id+',this)" class="blue">'+
									'<i class="icon-pencil bigger-130"></i>'+
								'</a>'+
								'<span class="vbar"></span>'+
								'<a href="javascript:;" onclick="ArticleType.del('+obj.id+')" class="red">'+
									'<i class="icon-trash bigger-130"></i>'+
								'</a>'+
							'</div>'+
						'</li>'
					);
				});
			}
		});
	}
	
	//删除
	ArticleType.del=function(id){
		if(confirm("确定要进行删除吗？删除之后,该分类下所有的文章将全部删除！")){
		$.ajax({
			async:false,
			url:rootPath+"/articleType/del/"+id,
			data:'',
			type:'get',
			success:function(jsonData){
				//重新查询所有的分类
				ArticleType.queryList();
				//更新一下列表索引
				ArticleType.updateIndex();
			}
		});
		}
	}
	//更新列表的索引
	ArticleType.updateIndex=function(){
		var sortMap = [];
		$(".typeList").find(".articleType").each(function(i){
			var oneItem={};
			oneItem.id=$(this).data("id");
			oneItem.sequence=$(this).index()+1;
			sortMap.push(oneItem);
		});
		 $.ajax({
	 		  type: "post", 
	 		  url : rootPath+"/articleType/orderList", 
	 		  data: "list="+JSON.stringify(sortMap),
			  beforeSend:function(XMLHttpRequest){
	          },
	 		  success: function(data){
			  },
	 		  error : function(){
	 		  },
	 		  complete:function(XMLHttpRequest,textStatus){
		      }
	 	 });
	}
	//隐藏文字显示输入框
	ArticleType.editType=function(id,obj){
		//把所有其他的都隐藏了
		$(".typeList").find(".articleType").siblings().find(".inputEdit").hide();
		$(".typeList").find(".articleType").siblings().find(".lbl:hidden").show();
		$(obj).parent().prev().find(".lbl").hide();
		$(obj).parent().prev().find(".inputEdit").show();
	}
	//取消编辑
	ArticleType.cancelEdit=function(obj){
		$(obj).parent().prev(".lbl:hidden").show();
		$(obj).parent().hide();
	}
	//修改类别
	ArticleType.updateType=function(obj,id){
		var name=$(obj).prev().val();
		var data={};
		data.id=id;
		data.name=name;
		$.ajax({
			url:rootPath+"/articleType/update",
			data:data,
			type:'post',
			success:function(jsonData){
				ArticleType.queryList();
			}
		});
	}
	
	
	//事件
	ArticleType.event=function(){
		//添加类别
		$('.addType').on('click', function(){
			var url=rootPath+"/articleType/add";
			var data={};
			data.name=$(".typeName").val();
			data.status=1;
			data.sequence=$(".typeList").find(".articleType").length+1;
			$.ajax({
				url:url,
				data:data,
				type:'post',
				success:function(jsonData){
					ArticleType.queryList();
				}
			});
		});
		
		$('#tasks').sortable({
			opacity:0.8,
			revert:true,
			forceHelperSize:true,
			placeholder: 'draggable-placeholder',
			forcePlaceholderSize:true,
			tolerance:'pointer',
			stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
				$(ui.item).css('z-index', 'auto');
				ArticleType.updateIndex();
			},
		delay: 100,
			}
		).disableSelection();
	}
	// 声明
	window.ArticleType = ArticleType;
	$(document).ready(function() {
		ArticleType.init();
	});
})
