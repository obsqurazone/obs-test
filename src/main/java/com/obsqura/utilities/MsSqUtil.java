package com.obsqura.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MsSqUtil {

    private static Connection connection;
    static String url;

    public static void connect(String host, String port, String username, String password, String DatabaseName) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        url = "jdbc:sqlserver://" + host + ":" + port + ";user=" + username + ";password=" + password + ";DatabaseName" + DatabaseName +";";
    }

    public static ResultSet connect(String Queryinput, String host , String port, String username, String password, String DatabaseName) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver://" + host + ":" + port + ";user=" + username + ";password=" + password + ";DatabaseName" + DatabaseName +";";
            connect(url);
            return selectQuery(Queryinput);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet Windows_Auth_connection(String Queryinput, String host ) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver://" + host + ";databaseName=testdb;integratedSecurity=true";
            connect(url);
            return selectQuery(Queryinput);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ResultSet selectQuery(String query) throws SQLException {
        if (connection == null){
            throw new RuntimeException("No Connection made");
        }
        return connection.prepareStatement(query).executeQuery();
    }

    private static int insertQuery(String query) throws SQLException {
        if (connection == null){
            throw new RuntimeException("No Connection made");
        }
        return connection.prepareStatement(query).executeUpdate();
    }

    private static void connect(String connectionString) throws SQLException {
        connection = DriverManager.getConnection(connectionString);
    }

    public static void close() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }
}
