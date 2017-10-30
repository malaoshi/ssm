<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
根据id删除
<form action="../user/deleteById" method="post">
id:<input name="id" value="e6251cec60d4413db6e2b98f70483e18">
<input type="submit">
</form>
<br/><br/><br/><br/>
根据id批量删除
<form action="../user/deleteByIds" method="post">
id:<br/>
<input name="id" value="1"><br/>
<input name="id" value="2"><br/>
<input name="id" value="3"><br/>
<input name="id" value="4"><br/>
<input type="submit">
</form>
</body>
</html>