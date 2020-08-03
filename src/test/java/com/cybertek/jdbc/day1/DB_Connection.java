package com.cybertek.jdbc.day1;

import java.sql.*;

public class DB_Connection {

    public static void main(String[] args) throws SQLException {

        // CONNECTION -->> STATEMENT --->> RESULTSET

        // Driver manager is used to get the connection
        // The IP address is the IP address of EC2 instance that have Oracle database
        // This is mine , so yours will your EC2 instance IP
        // This is known as connection string or url
        // it has few part
        // "jdbc:   making jdbc connection , always start with this
        // oracle:  the database vendor (RDBMS) name we are trying to connect
        // thin:    1 type of oracle driver we are using ( downloaded using pom dependency)
        // @52.71.242.164: IP address of your database server
        // 1521:    port number of your database server ,  usually 1521 for oracle , 3306 for MySql Database
        // XE  :   SID name  unique identifier for the database we are connecting
        //  In a nutshell , see it as a full address of your database you can use to make connection


        String connectionStr = "jdbc:oracle:thin:@52.71.242.164:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        // JDBC ship with JDK , and has a lot of pre-wirtten codes to work with database
        // everything we do below comes from java.sql package

        // creating connection object using DriverManager's static method Connection ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        // creating statement object using the connection we have established
        Statement stmnt = conn.createStatement();

        // ResultSet object is what we use to store the actual result we get from query
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;




        System.out.println("THE END ");




    }


}
