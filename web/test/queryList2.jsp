<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
items="  $-{-ls-}-" 里面必须是el表达式
<br/>

<form action="../user/queryList2">
姓名:<input name="name" value="${name }"><br/>
密码:<input name="pwd" value="${pwd }"><br/>
<input type="submit">
</form>

<table border='1'>
	<tr>
		<td>序号</td>
		<td>用户名</td>
		<td>密码</td>
	</tr>
	<c:forEach items="${ls}"  var="it" varStatus="vs">
	<tr>
		<td>${vs.count }</td>
		<td>${it.username }</td>
		<td>${it.password }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>