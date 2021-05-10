package com.myapp.runner;

import com.myapp.DAO.UserDAO;
import com.myapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args)
    {

        System.out.println("Hello Jlob");
        UserDAO udao = new UserDAO();
        List<User> users =  udao.getAllUsers();


        System.out.println(users.get(0).toString());

    }

}
