<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/12
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="upload/do" >
    姓名:<input name="username"><br/>
    头像：<input type="file" name="head"><br/>
<input type="submit" value="提交">
</form>
</body>
</html>
