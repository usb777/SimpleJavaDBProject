package com.myapp.service;

import com.myapp.DAO.UserDAO;
import com.myapp.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserService
{
   private  UserDAO userDAO = new UserDAO();


    /**
     * description: Output of all users
     * @param request
     * @param response
     * @throws ServletException
     * @throws SQLException
     * @throws IOException
     */
    public void listUsers(HttpServletRequest request, HttpServletResponse response) 	throws  ServletException,SQLException, IOException
    {

            UserDAO udao = new UserDAO();
            List<User> users =  udao.getAllUsers();


        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }





}
