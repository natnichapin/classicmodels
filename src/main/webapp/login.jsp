<%--
  Created by IntelliJ IDEA.
  User: Natnicha
  Date: 12/15/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <script>
        function login(userName, password) {
            if (userName == '' || password == '' || userName == undefined) {
                document.getElementById("login-message").innerHTML = "Invalid user name or password !!!";
            }
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function () {
                if (xhttp.status == 200) {

                    //$('#modalLoginForm').modal('hide');
                    //document.getElementById("login-menu").innerHTML = "<i class='bi bi-box-arrow-left'></i> Logout"
                } else if (xhttp.status >= 500) {
                    //document.getElementById("login-message").innerHTML = xhttp.statusText;
                } else {
                   //document.getElementById("login-message").innerHTML = "Wrong user name or password !!!";
                }
            }
            var params = "userName=" + userName + "&password=" + password;
            xhttp.open("GET", "login?" + params);
            xhttp.send();

        }
        </script>
</head>
<body>
<div>  <h1> Log in now !!!  </h1>    </div>
<label for="user">USER : </label><input type="text" id="user" >
<label for="user">USER : </label><input type="text" id="password">
<button onclick="login($('#user').val(), $('#password').val())"> Log in </button>
</body>
</html>
