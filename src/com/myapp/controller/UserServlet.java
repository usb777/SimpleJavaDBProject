package com.myapp.controller;

import com.myapp.DAO.UserDAO;
import com.myapp.model.User;
import com.myapp.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/users", "/login", "/admin/superadmin/user-insert" })
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


   // private UserDAO userDAO = null;
    private UserService userService = null;


    public void init() {
       // userDAO = new UserDAO();
        userService= new UserService();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/users":

                    userService.listUsers(request, response);
                    break;

                case "/login":
                  //  showUserInsertForm(request, response);
                    break;

                case "/admin/superadmin/user-insert":
                   // insertUser(request, response);
                    break;


                default:
                    userService.listUsers(request, response);
                    break;
            }
        } catch (SQLException ex) {   throw new ServletException(ex);
        }




    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        processRequest(request, response);


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);

    }



}
