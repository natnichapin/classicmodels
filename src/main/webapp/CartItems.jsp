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
   <style>
       .head{
        width: 440px;
           height: 80px;
           color: black;
            background-color: antiquewhite;
           margin: 20px;
           font: 3em bolder fantasy ;
           border-radius: 5px;
           text-align: center;
           padding: 10px;
       }

   </style>
    <script>



    </script>
</head>
<body>
<div class="head">  Your Cart   </div>
<ul>
    <c:choose>
        <c:when test="${cart==null || cart.getNoOfItem()==0 }">
            <p style="color: lightslategrey ;font-weight: bold ;margin-left: 21% "> ----- NO HAVE PRODUCT -----  </p>
        </c:when>
        <c:otherwise>
            <c:forEach items="${CartItems}"  var="x" varStatus="vs">
                <li> [ ${x.product.productCode}] : ${x.product.productName}  </li><br>
                <img src="model-images/${x.product.productLine}/${x.product.productCode}.jpg" height="120" width="180"/>
                <div style="float: right;margin: 20px">
                    <p>Total : ${x.getTotal()}</p>
                    <p>Quantity : ${x.getQuantity()}</p>
                </div>

                <hr>

            </c:forEach>
            <button onclick="CreatOrder()" style="float: right" class="btn btn-success">  Confirm Order </button>
        </c:otherwise>


    </c:choose>


</ul>
</body>
</html>
