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
</head>
<body>
    Enter username:<input type="text" name="UserName" id="User" ><br>
    <input type="submit" value="login" onclick="sendName()">

</body>
</html>
