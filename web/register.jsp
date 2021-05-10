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


  <div class="row">
     <span style="color:red">
			<%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
	 </span>
      <span style="color:green">
			<%=(request.getAttribute("registerOk") == null) ? "": request.getAttribute("registerOk")%>
		</span>


      <form action="RegisterServlet" method="post" onsubmit="return validate()">

          <div class="col-7 col-md-5">
              <label for="login-text"><b>First name</b></label><br>
              <input type="text" class="form-control" name="firstname" id="firstname-text" value="" placeholder="firstname" />
              <br>


              <label for="input-username"><b>username</b></label><br>
              <input type="text" class="form-control" name="username" id="input-username"  placeholder="username" required >		<br>

              <label for="input-password"><b>Password</b></label><br>
              <input type="password" class="form-control" name="password" id="input-password"  placeholder="password" required >		<br>
              <label for="input-password1"><b>Repeat password</b></label><br>
              <input type="password" class="form-control" name="password1" id="input-password1"  placeholder="password again" required >		<br>
              <div class="col-auto">
                  <button type="submit" class="btn btn-primary mb-3">Submit</button>
              </div>
          </div>  <!-- col-7 col-md-5  -->

      </form>

  </div> <!--  row -->


  </body>
</html>
