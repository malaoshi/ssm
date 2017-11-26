<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/5
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="reg2/do5" method="post">
    用户名：<input name="username" value=""><br/>
    密码：<input name="password" value=""><br/>
    性别：<input type="radio" name="gender" value="0">女&nbsp;&nbsp;<input type="radio" name="gender" value="1">男<br/>
    爱好：<input name="like" type="checkbox" value="王者荣耀">王者荣耀<br/>
    <input name="like" type="checkbox" value="吃饭">吃饭<br/>
    <input name="like" type="checkbox" value="睡觉">睡觉<br/>
    <input name="like" type="checkbox" value="打豆豆">打豆豆<br/>
    自我评价：<textarea name="me"></textarea><br/>
    <input type="submit" value="提交">

</form>
</body>
</html>
