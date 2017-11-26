<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/12
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user2/modifyById" method="post" >
    用户名:<input name="username" value="${user.username}"><br/>
    权限:<input name="level" value="${user.level}"><br/>
    <input name="id" value="${user.id}" type="hidden">
    <input type="submit">


</form>
</body>
</html>
