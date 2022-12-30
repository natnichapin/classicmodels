<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/15/2022
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script>

        function OrderDetail(param) {

            const xhttp = new XMLHttpRequest();
            xhttp.onload = function () {

                document.getElementById("content"+param).innerHTML = xhttp.responseText;
                // $('#viewCartModal').modal('show');
            }
            xhttp.open("GET","../Orders?"+"id="+param);
            xhttp.send();

            }


    </script>
</head>
<body>
<h1> Customer List by 64130500021 - Natnicha Sirinipatkul</h1>
<c:forEach items="${customers}" var="x"  varStatus="va">
    <h3>  ${x.customerNumber} ${x.customerName} ${x.city} ${x.country} </h3>
    <hr>
    <c:forEach items="${x.orders}" var="y" varStatus="vs">
        <p>   021-${y.orderNumber} ${y.orderDate} ${y.shippedDate} ${y.status}</p>
        <button onclick="OrderDetail(${y.orderNumber})">ShowOrderDetail</button>
        <div id="content${y.orderNumber}"> </div>


    </c:forEach>
</c:forEach>

</body>
</html>
