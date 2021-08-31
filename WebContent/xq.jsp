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
		//回显表单数据
		$.post(
			"pro",
			{action:"getform",pid:$("#pid").val()},
			function(d){
				$("[name='pname']").val(d.pname);
				$("[name='cost']").val(d.cost);
				$("[name='startdate']").val(d.startdate);
				//回显下拉框
				$.post(
					"pro",
					{action:"getsel"},
					function(dt){
						var op="";
						for (var i = 0; i < dt.length; i++) {
							if(dt[i].xid==d.xid){
								op+="<option selected value='"+dt[i].xid+"'>"+dt[i].xname+"</option>";
							}else{
								op+="<option value='"+dt[i].xid+"'>"+dt[i].xname+"</option>";
							}
						}
						$("#xid").append(op);
					},
					"json"
				)
			},
			"json"
		);
	})
</script>
</head>
<body>
	<center>
		<form action="" method="post">
		<input type="hidden" name="pid" id="pid" value="${param.pid }">
		<div class="col-sm-3 row">
			产品名称:<input type="text" id="pname" name="pname" class="form-control" readonly="readonly">
		</div>
		<div class="col-sm-3 row">
			产品线:
			<select id="xid" name="xid" class="form-control" disabled="disabled">
				<option value="">-请选择-</option>
			</select>
		</div>	
		<div class="col-sm-3 row">
			单件成本:<input type="text" name="cost" class="form-control" readonly="readonly">
		</div>
		<div class="col-sm-3 row">
			开始销售月份:<input type="text" name="startdate" class="form-control" readonly="readonly">
		</div>	
		</form>
		<a href="list.jsp" class="btn btn-success">返回</a>
		<a href="yxs.jsp?pid=${param.pid }" class="btn btn-info">添加月销售量</a>
		<c:if test="${list==null }">
			<c:redirect url="pro?action=findAllSales&pid=${param.pid }"></c:redirect>
		</c:if>
		<table class="table table-hover table-striped table-bordered">
		  <tr>
		    <th>序号</th>
		    <th>月份</th>
		    <th>销售量</th>
		    <th>销售单价</th>
		    <th>总毛收入</th>
		    <th>总成本</th>
		    <th>利润</th>
		  </tr>
		  <c:forEach items="${list }" var="s" varStatus="a">
		  <tr>
		    <td>${a.count }</td>
		    <td>${s.saledate.substring(0,7) }</td>
		    <td>${s.num }</td>
		    <td>${s.price }</td>
		    <td>${s.price*s.num }</td>
		    <td>${s.cost*s.num }</td>
		    <td>${s.price*s.num-s.cost*s.num }</td>
		  </tr>
		  </c:forEach>
		  <tr>
		  	<td>汇总</td>
		  	<td></td>
		  	<td>总计:${hz.countnum }</td>
		  	<td>平均:${hz.avgprice }</td>
		  	<td>总计${hz.msr }</td>
		  	<td>${hz.zcost }</td>
		  	<td>${hz.lr }</td>
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