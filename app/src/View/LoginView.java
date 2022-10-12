package View;

import Data.IOWriteAndRead;
import Model.Admin;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class LoginView extends JDialog implements Serializable {
    private static final long serialVersionUID = 1L;
    private JTextField UserJTextField;
    private JPasswordField PassJPassField;
    private JButton signUpButton;
    private JButton logInButton;
    private JLabel UserJLabel;
    private JLabel PassJLabel;
    private JPanel LoginJPanel;
    private JButton exitButton;
    File file = new File("Users.txt");
    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();

    ArrayList<User> users = ioWriteAndRead.read(file);

    public LoginView(JFrame parent) {
        super(parent);
        setTitle("...Login account...");
        setContentPane(LoginJPanel);
        setMinimumSize(new Dimension(450, 150));
        setModal(true);
        setLocationRelativeTo(parent);
//        users.add(new Admin(1,"Dinh Huy Cu","cudinh03","cudinh03","Nam","dinhhuycu0305@gmai.com","0782399550","Phuc Yen-Vinh Phuc","Admin"));
//        ioWriteAndRead.write(file,users);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView();
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp signUp = new SignUp(null);
                signUp.setVisible(true);
            }
        });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        PassJPassField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    LoginView();
                }
            }
        });

        UserJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    LoginView();
                }
            }
        });
        setVisible(true);
    }

    public void LoginView() {

        String name = UserJTextField.getText();
        String pass = String.valueOf(PassJPassField.getPassword());
        int i = 0;
        boolean check = false;
        boolean check2 = false;
        if (name.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để mật khẩu hoặc tài khoản trống.", "Try again", JOptionPane.ERROR_MESSAGE);
        } else {
            while (i < users.size()) {
                if (name.equals(users.get(i).getUser()) && pass.equals(users.get(i).getPassWord())) {
                    if (users.get(i) instanceof Admin) {
                        check = true;
                        check2 = true;
                        break;
                    } else {
                        check = true;
                        break;
                    }
                }
                i++;
            }
            if (check) {
                if (!check2) {
                    dispose();
                    MainView mainView = new MainView(null);
                    mainView.setVisible(true);
                } else {
                    dispose();
                    AdminView adminView = new AdminView(null);
                    adminView.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng vui lòng thử lại.", "Try again", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
