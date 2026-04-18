/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Image;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ry
 */
public class ImageDAO {
 
    /**
     * 
     * @param image
     * @return true if at least one row was inserted false if the insert failed or no rows were affected
     */
    public boolean saveImage(Image image) {
        String sql = "INSERT INTO images (user_id, file_name, file_path) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, image.getUserId());
            ps.setString(2, image.getFileName());
            ps.setString(3, image.getFilePath());
            return ps.executeUpdate() > 0;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
    /**
     * 
     * @param userId
     * @return list of images objects empty list if none are found or if a database error occurs
     */
    public List<Image> getImagesByUser(int userId) {
        List<Image> images = new ArrayList<>();
        String sql = "SELECT * FROM images WHERE user_id = ? ORDER BY uploaded_at DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setImageId(rs.getInt("id"));
                image.setUserId(rs.getInt("user_id"));
                image.setFileName(rs.getString("file_name"));
                image.setFilePath(rs.getString("file_path"));
                image.setUploadedAt(rs.getString("uploaded_at"));
                images.add(image);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }
 
    /**
     * 
     * @param imageId
     * @return true if at least one row was deleted false if no matching record is real or deletion failed
     */
    public boolean deleteImage(int imageId) {
        String sql = "DELETE FROM images WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, imageId);
            return ps.executeUpdate() > 0;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}