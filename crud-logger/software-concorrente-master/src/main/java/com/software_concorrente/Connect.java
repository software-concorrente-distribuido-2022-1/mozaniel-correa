package com.software_concorrente;

import java.sql.*;

public class Connect {
    public static Connection startConnection() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sergio",
                    "root", "password"
            );
            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
            return connection;
        } catch (Exception exception) {
            System.out.println(exception);
            return connection;
        }
    }
}
