package com.cybertek.jdbc.day1;

import java.sql.*;

public class GettingMoreInfoAboutResultSet {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM EMPLOYEES ");

        // ResultSetMetadata is data about the ResultSet like column count , column name
        // any many more info about the ResultSet itself
        ResultSetMetaData rsmd = rs.getMetaData();
        // counting how many columns we have in our ResultSet object
        int columnCount =  rsmd.getColumnCount() ;
        System.out.println("columnCount = " + columnCount);

        // find out column name according to the index
        String secondColumnName = rsmd.getColumnName(2);
        System.out.println("secondColumnName = " + secondColumnName);

        // How to list all the column names from the ResultSet
        // you know how many column we have using getColumnCount method
        // you know how to get column name from index getColumnName method

        for (int i = 1; i <= columnCount; i++) {
            System.out.println( rsmd.getColumnName(i) ) ;
        }




    }

}
