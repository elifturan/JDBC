package com.cybertek.jdbc;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        //Replace the IP with your own IP address
        String connectionStr = "jdbc:oracle:thin:@YOUR_IP_HERE:1521:XE";
        String username = "hr";
        String password = "hr";

        // GETTING DATABASE CONNECTION TO THE SERVER
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // CREATING SIMPLE STATEMENT (forward only)
        Statement stmt = conn.createStatement();
        // CREATING STATEMENT with maximum flexibility of moving up and down from rows
        //Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // GETTING RESULTSET OF THE QUERY
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");
        // initially the cursor is at the location before first line of the resulting table
        // in order to move to first line  next() method is used.
        // it return true if there is a row at next location and move the cursor to next location
        // it return false if there is no more row next.
        rs.next() ;
        // right now we are at first row. to get column data as String
        System.out.println("First column value " + rs.getString(1)
                                        + " or " + rs.getString("REGION_ID") );
        System.out.println("SECOND column value " + rs.getString(2)
                                        + " or " + rs.getString("REGION_NAME") );
        rs.next() ;  // now moved to next row
        System.out.println("First column value " + rs.getString(1) + " or " + rs.getString("REGION_ID") );
        System.out.println("SECOND column value " + rs.getString(2) + " or " + rs.getString("REGION_NAME") );


        //------ cleaning up -----
        rs.close();
        stmt.close();
        conn.close();

    }
}
