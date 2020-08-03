package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultSetBackward {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        //  first move to the after last location
        //  then keep moving to previous row as long as there is more row above \
        rs.afterLast();

//        rs.previous();
//        System.out.println(rs.getString(1) + " " + rs.getString(2));
        while ( rs.previous()==true ){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }



    }

}
