<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/25
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${result==1}">
    修改成功！
</c:if>
<c:if test="${result==0}">
    修改失败！
</c:if>
</body>
</html>
