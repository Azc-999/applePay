<%--
  Created by IntelliJ IDEA.
  User: ZhouCheng
  Date: 2022/5/29
  Time: 下午 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap.css">
    <script src="${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/bootstrap.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h3>欢迎加入&nbsp;&nbsp;云查阅-图书管理系统</h3>
        <span class="text-danger tab-content" id="msg"></span>
        <form id="sb" class="form-inline">
            <label for="name">用户名：<input class="form-control" type="text" name="username" id="name"
                                         required></label><br><br>
            <label for="pwd">密码：<input class="form-control" type="password" name="password" id="pwd"
                                       required></label><br><br>
            <button type="button" class="btn btn-success" onclick="addUser()">注册</button>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Login">已有账号，返回登录</a>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
<script>
    function addUser() {
        $.ajax({
            url: "${pageContext.request.contextPath}/register",
            type: "get",
            data: $("#sb").serialize(),
            success: function (response) {
                if (response === 1) {
                    alert("欢迎你加入大家族");
                    window.location.href = "/";
                } else if (response ===0){
                    $("#msg").text("用户名或密码为空");
                }else if (response === 400){
                    $("#msg").text("用户名已存在");
                }
                else {
                    $("#msg").text("注册失败");
                }

            },
            error: function () {
                alert("error");
            }
        })
    }
</script>
</html>
