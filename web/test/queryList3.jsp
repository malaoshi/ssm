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
queryList3.jsp
<br/>

<form action="../user/queryList3" id="turnPagefm">
姓名:<input name="name" value="${name }"><br/>
密码:<input name="pwd" value="${pwd }"><br/>
<input type="submit">


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
<jsp:include page="../turnPage.jsp"></jsp:include>
</form>
</body>
</html>