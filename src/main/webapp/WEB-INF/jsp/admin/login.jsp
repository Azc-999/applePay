<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <title>用户登入</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/bootstrap.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h3>云查阅-图书管理系统</h3>
        <span class="text-danger tab-content">${msg}</span>
        <form action="${pageContext.request.contextPath}/login" method="post" class="form-inline">
            <label for="name">用户名：<input class="form-control" type="text" name="username" id="name" required></label><br><br>
            <label for="pwd">密码：
                <input class="form-control" type="password" name="password" id="pwd" required></label><br><br>
            <input class="btn btn-success" type="submit" value="登入">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Register">没有账号？去注册</a>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
