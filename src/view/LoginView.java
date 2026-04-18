/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ry
 */
public class LoginView extends JFrame {
 
    private JLabel jlTitle, jlUsername, jlPassword;
    private JTextField jtxtUsername;
    private JPasswordField jtxtPassword;
    private JButton jbLogin, jbGoRegister;

    public LoginView() {
        initComponents();
    }
 
    private void initComponents() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        jlTitle = new JLabel("Login");
        jlUsername = new JLabel("Username:");
        jlPassword = new JLabel("Password:");
        jtxtUsername = new JTextField(20);
        jtxtPassword = new JPasswordField(20);
        jbLogin = new JButton("Login");
        jbGoRegister = new JButton("Create Account");
 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        panel.add(jlTitle);
        panel.add(Box.createVerticalStrut(10));
        panel.add(jlUsername);
        panel.add(jtxtUsername);
        panel.add(jlPassword);
        panel.add(jtxtPassword);
        panel.add(Box.createVerticalStrut(10));
        panel.add(jbLogin);
        panel.add(Box.createVerticalStrut(5));
        panel.add(jbGoRegister);
 
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
 
    /**
     * 
     * @param listener 
     */
    public void addLoginListener(ActionListener listener) {
        jbLogin.addActionListener(listener);
    }
 
    /**
     * 
     * @param listener 
     */
    public void addGoRegisterListener(ActionListener listener) {
        jbGoRegister.addActionListener(listener);
    }
 
    /**
     * 
     * @return jtxtUsername.getText();
     */
    public String getUsername() {
        return jtxtUsername.getText();
    }
 
    /**
     * 
     * @return String(jtxtPassword.getPassword())
     */
    public String getPassword() { 
        return new String(jtxtPassword.getPassword());
    }
 
    public void clearFields() {
        jtxtUsername.setText("");
        jtxtPassword.setText("");
    }
}