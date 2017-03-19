package username.validation.view;

import username.validation.control.LoginControl;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import static username.validation.util.Constants.BUTTON_LOGIN_LABEL;
import static username.validation.util.Constants.PANEL_LOGIN_TITLE;
import static username.validation.util.Constants.PANEL_LABEL_USERNAME;

public class LoginView extends JDialog {

    private JTextField tfUsername;
    private JLabel lbUsername;
    private JButton btnLogin;
    private boolean succeeded;

    public LoginView(Frame parent) {
        super(parent, PANEL_LOGIN_TITLE, true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        lbUsername = new JLabel(PANEL_LABEL_USERNAME);
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.setBorder(new LineBorder(Color.GREEN));
        btnLogin = new JButton(BUTTON_LOGIN_LABEL);

        btnLogin.addActionListener(e -> {
            if (LoginControl.validateDuplicatedUser(getUsername())) {
                JOptionPane.showMessageDialog(LoginView.this,
                        "The User Exist, availabes: beto, pedro, luis , jose josefa, alex, danger,max, gloria,carlos",
                        "LoginControl",
                        JOptionPane.ERROR_MESSAGE);
                tfUsername.setText("");
                succeeded = false;
            } else {
                if (LoginControl.validateRestrictedWords(getUsername())) {
                    JOptionPane.showMessageDialog(LoginView.this,
                            "The User are using a restricted word, availabes: beto, pedro, luis , jose josefa, alex, danger,max, gloria,carlos",
                            "LoginControl",
                            JOptionPane.ERROR_MESSAGE);
                    tfUsername.setText("");
                    succeeded = false;
                }
            }
        });


        JPanel bp = new JPanel();
        bp.add(btnLogin);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public boolean isSucceeded() {
        return succeeded;
    }


}
