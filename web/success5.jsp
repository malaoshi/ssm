<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/11
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success5.jsp<br/>
el表达式获取地址栏中的code？<br/>
el表达式相当于request.getAttribute();<br/>
<br/>
<%
String code=request.getParameter("code");
out.println("code="+code);

    String name=request.getParameter("name");
    out.println("name="+name);
%>

</body>
</html>
