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
    private static final String URL = "jdbc:mysql://localhost:3306/image_gallery_db";
    private static final String USER = "imagegalleryplaceholder";
    private static final String PASSWORD = "password123?";
 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}