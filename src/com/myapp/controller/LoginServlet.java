package com.myapp.controller;


import com.myapp.DAO.UserDAO;
import com.myapp.model.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

		 
		 
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 User user = new User();
    	 UserDAO udao = new UserDAO();
    	 user =udao.getUsersByUsername(userName);  	 
    	 
    	try {
    	 
    	 if ( (user.getUsername().equals(userName)) &&(user.getUsername()!= null) &&(!user.getUsername().isEmpty()))
    	 {
    		// Login through Bcryption checking
    		 if (  password.equals( user.getPassword() )    )  //user.getPassword().equals(password)
    		 {
    			 HttpSession session = null;
    			 session = request.getSession(true);
    			 
    			 int user_id = udao.getUsersByUsername(user.getUsername()).getId();
    			 session.setAttribute("user_id", user_id);
    			 
    			 System.out.println("You did it!");



    				 request.setAttribute("userName", userName); 
    				 session.setAttribute("username", userName);
    				 
    			 			//RequestDispatcher is used to send the control to the invoked page.
    						request.getRequestDispatcher("/loginok.jsp").forward(request, response);
    				     


    		 
    		 } //if
    		 
    		 else 
    		 {
    			 System.out.println("Password doesn't match");
    			 request.setAttribute("errMessage", "Wrong password"); 
    			 request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
    		 }
    		 
    	 }
    	 
    	 else 
    	 {
    		 System.out.println("Login doesn't match");
    		 request.setAttribute("errMessage", "login doesn't exist"); 
    		request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
    	 }
    	}// try 
    	catch (NullPointerException npe)
    	{
    		System.out.println("Object user is NULL");
    		request.setAttribute("errMessage", "login doesn't exist"); 
    		request.getRequestDispatcher("/login.jsp").forward(request, response);//forwarding the request
    	}
		 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	

}
