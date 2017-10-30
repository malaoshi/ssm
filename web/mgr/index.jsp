<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理-首页</title>
</head>
<body>
<div><a>发布信息</a></div>
<c:if test="${userInfo.level>=1000}">
<div><a>添加栏目</a></div>
</c:if>
<!-- 只有超级管理员才有这个功能 -->
<c:if test="${userInfo.level>=10000}">
<div><a>添加管理员</a></div>
</c:if>
</body>
</html>