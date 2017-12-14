package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.softserve.edu.opencart.tools.EnvironmentVariables;

public class ApplJDBC {
    private static Connection con = null;
    //private static String username = "ssu-oms";
    //private static String password = "ssu-oms";
    //private static String username = "db269";
    //private static String password = "db269";
    private static String username;
    private static String password;
//    private static String username = "root";
//    private static String password = "root";
    //private static String username = "postgres";
    //private static String password = "postgres";
    // Microsoft
    ////private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS";
    ////private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=Lv269;";
    ////private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;";
    ////private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv215Test;";
    //private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=lv196first;";
    //private static String URL = "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=Lv169OMS;";
    //private static String URL = "jdbc:sqlserver://ssu-sql12\\tc;databasename=ssu-oms;";
    // Sybase
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/lv269;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/lv257Test;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/lv235Test;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/lv215Test;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02;instance=SQLEXPRESS;";
    ////private static String URL = "jdbc:jtds:sqlserver://CLASS02/lv196first;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/Lv169OMS;instance=SQLEXPRESS;";
    // MySQL
    private static String URL;
    //private static String URL = "jdbc:mysql://192.168.195.250:3306/lv269";
    ////private static String URL = "jdbc:mysql://localhost:3306/lv269";
    //private static String URL = "jdbc:mysql://localhost:3306/lv257Test";
    //private static String URL = "jdbc:mysql://localhost:3306/lv235Test";
    //private static String URL = "jdbc:mysql://localhost:3306/lv215Test";
    //private static String URL = "jdbc:mysql://localhost:3306/measurement_devices";
    //private static String URL = "jdbc:mysql://localhost:3306/registrator_db";
    ////private static String URL = "jdbc:mysql://localhost:3306/lv196first";
    ////private static String URL = "jdbc:mysql://localhost:3306";
    // PostgresSQL
    //private static String URL = "jdbc:postgresql://192.168.195.250:5432/registrator_db";
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Start...");
        ////DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        ////DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        //
        //DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Class.forName("com.mysql.jdbc.Driver");
        //
        //DriverManager.registerDriver(new org.postgresql.Driver());
        //
        EnvironmentVariables environmentVariables = new EnvironmentVariables();
        URL = environmentVariables.getDatabaseConnection();
        username = environmentVariables.getDatabaseLogin();
        password = environmentVariables.getDatabasePassword();
        // Load the driver
        con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        }
        else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        Statement st = con.createStatement();
        // Statement allows you to send inquiries database
        //ResultSet rs = st.executeQuery("select * from TUser");
        //ResultSet rs = st.executeQuery("select * from Users");
        //ResultSet rs = st.executeQuery("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE Login = 'aaai';");
        //ResultSet rs = st.executeQuery("SELECT * FROM dbo.Users;");
        //
        //st.execute("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef, IsUserActive) VALUES ('iva1234', 'qwerty', 'ivanka1234', 'horoshko1234', 'mail@gmail.com', '1', '1', '1');");
        //ResultSet rs = st.executeQuery("SELECT * FROM users WHERE Login='iva';");
        //ResultSet rs = st.executeQuery("SELECT *  FROM Users;");
        //ResultSet rs = st.executeQuery("SELECT *  FROM Users WHERE Login LIKE 'iv%';");
        // MySQL
        //ResultSet rs = st.executeQuery("SELECT *  FROM User;");
        //st.execute("INSERT INTO user (username,isAvailable,password,firstName,lastName,organizationId) VALUES ('verificator-lv2',1,'$2a$10$59Mv7tEUrVH8iBeDsm9y7.zUcJoPHnnyOvMnC4zKRV8.wlnugQ2G2','first-lv2','last-lv2',7);");
        //st.execute("INSERT INTO user_role (username,value) VALUES ('verificator-lv2','STATE_VERIFICATOR_ADMIN');");
        //st.execute("INSERT INTO users (name,age) VALUES ('stepan',123);");
        //
        //ResultSet rs = st.executeQuery("SELECT *  FROM User WHERE username LIKE 'verifi%';");
        // ResultSet gets the result table
        //
        //st.execute("INSERT INTO TUser (name,age) VALUES ('Taras','22');");
        //ResultSet rs = st.executeQuery("select * from TUser");
        ////st.execute("INSERT INTO Empl (name,email) VALUES ('Tolik','tol@yahhoo.com');");
        ////st.execute("INSERT INTO Empl (name,email) VALUES ('Taras','tar@mail.com');");
        //st.execute("DELETE Empl WHERE name='Tolik';");
        ////st.execute("UPDATE Empl SET name='SuperTaras' WHERE name LIKE 'Tar%';");
        //
        ////st.execute("CREATE DATABASE lv207work;");
        ////st.execute("INSERT INTO MyUsers (name) VALUES ('Taras');");
        //st.execute("INSERT INTO Users (firstname,lastname,login,password,email) VALUES ('Taras','Tarasov','tara','qwerty3','a@i.ua');");
        //st.execute("UPDATE Users SET firstname='SuperTaras' WHERE lastname LIKE 'Tar%';");
        //st.execute("UPDATE MyUsers SET name='SuperTaras' WHERE name LIKE 'Tar%';");
        //st.execute("DELETE Users WHERE firstname='SuperTaras';");
        //
        //st.execute("DELETE FROM MyUsers WHERE name='Vasja';");
        //
        //st.execute("CREATE DATABASE lv269work;");
        //st.execute("use lv257work;");
        //st.execute("CREATE TABLE MyUsers (Id INT IDENTITY NOT NULL PRIMARY KEY, FirstName VARCHAR(20) NOT NULL, Mail VARCHAR(20) NOT NULL, Class INT NOT NULL);");
        //st.execute("INSERT INTO MyUsers (FirstName,Mail,Class) VALUES ('Taras2','a@i.ua','11');");
        //st.execute("INSERT INTO MyUsers (FirstName,Mail,Class) VALUES ('Petro2','p@i.ua','12');");
        //
        // SHOW TABLES;
        //DatabaseMetaData md = con.getMetaData();
        //ResultSet rs = md.getTables(null, null, "%", null);
        //while (rs.next()) {
        //  System.out.println(rs.getString(3));
        //}
        //
        //st.execute("UPDATE oc_customer_login SET total='1' WHERE email LIKE 'jar%';");
        //ResultSet rs = st.executeQuery("select * from oc_customer;");
        ResultSet rs = st.executeQuery("select * from oc_customer_login;");
        //ResultSet rs = st.executeQuery("select * from Users;");
        //ResultSet rs = st.executeQuery("select user_id, email, first_name, login, password from Users;");
        //
        int columnCount = rs.getMetaData().getColumnCount();
        // Resultset.getMetaData () get the information
        // output file
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if (rs != null) {
            rs.close(); }
        if (st != null) {
            st.close(); }
        if (con != null) {
            con.close(); }
        System.out.println("DONE");
    }
}
