package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
        public Statement getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vlsdb", "root", "test@123");
                System.out.println("connection created");
                return connection.createStatement();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }

