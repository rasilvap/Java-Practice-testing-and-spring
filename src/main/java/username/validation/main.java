package username.validation;


import username.validation.view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static username.validation.util.Constants.HOME_BUTTON_LOGIN;
import static username.validation.util.Constants.HOME_PANEL_TITLE;

public class main {

    public static void main(String[] args) throws IOException {
        final JFrame homeFrame = new JFrame(HOME_PANEL_TITLE);
        final JButton btnLogin = new JButton(HOME_BUTTON_LOGIN);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(400, 100);
        homeFrame.setLayout(new FlowLayout());
        btnLogin.addActionListener(e -> {
            LoginView loginDlg = new LoginView(homeFrame);
            loginDlg.setVisible(true);
            if (loginDlg.isSucceeded()) {
                btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
            }
        });
        homeFrame.getContentPane().add(btnLogin);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setVisible(true);
    }
}
