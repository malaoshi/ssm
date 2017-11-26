
<%--
  Created by IntelliJ IDEA.
  User: mym
  Date: 2017/11/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.11.0.min.js"></script>
</head>
<body>
<a href="/addUser.jsp">添加</a>&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" onclick="delUserIds()">批量删除</a>
<form action="/user2/showUserList" method="post">
    <input name="uname" value="${uname}" placeholder="用户名/拼音首字母"/>
    级别：
    <select name="level">
        <option value="">请选择</option>
        <option value="2" <c:if test="${level==2}">selected</c:if> >管理员</option>
        <option value="1" <c:if test="${level==1}">selected</c:if>>普通用户</option>
    </select>
    <input type="submit" value="查询">
</form>
<table border="1">
    <tr>
        <td>
            序号
        </td>
        <td>用户名</td>
        <td>级别</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList}" varStatus="vs" var="it" >
        <tr>
            <td><input type="checkbox" name="userId" value="${it.id}">${vs.count}</td>
            <td>${it.username}</td>
            <td>${it.level}</td>
            <td>
                <a href="/user2/showUserById?id=${it.id}">编辑</a>
                &nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="del('${it.id}')">删除</a>
                &nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="resetPwd('${it.username}','${it.id}')">重置密码</a>
            </td>
        </tr>

    </c:forEach>
</table>

<script type="text/javascript">

    function del(userId) {
        if(confirm('您确定要删除该条记录吗?')){
            console.log(userId);
            location.href="/user2/deleteById?id="+userId;
        }
    }
    function delUserIds() {

        var eles=document.getElementsByName("userId");
        var userIds="";
        for(var i=0;i<eles.length;i++){
            if(eles[i].checked==true){
                //console.log(eles[i].value);
                userIds=userIds+","+eles[i].value;
            }
        }
        if(userIds==''){
            alert("请先勾选要删除的记录！");
            return false;
        }
        if(!confirm("您确定要删除吗？")){
            return false;
        }
        console.log(userIds);
        //ajax
        $.ajax({
            type: "POST",//请求类型
            url:"/user2/deleteByIds",
            data:{
                "ids":userIds
            },// 向服务器提交的数据
            dataType:"json",//预设服务器返回来的数据类型
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
                //成功时处理的代码
                console.log(data);
                if(data.code==1){
                    alert('删除成功！');
                    location.reload();
                }else{
                    alert("删除失败！");
                }
            }
        });
    }

    function resetPwd(userName,userId) {
        if(confirm("您确定要重置 "+userName+" 的密码吗？")){
            $.ajax({
                type: "POST",//请求类型
                url:"/user2/resetPwd",
                data:{
                    "userId":userId
                },// 向服务器提交的数据
                dataType:"json",//预设服务器返回来的数据类型
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                    //成功时处理的代码
                    console.log(data);
                    if(data.code==1){
                        alert('重置成功！');
                    }else{
                        alert(data.msg);
                    }
                }
            });
        }
    }
</script>
</body>
</html>
