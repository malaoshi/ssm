<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String code=request.getParameter("code");
//if(code==null)code="";
request.setAttribute("code",code);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
重定向<br/>
${code }
</body>
</html>