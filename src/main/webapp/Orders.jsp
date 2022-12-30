<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/17/2022
  Time: 2:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>

    <c:forEach items="${orders.orderdetails}" var="y">
        orderNumber : ${y.orderNumber} ,
        orderLineNumber : ${y.orderLineNumber} ,
        productCode : ${y.productCode} ,
        quantityOrdered : ${y.quantityOrdered} ,
        priceEach : ${y.priceEach}
        <br>

    </c:forEach>


</body>
</html>
