package com.cybertek.jdbc.Day1;

import java.sql.*;

public class MovingForwardAndBackWardREsult {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        // if we create the Statement in this way , this will generate a forward only resultset
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultset readonly and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY) ;
        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES") ;
        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.next() ;
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        // HOW DO I GO BACK TO PREVIOUS ROW
        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

      //  rs.previous();
       // System.out.println(rs.getString("COUNTRY_ID")+" "+ rs.getString("COUNTRY_NAME"));

        //MOVING THE CURSOR FREELY BETWEEN ROWS
       // rs.previous(); we are at first row , this will move us to before first location
        //System.out.println(rs.getString("COUNTRY_ID")+" "+ rs.getString("COUNTRY_NAME"));

        //moving to the last row directly
        rs.last(); // this will move to cursor to the last location
        System.out.println(rs.getString("COUNTRY_ID")+" "+ rs.getString("COUNTRY_NAME"));

        rs.first();
        System.out.println(rs.getString("COUNTRY_ID")+" "+ rs.getString("COUNTRY_NAME"));

        rs.absolute(5);
        System.out.println(rs.getString("COUNTRY_ID")+" "+ rs.getString("COUNTRY_NAME"));


    }
}
