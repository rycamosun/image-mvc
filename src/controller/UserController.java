/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import view.LoginView;
import view.RegisterView;
import view.GalleryView;

/**
 *
 * @author ry
 */
public class UserController {

    private final UserDAO userDAO;
    private final LoginView loginView;
    private final RegisterView registerView;

    /**
     * 
     * @param loginView
     * @param registerView 
     */
    public UserController(LoginView loginView, RegisterView registerView) {
        this.userDAO = new UserDAO();
        this.loginView = loginView;
        this.registerView = registerView;

        loginView.addLoginListener(new LoginAction());
        loginView.addGoRegisterListener(new GoRegisterAction());
        registerView.addRegisterListener(new RegisterAction());
        registerView.addBackListener(new BackToLoginAction());
    }

    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            if (username.isEmpty() || password.isEmpty()) {
                return;
            }

            User user = userDAO.findByUsername(username);

            if (user == null || !user.getPassword().equals(password)) {
                return;
            }

            loginView.dispose();
            GalleryView galleryView = new GalleryView(user.getUsername());
            new ImageController(galleryView, user);
            galleryView.setVisible(true);
        }
    }

    class GoRegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            registerView.setVisible(true);
        }
    }

    class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerView.getUsername();
            String password = registerView.getPassword();

            if (username.isEmpty() || password.isEmpty()) {
                return;
            }

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            if (userDAO.registerUser(user)) {
                registerView.clearFields();
                registerView.setVisible(false);
                loginView.setVisible(true);
            } else {
            }
        }
    }

    class BackToLoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerView.setVisible(false);
            loginView.setVisible(true);
        }
    }
}
