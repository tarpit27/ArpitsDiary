package com.arpit.classes;

import java.sql.*;

/**
 *
 * @author arpit
 */
public class Connector {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arpitsdiary", "root", "arpit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
