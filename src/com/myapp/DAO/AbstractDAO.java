package com.myapp.DAO;

import com.myapp.interfaces.DAOConnectI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.*;

public abstract class AbstractDAO implements DAOConnectI {

    protected Connection conn;

    // Setup connection with DB, using URL, userName and password
    public void getConnection()
    {

      //  Logger logger = Logger.getLogger(this.getClass().getName());

        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);  // value come from DAO interfaces

        }
        catch(Exception e)
        {
            e.printStackTrace();
          //  logger.info( e.getMessage() );

        } //catch
    }

    //close Db connection
    public void closeConnection()
    {
        try
        {
            conn.close();
        } catch(Exception e) {}
    }

}
