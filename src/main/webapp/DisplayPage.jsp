<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/15/2022
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DisplayPage</title>
</head>
<body>
<c:choose>
    <c:when test="${message0!=null}"  >
        <h1> ${page} </h1>
        <p> ${message0} </p>

    </c:when>

    <c:otherwise>
        <h1> ${page} </h1>
        <p> ${user.customerNumber} - ${user.role} </p>

    </c:otherwise>


</c:choose>
</body>
</html>
