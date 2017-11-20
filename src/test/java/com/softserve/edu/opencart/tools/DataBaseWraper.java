package com.softserve.edu.opencart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseWraper {

    private interface IDataBase {

        Connection runDataBase() throws SQLException;
    }

    private static class DataBase implements IDataBase {

        public Connection getConnection() throws SQLException {
            String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
            String user = "pekelis_usr";
            String password = "B6y0N7i5";
            return DriverManager.getConnection(jdbcUrl, user, password);
        }


        public Connection runDataBase() throws SQLException {
            return getConnection();
        }


    }

//-------------------------------------------------------------------------------------------


    private Connection connection;

    private void initDataBase() throws SQLException {
        IDataBase currentDataBase = new DataBase();
        connection = currentDataBase.runDataBase();
    }

    public DataBaseWraper() throws SQLException {
        initDataBase();
    }

    public Connection getConnection() {
        return connection;
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
