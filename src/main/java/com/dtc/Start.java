package com.dtc;
import com.dtc.dbconnection.DBConnection;

public class Start {

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        dbConnection.dbOpen();
    }
}
