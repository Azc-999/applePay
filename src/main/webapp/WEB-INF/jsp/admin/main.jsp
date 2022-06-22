<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <title>个人中心</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap.css">
</head>
<body>
<h2>
    Welcome
    <span style="color: red">${USER_SESSION.username}</span>
    <c:if test="${empty USER_SESSION}">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/Login">登入</a>
    </c:if>
    <c:if test="${not empty USER_SESSION}">
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/logout">退出</a>
    </c:if>
</h2>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="table-responsive">
            <form id="myform">
                <table class="table table-striped table-hover">
                    <tr>
                        <th>
                            <a class="btn btn-primary"
                               href="${pageContext.request.contextPath}/main">商品大厅</a>
                        </th>
                        <th>
                            <a class="btn btn-primary"
                               href="${pageContext.request.contextPath}/selectOrder?userId=${USER_SESSION.id}">我的订单</a>
                        </th>
                        <c:if test="${ not empty productList}">
                            <th>
                                <a class="btn btn-primary" onclick="addOrder()">添加订单</a>
                            </th>
                        </c:if>
                    </tr>
                    <tr>
                        <c:if test="${ not empty orderList}">
                            <td>图片</td>
                            <td>订单号</td>
                        </c:if>
                        <c:if test="${ not empty productList}">
                            <td>选择</td>
                            <td>图片</td>
                            <td>商品编号</td>
                        </c:if>
                        <td>商品名称</td>
                        <td>价格</td>
                    </tr>
                    <c:forEach items="${orderList}" var="ordersItem">
                        <c:forEach items="${ordersItem.products}" var="product">
                            <tr>
                                <td>${ordersItem.id}</td>
                                <td>${product.image}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                    <c:forEach items="${productList}" var="productItem" varStatus="productStatus">
                        <tr>
                            <td>
                                <label for="checkbox${productItem.id}" class="d-block">
                                    <input type="checkbox" id="checkbox${productItem.id}"
                                           name="orders.products[${productStatus.index}]"
                                           value="${productItem.id}">
                                </label>
                            </td>
                            <td>${productItem.image}</td>
                            <td>${productItem.id}</td>
                            <td>${productItem.name}</td>
                            <td>${productItem.price}</td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function addOrder() {
        let url = "${pageContext.request.contextPath}/addOrder";
        let productIds = [];
        $("input[type='checkbox']:checked").each(function () {
            productIds.push(parseInt($(this).val()));
        });
        if (productIds.length === 0) {
            alert("请选择商品");
            return;
        }
        productIds = JSON.stringify(productIds).replace('[', '').replace(']', '');
        $.post(
            url,
            {
                productIds: productIds,
                userId: ${USER_SESSION.id}
            },
            function (response) {
                if (response >= 0) {
                    alert("添加成功！！！");
                } else {
                    alert("添加失败！！！");
                }
            }
        );
    }
</script>
