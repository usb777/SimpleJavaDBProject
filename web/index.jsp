<%--
  Created by IntelliJ IDEA.
  User: MrDzen
  Date: 5/9/2021
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    for (int i=0;i<3; i++) {
      out.println("Hello Jlob! <br>");
    }
  %>

  <a href="users"> show users</a><br>
  <a href="login.jsp"> login</a> <br>
  <a href="register.jsp"> register</a>
  </body>
</html>
