<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 11/14/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">--%>
    <div class="row pt-4 align-items-center">
        <c:forEach items="${products}" var="p" varStatus="vs">
            <div class="col-2 my-1 mx-3">
                <div class="img-fluid img-thumbnail" title="${p.productCode}">
                    <img src="model-images/${p.productLine}/${p.productCode}.jpg" height="120" width="180"/>
                </div>
                <div>${p.productName} <span style="text-align: right">${p.msrp}</span>
                    <span style="color: darkred;margin-left: 2px;cursor: pointer">
                    <i class="bi bi-bag-plus" onclick="addToCart('${p.productCode}')"></i></span>
                </div>
            </div>
        </c:forEach>
    </div>
    <hr>

    <div class="d-flex flex-row">
        <c:set var="totalPage" value="${itemCount/pageSize+(itemCount%pageSize==0 ? 0 : 1)}"/>
<%--       สามารถให้ contorler เป็นคนทำก็ได้ ตรง totalPage --%>
        <div class="px-1">page:</div>
        <div class="px-1 mx-1 div-link"
             onclick="loadProduct(page=${page<=1?totalPage:page-1}, ${pageSize})"> &lt;
        </div>
        <c:forEach begin="1" end="${totalPage}" varStatus="vs">
            <c:choose>
                <c:when test="${vs.count==page}">
                    <div class="px-1 mx-1 div-link text-light bg-dark"> ${vs.count} </div>
                </c:when>
                <c:otherwise>
<%--                    เพิ่ม onclick แทน link --%>
                    <%--     <a href="product-list?page=${vs.count}&pageSize=${pageSize}"> --%>
                             <div class="px-1 mx-1 div-link" onclick="loadProduct(page=${vs.count}, ${pageSize})">
                                     ${vs.count}
                             </div>
                    <%--     </a> --%>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <div class="px-1 mx-2 div-link"
             onclick="loadProduct(page=${page>=totalPage?1:page+1}, ${pageSize})"> &gt;
        </div>
        <div class="px-4 mx-1">
            items per page:
            <select id="itemsPage" onchange="loadProduct(1)">
                <option value="5" ${pageSize==5?'selected':''}>5</option>
                <option value="10" ${pageSize==10?'selected':''}>10</option>
                <option value="15" ${pageSize==15?'selected':''}>15</option>
                <option value="20" ${pageSize==20?'selected':''}>20</option>
                <option value="50" ${pageSize==50?'selected':''}>50</option>
            </select>
        </div>
    </div>

<%--</div>
</body>
</html>--%>
