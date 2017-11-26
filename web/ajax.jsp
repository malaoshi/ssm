<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

function doLogin(){
	
	alert(JSON.stringify($('#myfrom').serialize()));
	
	$.ajax({   
           url:'login2/ajax',
           type:'post',   
           dataType:'json',//服务器端返回的数据格式是json
		   data: $('#myfrom').serialize(),//发给服务器端的数据
           success:function(data){   //data:服务器端返回给浏览器端的数据
			   alert(1);
			   alert(data);//object
			   alert(JSON.stringify(data));//将json对象转为json字符串
		   		//alert(data.name);
		   		//alert(data.phone);
		   		if(data.code==1){
		   			location.href='index.jsp';
		   		}else{
		   		    alert(data.msg);
                }
		   		//alert(1);
           },
		   error:function (XMLHttpRequest, textStatus, errorThrown) {
        	   		alert(XMLHttpRequest);
        	   		alert(textStatus);
        	   		alert(errorThrown);
           }
           
       });
	alert('测试');
}

</script>
<body>
<form action="" id="myfrom">
用户名：<input name="username"><br/>
密码：<input name="password"><br/>
<input type="button" value="登录" onclick="doLogin()">
</form>
</body>
</html>