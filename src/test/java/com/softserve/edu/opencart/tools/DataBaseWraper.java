package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseWraper {

    private interface IDataBase {

        Connection runDataBase();
    }

    private static class DataBase implements IDataBase {

        public Connection getConnection() throws SQLException {
            String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
            String user = "pekelis_usr";
            String password = "B6y0N7i5";
            Connection connection1 = null;

            return DriverManager.getConnection(jdbcUrl, user, password);

        }

        public Connection runDataBase() {
            Connection tempConnection = null;
            try {

                tempConnection = getConnection();
            } catch (SQLException e) {
                ErrorUtils.createSQLException(tempConnection==null, String.format("SQL Exception: %s", e));

            } finally {
                return tempConnection;
            }
        }

    }

//-------------------------------------------------------------------------------------------


    private Connection connection;

    private void initDataBase() {
        IDataBase currentDataBase = new DataBase();
        connection = currentDataBase.runDataBase();
    }

    public DataBaseWraper() {
        initDataBase();
    }

    public Connection getConnection() {
        return connection;
    }

    public void executeQuery(String query) {
        try {
            PreparedStatement pst1 = getConnection().prepareStatement(query);
            pst1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (getConnection() != null) {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

}
