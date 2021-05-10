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
    <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></span>    
   <form  action="LoginServlet" method="post" onSubmit="return validate()">
    <div class="col-7 col-md-5">
           <label for="username-text"><b>Login</b></label><br>
 			<input type="text" class="form-control" id="username-text" name="username"  placeholder="login">
 		  <br>
 		<label for="password-text"><b>Password</b></label><br>
 			<input type="password" class="form-control" name="password" id="password-text" required >
 			<br>  
 	  <label>
           <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span class="psw"><a href="#" class="forgot">Forgot  password?</a></span>
 			 <br> <br>
 			  <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Submit</button>
            </div>
            
          <label>Don't have an account yet? <a href="register.jsp">Sign Up</a> </label>
  			</div>  <!-- col-7 col-md-5  -->
   
   </form>  

</div>


</body>
</html>
