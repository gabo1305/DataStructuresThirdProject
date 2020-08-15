<%--
  Created by IntelliJ IDEA.
  User: Gabriel Solano
  Date: 5/8/2020
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
function sendName() {
    sessionStorage.setItem("UserBuy",document.getElementById("User").value)
    window.location.href="http://localhost:9080/log?UserName="+document.getElementById("User").value;
}
</script>


<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/userLogin.css">
</head>
<body>

<div class="logo">
    <h1>Railspot</h1>

    <p>
        Travel fast. <br>
        Travel safe.
    </p>
</div>

<div class="loginInfo">

    <p>To login as a user please enter you Identification number below</p>

    <input type="text" name="UserName" id="User" ><br>
    <input type="submit" value="login" id="btn_login" onclick="sendName()">
</div>

</body>
</html>
