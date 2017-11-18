package com.softserve.edu.opencart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseWraper {

    private DataBase dataBase;
    private Connection connection;

    public DataBaseWraper() {
        dataBase=new DataBase();
    }


    private  class   DataBase {
        public DataBase() {
            initDataBase();
        }


        private void initDataBase() {

            String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
            String user = "pekelis_usr";
            String password = "B6y0N7i5";
            try {
                connection = DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        private Connection getConnection() {
            return connection;
        }

    }


    public DataBase getDataBase() {
        return dataBase;
    }

    public Connection getConnection() {
        return getDataBase().getConnection();
    }

    public void executeQuery(String query) throws SQLException {
        PreparedStatement pst1 = getConnection().prepareStatement(query);
        pst1.executeUpdate();

    }


    public void close() throws SQLException {
        if (getConnection() != null) {
            getConnection().close();
            connection = null;
        }
    }

}
