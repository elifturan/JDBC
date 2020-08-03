package com.cybertek.jdbc.Day1;

import java.sql.*;

public class IteratingResultSetBackward {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
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
        System.out.println("----------- more moving ----------");
        // how to move to second row from here
        rs.absolute(2);
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        rs.first();
        System.out.println(rs.getString(1) + " " + rs.getString(2));
        rs.last();
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // how do I know which row number I am right now at this location
        // getRow() method return the row number
        System.out.println("rs.getRow()  = " + rs.getRow());
        // there is no count method in ResultSet
        // so in order to get the row count of the resultset
        // just return the last row number by moving cursor to last row and call getRow method




    }




}
