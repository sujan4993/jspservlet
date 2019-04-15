package com.dtc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    public static final String DB_URL="jdbc:mysql://localhost:3306/testdb";
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String USERNAME="root";
    public static final String PASSWORD="binod";

    Connection connection;


    public void dbOpen(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public PreparedStatement getPreparedStatement(String query){
        PreparedStatement preparedStatement;
        try {
             preparedStatement = connection.prepareStatement(query);
             return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




    public void dbClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
