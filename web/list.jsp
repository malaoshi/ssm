<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<script type="text/javascript">

function selAll(){
	var ck=document.getElementsByName("ck");
	for(var i=0;i<ck.length;i++){
		ck[i].checked=true;
	}
}
function del(){
	var ck=document.getElementsByName("ck");
	var ids="";
	for(var i=0;i<ck.length;i++){
		if(ck[i].checked){
			ids=ids+","+ck[i].value;
		}
	}
	alert(ids);
	
}
</script>
<body>
<form id="turnPagefm" action="list">
<input name='title' value="${title }">
<input type="submit"><br/>
添加&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="del()">删除</a>
<table border="1">
<tr>
	<td><input type="checkbox" onclick="selAll();"/></td>
	<td>标题</td>
	<td>操作</td>
</tr>
<c:forEach items="${list}" var="data">
<tr>
	<td><input type="checkbox" name="ck" value="${data.id }"/></td>
	<td>${data.title }</td>
	<td>修改&nbsp;&nbsp;&nbsp;&nbsp;删除</td>
</tr>
</c:forEach>
</table>
<jsp:include page="turnPage.jsp"></jsp:include>
</form>
</body>
</html>