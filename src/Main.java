/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import view.LoginView;
import view.RegisterView;
import controller.UserController;

/**
 *
 * @author ry
 */

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            RegisterView registerView = new RegisterView();
            new UserController(loginView, registerView);
            loginView.setVisible(true);
        });
    }
}