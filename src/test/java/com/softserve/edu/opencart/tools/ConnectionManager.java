package com.softserve.edu.opencart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.tools.exceptions.GeneralException;

public class ConnectionManager {
    private final static String FAILED_REGISTRATE_DRIVER = "Failed to Registrate JDBC Driver";
    private final static String FAILED_CREATE_CONNECTION = "Failed to Create Connection";
    private final static String FAILED_CLOSE_CONNECTION = "Failed to Close Connection";
    private final static String FAILED_CONNECTION = "Connection Failed";

    private IApplicationSource applicationSource;
    private Connection connection;
    private boolean isRegisteredDriver;

    public ConnectionManager(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
        isRegisteredDriver = false;
    }

    private void registerDriver() {
        // Lazy Initialization
        if (!isRegisteredDriver) {
            try {
                // TODO Add other Drivers
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                isRegisteredDriver = true;
            } catch (SQLException e) {
                throw new GeneralException(FAILED_REGISTRATE_DRIVER, e);
                //throw new RuntimeException(FAILED_REGISTRATE_DRIVER, e);
            }
        }
    }

    public Connection getConnection() {
        if (!isRegisteredDriver) {
            registerDriver();
        }
        // Lazy Initialization
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(applicationSource.getDatabaseUrl(),
                        applicationSource.getDatabaseLogin(), applicationSource.getDatabasePassword());
            } catch (SQLException e) {
                throw new GeneralException(FAILED_CREATE_CONNECTION, e);
                //throw new RuntimeException(FAILED_CREATE_CONNECTION, e);
            }
        }
        return connection;
    }

    public void autoCommitTransaction() {
        try {
            getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            throw new GeneralException(FAILED_CONNECTION, e);
            //throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new GeneralException(FAILED_CONNECTION, e);
            //throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new GeneralException(FAILED_CONNECTION, e);
            //throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new GeneralException(FAILED_CONNECTION, e);
            //throw new RuntimeException(FAILED_CONNECTION, e);
        }
    }

    public void closeAllConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new GeneralException(FAILED_CLOSE_CONNECTION, e);
                //throw new RuntimeException(FAILED_CLOSE_CONNECTION, e);
            }
        }
    }

}
