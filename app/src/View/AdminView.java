package View;

import Data.IOWriteAndRead;
import Model.Admin;
import Model.User;
import Validate.ValidateUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class AdminView extends JDialog implements Serializable {
    private static final long serialVersionUID = 1L;
    private JButton addButton;
    private JButton chanceButton;
    private JButton deleteButton;
    private JButton showButton;
    private JButton findButton;
    private JTextField findJF;
    private JTable jTable;
    private JLabel adminMenuLabel;
    private JLabel fullnameLabel;
    private JLabel userLabel;
    private JLabel passLabel;
    private JLabel genderLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel idLabel;
    private JLabel permissionLabel;
    private JButton exitLabel;
    private JPanel adminViewJLabel;
    private JTextField JFid;
    private JTextField JFname;
    private JTextField JFuser;
    private JTextField JFpass;
    private JTextField JFmail;
    private JTextField JFphone;
    private JTextField JFaddress;
    private JRadioButton JFmale;
    private JRadioButton JFfemale;
    private JLabel finduserLabel;

    private Object data = new Object[][]{};
    private String[] columnNames = new String[]{
            "ID", "Họ và tên", "Tên đăng Nhập", "Mật khẩu", "Giới tính", "Email", "Điện thoại", "Địa chỉ"
    };
    private User uDelete = new User();

    File file = new File("Users.txt");

    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();

    ArrayList<User> list = ioWriteAndRead.read(file);


    public AdminView(JDialog parent) {
        super(parent);
        setTitle("...Admin view...");
        setContentPane(adminViewJLabel);
        setMinimumSize(new Dimension(600, 700));
        setModal(true);
        setLocationRelativeTo(parent);
//        jTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        chanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User index = find();
                change(index);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uDelete = find();
                if (uDelete != null) {
                    ysno ysno = new ysno(null, uDelete);
                    ysno.setVisible(true);
                }

            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User index = find();
                show2(index);
            }
        });


        exitLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginView loginView = new LoginView(null);
                loginView.setVisible(true);
            }
        });

        findJF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    User user = find();
                    show2(user);
                }
            }
        });


        JFmale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderLabel.setText(JFmale.getText());
            }
        });

        JFfemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderLabel.setText(JFfemale.getText());
            }
        });
        setVisible(false);
    }

    public void showData() {
        list = ioWriteAndRead.read(file);
        int size = list.size();
        Object[][] users = new Object[size][8];
        for (int i = 0; i < size; i++) {
            users[i][0] = list.get(i).getId();
            users[i][1] = list.get(i).getFullname();
            users[i][2] = list.get(i).getUser();
            users[i][3] = list.get(i).getPassWord();
            users[i][4] = list.get(i).getGender();
            users[i][5] = list.get(i).getEmail();
            users[i][6] = list.get(i).getPhone();
            users[i][7] = list.get(i).getAddress();
        }
        jTable.setModel(new DefaultTableModel(users, columnNames));
    }

    public void change(User user) {
        if (user == null) {
            return;
        }
        String name = String.valueOf(ValidateUser.name(JFname.getText()));
        String gender = genderLabel.getText();
        String mail = String.valueOf(ValidateUser.email(JFmail.getText()));
        String phone = String.valueOf(ValidateUser.telephone(JFphone.getText()));
        String address = JFaddress.getText();

        if (name.isEmpty() || mail.isEmpty() || address.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin không để trống", "Try again", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).getId()==user.getId()) {
                list.get(i).setFullname(name);
                list.get(i).setEmail(mail);
                list.get(i).setAddress(address);
                list.get(i).setPhone(phone);
                list.get(i).setGender(gender);
                ioWriteAndRead.write(file, list);
                JOptionPane.showMessageDialog(this, "Thay đổi thành công!", "Done!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    public User find() {
        String user = findJF.getText();
        int i = 0;
        while (i < list.size()) {

            if (Objects.equals(user, list.get(i).getUser()) && user != null) {
                uDelete = list.get(i);
                return list.get(i);
            }
            i++;
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy username", "Thông báo", JOptionPane.ERROR_MESSAGE);

        return null;
    }

        public boolean checked () {
            int i = 0;
            while (i < list.size()) {
                if (JFuser.getText().equals(list.get(i).getUser())) {
                    return false;
                }
                i++;
            }
            return true;
        }

        public void setDeleteButton (File file, ArrayList<User> list, User u) {
            int i = 0;
            String userchoice = u.getUser();
//                    JFuser.getText();
            while (i < list.size()) {
                if (list.get(i).getUser().equals(userchoice)) {
                    list.remove(i);
                    ioWriteAndRead.write(file, list);
                    JOptionPane.showMessageDialog(this, "Đã xoá thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                i++;
            }
        }
        public void show2 (User u){
        if (u==null){
            return;
        }
            JFid.setText(String.valueOf(u.getId()));
            JFname.setText(String.valueOf(u.getFullname()));
            JFuser.setText(String.valueOf(u.getUser()));
            JFpass.setText(String.valueOf(u.getPassWord()));
            genderLabel.setText(String.valueOf(u.getGender()));
            JFmail.setText(String.valueOf(u.getEmail()));
            JFphone.setText(String.valueOf(u.getPhone()));
            JFaddress.setText(String.valueOf(u.getAddress()));
            if (u instanceof Admin) {
                permissionLabel.setText(String.valueOf(((Admin) u).getKey()));
            } else {
                permissionLabel.setText("User");
            }
        }

    }

