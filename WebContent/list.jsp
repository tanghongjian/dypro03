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
		$(".del").click(function(){
			if(confirm("确定要删除吗?")){
				$.post(
					"pro",
					{action:"del",pid:$(this).val()},
					function(d){
						if(d>0){
							location="list.jsp";
						}
					},
					"json"
				)
			}else{
				location.history();
			}
		});
		//全选
		$("#qx").click(function(){
			$(".qxk").prop("checked",true);
		})
		//全不选
		$("#qbx").click(function(){
			$(".qxk").prop("checked",false);
		})
		//反选
		$("#fx").click(function(){
			$(".qxk").each(function(){
				$(this).prop("checked",!$(this).prop("checked"));
			})
		})
	})
</script>
</head>
<body>
	<c:if test="${list==null }">
		<c:redirect url="pro?action=find"></c:redirect>
	</c:if>
	<center>
	<form action="pro" method="post" class="form-inline">
		<input type="hidden" name="action" value="find">
		 <div class="form-group">
    		<label for="gname">产品名称</label>
			<input type="text" name="pname" id="gname" class="form-control" value="${map.pname }" placeholder="请输入要查询的产品名称">
		</div>
		<div class="form-group">
			<label for="min">已经销售月数</label>
			<input type="text" name="min" id="min" class="form-control" value="${map.min }" placeholder="请输入要查询的最小月数">
		</div>
		<div class="form-group">
			<label for="max">到</label>
			<input type="text" name="max" id="max" class="form-control" value="${map.max }" placeholder="请输入要查询的最大月数">
		</div>
		<input type="submit" class="btn btn-success" value="搜索">
	</form>

	</center>
	<button id="qx" class="btn btn-primary">全选</button>
	<button id="qbx" class="btn btn-primary">全不选</button>
	<button id="fx" class="btn btn-primary">反选</button>
	<center>
		<table class="table table-hover table-striped table-bordered">
		  <tr>
		    <th>序号</th>
		    <th>产品名称</th>
		    <th>产品线名称</th>
		    <th>已经销售月数</th>
		    <th>开始销售月份</th>
		    <th>成本</th>
		    <th>操作<a href="add.jsp" class="btn btn-info">添加</a></th>
		  </tr>
		  <c:forEach items="${list }" var="m" varStatus="a">
		  <tr>
		    <td><input type="checkbox" class="qxk" value="${m.pid }">${a.count }</td>
		    <td>${m.pname }</td>
		    <td>${m.xname }</td>
		    <td>${m.m }</td>
		    <td>${m.startdate.substring(0,7) }</td>
		    <td>${m.cost }</td>
		    <td>
		    	<a class="btn btn-primary" href="xq.jsp?pid=${m.pid }">详情</a>
		    	<button class="del btn btn-danger" value="${m.pid }">删除</button>
		    </td>
		  </tr>
		  </c:forEach>
		  <tr>
		  	<td>汇总</td>
		  	<td></td>
		  	<td></td>
		  	<td>平均月:${ps.avgmonth }</td>
		  	<td></td>
		  	<td>平均:${ps.avgcost }</td>
		  	<td>总产品数:${ps.cot }</td>
		  </tr>
		</table>
		${first }
		${prev }
		当前第${page }页
		${next }
		${last }
	</center>
</body>
</html>