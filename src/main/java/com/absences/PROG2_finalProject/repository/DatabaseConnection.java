package com.absences.PROG2_finalProject.repository;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/absence";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kef";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}