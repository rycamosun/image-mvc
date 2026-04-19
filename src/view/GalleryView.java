/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Image;

/**
 * 
 * @author ry
 */
public class GalleryView extends JFrame {

    private JButton jbUpload;
    private JPanel galleryPanel;
    private JScrollPane scrollPane;

    /**
     * 
     * @param username 
     */
    public GalleryView(String username) {
        initComponents(username);
    }

    private void initComponents(String username) {
        setTitle("Gallery - " + username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        jbUpload = new JButton("+ Upload Image");

        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.add(jbUpload);

        galleryPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        galleryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(galleryPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        setLayout(new BorderLayout());
        add(topBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * 
     * @param listener 
     */
    public void addUploadListener(ActionListener listener) {
        jbUpload.addActionListener(listener);
    }

    /**
     * 
     * @param images 
     */
    public void displayImages(List < Image > images) {
        galleryPanel.removeAll();

        for (Image img: images) {
            JLabel thumb = new JLabel();
            thumb.setPreferredSize(new Dimension(150, 150));
            thumb.setHorizontalAlignment(JLabel.CENTER);
            thumb.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            try {
                ImageIcon icon = new ImageIcon(img.getFilePath());
                java.awt.Image scaled = icon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                thumb.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                thumb.setText(img.getFileName());
            }

            thumb.setToolTipText(img.getFileName());
            galleryPanel.add(thumb);
        }

        galleryPanel.revalidate();
        galleryPanel.repaint();
    }
}