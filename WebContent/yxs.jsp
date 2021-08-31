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
		//回显产品名称和成本
		$.post(
			"pro",
			{action:"getform",pid:$("#pid").val()},
			function(d){
				$("[name='pname']").val(d.pname);
				$("[name='cost']").val(d.cost);
			},
			"json"
		)
		//添加月销售量数据
		$("#tj").click(function(){
			$.post(
				"pro",
				$("form").serialize(),
				function(d){
					if(d>0){
						location="pro?action=findAllSales&pid="+${param.pid };
					}
				},
				"json"
			)
		})
	})
</script>
</head>
<body>
	<center>
		<form action="" method="post">
		<input type="hidden" name="pid" id="pid" value="${param.pid }">
		<input type="hidden" name="action" value="saveSales">
		<div class="col-sm-3 row">
			产品名称:<input type="text" id="pname" name="pname" class="form-control" readonly="readonly"><span></span>
		</div>
		<div class="col-sm-3 row">
			成本:<input type="text" id="cost" name="cost" class="form-control" readonly="readonly"><span></span>
		</div>
		<div class="col-sm-3 row">
			月份:<input type="text" name="saledate" class="form-control" placeholder="请输入月份"><span></span>
		</div>
		<div class="col-sm-3 row">
			销售单价:<input type="text" name="price" class="form-control" placeholder="请输入销售单价"><span></span>
		</div>
		<div class="col-sm-3 row">
			销售数量:<input type="text" name="num" class="form-control" placeholder="请输入销售数量"><span></span>
		</div>
		<input type="button" id="tj" value="添加" class="btn btn-info">
		</form>
	</center>
</body>
</html>