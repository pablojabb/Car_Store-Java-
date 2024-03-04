package com.raven.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbase {

    private static dbase instance = null;
    private static final String DB_URL = "jdbc:sqlite:shop.db";

    private dbase() {
    }

    public static dbase getInstance() {
        if (instance == null) {
            instance = new dbase();
        }
        return instance;
    }

    public static Connection urcon() {

        try {

            Class.forName("org.sqlite.JDBC");
            System.out.println("connected");
            return DriverManager.getConnection(DB_URL);

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);
            return null;
        }

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
