package View;

import Data.IOWriteAndRead;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class ysno extends JDialog {
    private JPanel ysno;
    private JButton noButton;
    private JButton yesButton;
    private JLabel infoLabel;

    File file = new File("Users.txt");

    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();

    ArrayList<User> list = ioWriteAndRead.read(file);
    public ysno(JDialog parent, User u) {
        super(parent);
        setTitle("...Your choice...");
        setContentPane(ysno);
        setMinimumSize(new Dimension(300, 100));
        setModal(true);
        setLocationRelativeTo(parent);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminView adminView = new AdminView(null);
                adminView.setDeleteButton(file,list, u);
                dispose();
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
        setVisible(false);
    }
}
