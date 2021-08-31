<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap-4.5.3-dist/css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="bootstrap-4.5.3-dist/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function(){
		//正则
		$("#myform").validate({
			rules:{
				pname:{
					required:true,
					remote:{
						url:"pro?action=getpname",
						type:"post",
						datatype:"json",
						data:{
							pname:function(){
								return $("#pname").val();
							}
						}
					}
				},
				xid:{
					required:true
				},
				cost:{
					required:true
				},
				startdate:{
					required:true
				}
			},
			messages:{
				pname:{
					required:"<font color='red'>产品名称不能为空</font>",
					remote:"<font color='red'>该产品已存在</font>"
				},
				xid:{
					required:"<font color='red'>产品线名称不能为空</font>"
				},
				cost:{
					required:"<font color='red'>成本不能为空</font>"
				},
				startdate:{
					required:"<font color='red'>开始销售日期不能为空</font>"
				}
			},
			errorPlacement:function(error,element){
				if(element.is(":radio")){
					error.appendTo(element.next().next());
				}else if(element.is(":checked")){
					error.appendTo(element.next());
				}else{
					error.appendTo(element.next());
				}
			},
			submitHandler:function(form){
				//添加
				$("#tj").click(function(){
					$.post(
						"pro",
						$("form").serialize(),
						function(d){
							if(d>0){
								location="list.jsp";
							}
						},
						"json"
					)
				})
			}
		})
		//查找产品线下拉框
		$.post(
			"pro",
			{action:"getsel"},
			function(d){
				var op="";
				for (var i = 0; i < d.length; i++) {
					op+="<option value='"+d[i].xid+"'>"+d[i].xname+"</option>";
				}
				$("#xid").append(op);
			},
			"json"
		)
		
	})
</script>
</head>
<body>
	<center>
		<form action="" method="post" id="myform">
		<input type="hidden" name="action" value="save">
		<div class="col-sm-3 row">
			产品名称:<input type="text" id="pname" name="pname" class="form-control" placeholder="请输入产品名称"><span></span>
		</div>
		<div class="col-sm-3 row">
			产品线:
			<select id="xid" name="xid" class="form-control">
				<option value="">-请选择-</option>
			</select><span></span>
		</div>	
		<div class="col-sm-3 row">
			单件成本:<input type="text" name="cost" class="form-control" placeholder="请输入产品成本"><span></span>
		</div>
		<div class="col-sm-3 row">
			开始销售月份:<input type="text" name="startdate" class="form-control" placeholder="请输入产品开始销售的月份" onclick="WdatePicker();"><span></span>
		</div>	
		<input type="submit" id="tj" value="添加" class="btn btn-info">
		</form>
	</center>
</body>
</html>