package com.myapp.DAO;

import com.myapp.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO
{
    //CRUD  - create, update, delete, insert

    /**
     * This method gets all users from table
     * @return
     */
    public List<User> getAllUsers()
    {

       List<User> users = new ArrayList<User>();
        getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(" select * from users "); // for Security
            ResultSet rs = ps.executeQuery();


            while(rs.next())
            {
                User row = new User();

                row.setId(rs.getInt(1));
                row.setFirstname(rs.getString(2));
                row.setUsername(rs.getString(3));
                row.setPassword(rs.getString(4));



                users.add(row);
            } //while
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return users;

    }



    public User getUserById(int id)
    {
        User user = new User();
        getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from users where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                User row = new User();


                row.setId(rs.getInt(1));
                row.setFirstname(rs.getString(2));
                row.setUsername(rs.getString(3));
                row.setPassword(rs.getString(4));

                user = row;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return user;

    }


    public User getUsersByUsername(String  username)
    {
        User user = new User();
        getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from users where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {

                user.setId(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPassword(rs.getString(4));

            }
            //return user;

        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {


            closeConnection();
        }


        return user;

    }








    /**
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user)
    {

        /**
         private int id;
         private String firstname;
         private String username;
         private String  password;
         */

        boolean itWorked = false;
        getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into users (firstname, username, password ) values (?,?,?)");

            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());

            itWorked = ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            closeConnection();
        }

        return itWorked;
    }




    public boolean updateUser(User user)
    {
        boolean isUserUpdate = false;


        getConnection();
        try {
            String SQL_UPDATE = "UPDATE  users SET "
                    + " firstname = ?, "  //1
                    + " username = ?,"      //2
                    + " password = ? "    //3

                    + " WHERE id =? ";   //4

            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, user.getFirstname()  );
            ps.setString(2, user.getUsername() );
            ps.setString(3, user.getPassword() );
            ps.setInt(4, user.getId() );

            isUserUpdate = ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("SQL Error is ="+e.getMessage() ) ;
            e.printStackTrace();
        } finally
        {
            closeConnection();
        }

        return isUserUpdate;
    }



    /**
     * method delete User with ID from Database
     * @param user_id
     * @return
     */
    public boolean deleteUserById(int user_id)
    {
        boolean isUserDeleted = false;
        getConnection();
        try {
            String SQL_INSERT = " DELETE from users where id= ? ";

            PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, user_id);


            isUserDeleted = ps.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }


        return isUserDeleted;

    }







}
