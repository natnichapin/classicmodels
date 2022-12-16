<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/14/2022
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> - List -</h1>
<ul>
    <c:choose>
        <c:when test="${message1!=null}">
            <h2> ${message1} </h2>
        </c:when>
        <c:otherwise>
            <c:forEach items="${HistoryItem}"  var="x" varStatus="vs">
                <li> [ ${x.product.productCode}] : ${x.product.productName}  </li>
                <img src="model-images/${x.product.productLine}/${x.product.productCode}.jpg" height="120" width="180"/>
                <div style="float: right;margin: 20px">
                    <p>Total : ${x.getTotal()}</p>
                    <p>Quantity : ${x.getQuantity()}</p>
                </div>

                <hr>

            </c:forEach>
        </c:otherwise>


    </c:choose>


</ul>
</body>
</html>
