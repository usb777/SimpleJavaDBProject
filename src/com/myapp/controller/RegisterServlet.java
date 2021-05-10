package com.myapp.controller;

import com.myapp.DAO.UserDAO;
import com.myapp.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







/**
 * Servlet implementation class RegisterServlet1
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() 
    {
        super();       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{


		
		String firstname  = request.getParameter("firstname");
		String username     = request.getParameter("username");
		String password  = request.getParameter("password");
		String password1 = request.getParameter("password1");

		
		 User user = new User();
		 
		 
    	 UserDAO udao = new UserDAO();
    	 
    	 // TODO: Check username and  email , no dublicate
		
    	  if ( (username!= null) &&(!username.isEmpty()))
    	  {
    		 if (password.equals(password1))
    		  {
    			 System.out.println("You did it!");

    			 user.setFirstname(firstname);
    			 user.setUsername(username);
    			 user.setPassword(password);

    			try
    			{
    			 udao.insertUser(user);
    			}// try 
    	    	catch (Exception e)
    	    	{
    	    		request.setAttribute("errMessage", e); 
    	    		request.getRequestDispatcher("/register.jsp").forward(request, response);//forwarding the request
    	    	}
    			
    			request.setAttribute("registerOk", "You registered, please login!"); 	 			
				request.getRequestDispatcher("/register.jsp").forward(request, response);
    			 
    		  }
    		 else //password !=password1 
    		 {
    			
    			 request.setAttribute("errMessage", "Password doesn't equal Password1"); 
    			 request.getRequestDispatcher("/register.jsp").forward(request, response);//forwarding the request
    		 }
    		  
    		  
    	  }
    	  else  //Empty username
    	  {
    		 
    			 request.setAttribute("errMessage", "Username cannot be blank"); 
    			 request.getRequestDispatcher("/register.jsp").forward(request, response);//forwarding the request
    
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
