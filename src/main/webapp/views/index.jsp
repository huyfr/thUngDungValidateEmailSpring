<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/05/2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email Validation</title>
  </head>
  <body>
  <h1>Email validate</h1>
  <h3 style="color: red">${message}</h3>
  <form action="/home/result" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
  </form>
  </body>
</html>
