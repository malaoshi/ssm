<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.jsoft.model.UserModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
添加成功！<br/><br/>
姓名：${name}<br/>
密码：${password}<br/>
性别：
<c:if test='${gender=="0"}'>女</c:if>
<c:if test='${gender=="1"}'>男</c:if>
<br/>
爱好：
<br/>
<c:forEach items="${likeArray}" var="item" varStatus="vs">
    ${vs.count}.${item}<br/>
</c:forEach>
<br/>
自我评价：${me}<br/>
</body>
</html>