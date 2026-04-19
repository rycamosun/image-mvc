/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ry
 */
public class Image {

    private int imageId;
    private int userId;
    private String fileName;
    private String filePath;
    private String uploadedAt;

    public Image() {}

    /**
     * 
     * @param imageId
     * @param userId
     * @param fileName
     * @param filePath
     * @param uploadedAt 
     */
    public Image(int imageId, int userId, String fileName, String filePath, String uploadedAt) {
        this.imageId = imageId;
        this.userId = userId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
    }

    /**
     * 
     * @return imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * 
     * @param imageId 
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    /**
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 
     * @param fileName 
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 
     * @param filePath 
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 
     * @return uploadedAt
     */
    public String getUploadedAt() {
        return uploadedAt;
    }

    /**
     * 
     * @param uploadedAt 
     */
    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}