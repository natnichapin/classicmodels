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

</head>
<body>
<div class="container text-center">
<c:forEach items="${customers}" var="x" varStatus="vs">
    <div class="row">
        <div class="col">
                ${x.customerNumber}
        </div>
        <div class="col">
                ${x.contactFirstName}  ${x.contactLastName}
        </div>
        <div class="col">
                ${x.role}
        </div>
    </div>


</div>

</c:forEach>


</div>
<div class="container text-center">
    <div class="row">
        <div class="col">
            Column
        </div>
        <div class="col">
            Column
        </div>
        <div class="col">
            Column
        </div>
    </div>
</div>
</body>
</html>
