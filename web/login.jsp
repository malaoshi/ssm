<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//获取表单、url后面的参数
	String code=request.getParameter("code");
	if("1".equals(code)){
		out.println("用户名错误！<br/>");
	}else if("2".equals(code)){
		out.println("密码错误！<br/>");
		
	}
%>
jsp、html,前面的/，表示端口号后面的/
<form action="user2/login" method="post">
用户名:<input name="username"><br/>
密码:<input name="password"><br/>
<input type="submit">
</form>
</body>
</html>