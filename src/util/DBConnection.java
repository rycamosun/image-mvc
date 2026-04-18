/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ry
 */
public class DBConnection {
    
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    
    /**
     * 
     * @return Connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        System.out.println("Connection Established");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
