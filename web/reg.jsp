<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

function doSubmit(){
	alert(1);//目的：判断该函数是否能正确的执行
	var name=$("#username").val();//jquery根据id值获取该控件的value值，#后面都是id值
	alert(name);
	$.ajax({
	    url:'reg/check',
	    type:'POST', //GET
	    data:{
	        'name':name
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	      	alert(data);  //如果不做处理，弹出的是object，原因就是json是对象
	      	alert(JSON.stringify(data));//将json对象转换为字符串
	      	if(data.code==1){//检验成功，查无此用户
	      		document.myform.submit();
	      	}else{
	      		alert('该用户已经存在');
	      	}
	    },
	    error:function(xhr,textStatus){
	        alert("对不起，发生错误！");
	    }
	})
	
	
}

</script>
<body>
注册<br/>


传统：点击“注册”，提交表单，整个页面要刷新<br/>
ajax：点击“注册”，异步提交，判断用户名是否存在，如果存在就给出提示<br/>

<form name="myform" action="reg/doReg" method="post">
用户名:<input name="username" id="username"><br/>
密码:<input name="password" id="password"><br/>
<input type="button" value="注册" onclick="doSubmit()">
</form>
</body>
</html>