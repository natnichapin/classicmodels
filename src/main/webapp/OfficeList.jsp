<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 11/8/2022
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"--%>
<%--      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <div class="row bg-primary">
<%--    ให้เป็น component แทนที่  id = 'container' of index file--%>
        <h2>Classic Model Offices ::</h2>
    </div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div onclick="loadOffice('${office.officeCode}')"
                 class="col-2 border border-secondary p-2 m-2 div-link
         ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
<%--                ถ้ามีไอดีที่เลือกตรงกับ ไอดีของ officeCode อันไหนให้ เพิ่ม tailwind--%>
<%--                คลิกได้ทั้งก้อนของ div เมือง ประเทศ เบอร์ --%>
                <div>
<%--                    <a href="office-list?officeCode=${office.officeCode}">--%>
<%--                            ${office.city}</a>, ${office.country}--%>
                         ${office.city} - ${office.country}
                </div>
                <div> ${office.phone}</div>
            </div>
        </c:forEach>
    </div>
    <br>
    <div class="row bg-light">
        <b>Employees ::</b>
    </div>
    <div class="row">
        <c:forEach items="${selectedOffice.employees}" var="employee">
           <%-- เอา list ของ ลูกจ้างผ่าน row ที่มีไอดีตรงกับที่เลือก--%>
            <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div> ${employee.firstName}
                        ${employee.lastName} - ${employee.jobTitle}
                </div>
            </div>
        </c:forEach>
    </div>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>
