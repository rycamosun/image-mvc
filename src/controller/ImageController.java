/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ImageDAO;
import model.Image;
import view.GalleryView;
import model.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 *
 * @author ry
 */
public class ImageController {
 
    private final ImageDAO imageDAO;
    private final GalleryView galleryView;
    private final User currentUser;
 
    private static final String IMAGE_DIR = "saved_images/";
    
    /**
     * 
     * @param galleryView
     * @param currentUser 
     */
    public ImageController(GalleryView galleryView, User currentUser) {
        this.imageDAO    = new ImageDAO();
        this.galleryView = galleryView;
        this.currentUser = currentUser;
 
        new File(IMAGE_DIR).mkdirs();
 
        galleryView.addUploadListener(new UploadAction());
 
        refreshGallery();
    }
 
    private void refreshGallery() {
        List<Image> images = imageDAO.getImagesByUser(currentUser.getUserId());
        galleryView.displayImages(images);
    }
 
    class UploadAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select an Image");
            chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Image Files", "jpg", "png"
            ));
 
            int result = chooser.showOpenDialog(galleryView);
            if (result != JFileChooser.APPROVE_OPTION) return;
 
            File selectedFile = chooser.getSelectedFile();
            String fileName   = selectedFile.getName();
            Path destination  = Paths.get(IMAGE_DIR + fileName);
 
            try {
                Files.copy(selectedFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to copy image: " + ex.getMessage());
                return;
            }
 
            Image image = new Image();
            image.setUserId(currentUser.getUserId());
            image.setFileName(fileName);
            image.setFilePath(destination.toAbsolutePath().toString());
 
            if (imageDAO.saveImage(image)) {
                refreshGallery();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save image to database.");
            }
        }
    }
}
