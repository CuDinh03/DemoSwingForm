package View;

import Data.IOWriteAndRead;
import Model.User;
import Validate.ValidateUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class SignUp extends JDialog implements Serializable {
    public User user;

    @Serial
    private static final long serialVersionUID = 1L;
    public JTextField FullNameJTextField;
    public JTextField UserNameTextField;
    private JLabel fullNameJLabel;
    private JLabel UserNameJLabel;
    private JLabel PasswordJLabel;
    private JLabel ConfirmPassJLabel;
    private JLabel ContactJLabel;
    private JLabel EmailJLabel;
    public JPasswordField passwordJField;
    public JPasswordField ConfirmpasswordJField;
    public JTextField ContactJtextField;
    public JTextField EmailJtextField;
    private JButton logInButton;
    private JLabel genderJLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JPanel ViewJPanel;
    private JButton cancelButton;
    public JTextArea addressJTextArea;
    private JLabel addressJLabel;
    File file = new File("Users.txt");
    IOWriteAndRead<User> ioWriteAndRead = new IOWriteAndRead<>();
    ArrayList<User> users = ioWriteAndRead.read(file);


    public SignUp(JFrame parent){

        super(parent);
        setTitle(".....Login Form.....");
        setContentPane(ViewJPanel);
        setMinimumSize(new Dimension(700,600));
        setModal(true);
        setLocationRelativeTo(parent);
        cancelButton.addActionListener(e -> {
            dispose();
            LoginView loginView = new LoginView(null);
            loginView.setVisible(true);
        });
        logInButton.addActionListener(e -> {
            if (check()){
                loginUser();
            }else {
                JOptionPane.showMessageDialog(this,"Tên đăng nhập đã có người sử dụng","Thông báo",JOptionPane.ERROR_MESSAGE);
            }
        });
        ActionListener listener = e -> {
            if (maleButton.isSelected()) {
                genderJLabel.setText(maleButton.getText());
            } else {
                genderJLabel.setText(femaleButton.getText());
            }
        };

        maleButton.addActionListener(listener);
        femaleButton.addActionListener(listener);

        setVisible(false);
    }


    public void loginUser(){

            String name = String.valueOf(ValidateUser.name(FullNameJTextField.getText()));
            String account = String.valueOf(UserNameTextField.getText());
            String pass = String.valueOf(ValidateUser.password(String.valueOf(passwordJField.getPassword())));
            String phone = String.valueOf(ValidateUser.telephone(ContactJtextField.getText()));
            String email = String.valueOf(ValidateUser.email(EmailJtextField.getText()));
            String confirm = String.valueOf(ConfirmpasswordJField.getPassword());
            String address = String.valueOf(addressJTextArea.getText());

            int id =0;
            int i=0;
            try {
                while (i<users.size()){
                    if (id==users.get(i).getId()){
                        id=users.get(i).getId()+1;

                    }
                    i++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            String gender = genderJLabel.getText();


        if (name.isEmpty()|| email.isEmpty()||account.isEmpty()||pass.isEmpty()||confirm.isEmpty()||address.isEmpty()||phone.isEmpty()||gender.isEmpty()){
            JOptionPane.showMessageDialog(this,"Hãy điền đầy đủ thông tin không để trống","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!pass.equals(confirm)){
            JOptionPane.showMessageDialog(this,"Mật khẩu không trùng nhau", " Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Đã đăng ký thành công","Cảm ơn",JOptionPane.ERROR_MESSAGE);
        User user = new User(id,name, account,pass, gender, email,phone,address);
        users.add(user);
        ioWriteAndRead.write(file,users);
        dispose();
        SignUp signUp = new SignUp(null);
        signUp.setVisible(true);
    }
    public boolean check(){
        int i=0;
        while (i<users.size()){
        if (UserNameTextField.getText().equals(users.get(i).getUser())) {
            return false;
        }
        i++;
        }
        return true;
    }
}
