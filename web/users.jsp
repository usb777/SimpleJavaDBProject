<%--
  Created by IntelliJ IDEA.
  User: MrDzen
  Date: 5/9/2021
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.myapp.DAO.UserDAO"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.myapp.model.*" %>
<%@ page import="com.myapp.controller.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="login.jsp"> login</a> <br>
  <a href="register.jsp"> register</a>
  <%

  List<User> listusers = (List<User>)request.getAttribute("users");
 out.println("<table border='1'>");
  for(User users : listusers)
   {
       out.println("<tr>");

       out.print("<td>"+users.getId()+"</td>");
     out.print("<td>"+users.getFirstname()+"</td>");
     out.print("<td>"+users.getUsername()+"</td>");
     out.print("<td>"+users.getPassword()+"</td>");

       out.println("</tr>");
   }

      out.println("</table>");
    %>

  </body>
</html>
