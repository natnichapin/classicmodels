<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/18/2022
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderHistory</title>
    <style>
    .box{
        display: block;
        color: dimgrey;
        background-color:whitesmoke;
        border-radius: 5px;
        margin: 40px;
        padding: 50px;
        box-sizing: border-box;



    }
    .boxOrder{
        display: block;
        background-color:lightgray;
        border-radius: 5px;
        margin: 20px;
        padding: 0px;
        box-sizing: border-box;
        color: black;
        box-shadow: darkgrey;

    }
    #OrderHead{
        color: white;
        margin: 0;
        padding: 20px;
        background-color:rgba(0,0,0,0.7);
        border-radius: 5px;
    }
    .DetailOrder{
        font-weight: lighter;
        font-size: 1.5rem;
        padding: 10px;
        margin: 40px;

    }
    button.detail{
        margin-left: 50px;
        width: 200px;
    }
    .total{
        margin-bottom: 30px;
        margin-left: 75%;
        padding-bottom: 20px;
        font-weight: lighter;
    }
    </style>
    <script>

    </script>
</head>
<body>

<h1> Orders History </h1>
<hr>
<div id="History">




    <c:forEach items="${OrderU}" var="x" varStatus="vs1">
        <div class="boxOrder">
            <h2 id="OrderHead">Order ${x.orderNumber}</h2>
            <c:set var="totalOrders" scope="request" value="${0}" />
            <div class="DetailOrder">
            <p><span style="font-weight: bolder">OrderDate</span> : ${x.orderDate}</p>
            <p><span style="font-weight: bolder">ShippedDate</span> : ${x.shippedDate}</p>
            <p><span style="font-weight: bolder">Status</span> : ${x.status}</p>
            </div>
            <button  onclick="ViewDetail(${x.orderNumber})"  class="btn btn-dark detail"> Detail </button>
            <hr>

            <div id="detailOrder${x.orderNumber}" style="display: none" >
            <c:forEach items="${x.orderdetails}" var="y" varStatus="vs2">

                <div class="box">
                    <span style="font-weight: bolder">Name</span> : ${y.product.productName}
                    <span style="font-weight: bolder"> Quantity</span> :  ${y.quantityOrdered}
                    <span style="font-weight: bolder"> Price</span> :   ${y.priceEach}
                    <img style="margin-left: 80%" src="model-images/${y.product.productLine}/${y.product.productCode}.jpg" height="120" width="180"/>

                    <c:set var="totalOrders" scope="request" value="${ totalOrders+(y.priceEach*y.quantityOrdered)}" />
                </div>
            </c:forEach>
            </div>

            <h3  class="total">  Total Price : <span style="color:midnightblue;font-weight: bolder">${String.format("%.2f", totalOrders)}</span>   </h3>
        </div>
    </c:forEach>




            <c:forEach items="${OrdersOfUser}" var="x" varStatus="vs1">
                <div class="boxOrder">
                <h2 id="OrderHead">Order ${ 20000+(vs1.index+1)}</h2>
                    <div class="DetailOrder">
                    <p><span style="font-weight: bolder">OrderDate</span>: ${NowDate}</p>
                    <p><span style="font-weight: bolder">ShippedDate</span>: ${ShipDate}</p>
                    <p><span style="font-weight: bolder">Status</span>:  Pending </p>
                    </div>
                    <c:set var="totalOrders" scope="request" value="${0}" />
                  <button   onclick="ViewDetail(20000+${vs1.index+1})"  class="btn btn-dark detail">Detail</button>

                    <hr>
                    <div id="detailOrder${20000+vs1.index+1}" style="display: none"  >
                            <c:forEach items="${x}" var="y" varStatus="vs2">

                            <div class="box">
                                    <span style="font-weight: bolder">Name</span>: ${y.getProduct().productName}
                                         <span style="font-weight: bolder"> Quantity</span> :  ${y.getQuantity()}
                                          <span style="font-weight: bolder"> Price</span> :   ${y.getTotal()}
                                        <img style="margin-left: 80%" src="model-images/${y.product.productLine}/${y.product.productCode}.jpg" height="120" width="180"/>

                                        <c:set var="totalOrders" scope="request" value="${ totalOrders+y.getTotal()}" />
                             </div>
                            </c:forEach>
                    </div>

                   <h3  class="total">  Total Price : <span style="color:midnightblue;font-weight: bolder"> ${String.format("%.2f", totalOrders)} </span> </h3>

                </div>
            </c:forEach>





</div>

</body>
</html>
