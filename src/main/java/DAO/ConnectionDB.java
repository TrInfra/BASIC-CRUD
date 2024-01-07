package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection ConnetionDataBase() {
        Connection conn = null;
        String URL = "jdbc:postgresql://localhost:5432/Login";
        String USER = "root";
        String PASSWORD = "root";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "don't conected to database");
        }
        return conn;
    }

}
