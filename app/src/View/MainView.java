package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView extends JDialog {


    private JPanel menuJPanel;
    private JTable table1;
    private JComboBox EggcomboBox;
    private JComboBox FishcomboBox;
    private JTextField choiceTField;
    private JButton countJButton;
    private JButton exitJButton;
    private JLabel infoJLabel;
    private JPanel infoJPanel;
    private JPanel choiceJPanel;
    private JPanel tableJPanel;
    private JPanel buttonJPanel;
    private JComboBox MeatcomboBox;
    private JComboBox StarchcomboBox;
    private JLabel EggLabel;
    private JLabel FishLabel;
    private JLabel MeatLabel;
    private JLabel StarchLabel;
    private JLabel noteLabel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JLabel much;
    private JProgressBar progressBar1;
    private JLabel caloJLabel;

    public MainView(JFrame parent) {
        super(parent);
        setTitle("...Menu...");
        setContentPane(menuJPanel);
        createTable();
        creatEgg();
        creatFish();
        creatMeat();
        creatStarch();
        creatNum1();
        creatNum2();
        creatNum3();
        creatNum4();
        setMinimumSize(new Dimension(800, 500));
        setModal(true);
        setLocationRelativeTo(parent);

        countJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCalo();
            }
        });
        exitJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginView loginView = new LoginView(null);
                loginView.setVisible(true);
            }
        });
        setVisible(false);
    }

    public JPanel getMenuJPanel() {
        return menuJPanel;
    }

    private void createTable() {
        Object[][] data = {
                {"Trứng luộc: 155 calo", "Cá chép: 127 calo", "Thịt bò: 251 calo", "Cơm trắng: 130 calo"},
                {"Trứng vịt sống: 185 calo", "Cá thu: 205 calo", "Thịt lợn: 198 calo", "Cơm gạo lứt: 110 calo"},
                {"Trứng vịt lộn: 226 calo", "Cua alaska: 84 calo", "Thịt gà: 155 calo", "Cơm cháy: 357 calo"},
                {"Trứng gà sống: 317 calo", "Tôm: 100 calo", "", "Cơm tấm: 627 calo"}
        };
        table1.setModel(new DefaultTableModel(
                data,
                new String[]{"Egg", "Fish", "Meat", "Starch"}
        ));
    }

    private void creatEgg() {
        EggcomboBox.setModel(new DefaultComboBoxModel(new String[]{"", "Trứng luộc", "Trứng vịt sống", "Trứng vịt lộn", "Trứng gà sống"}));
    }

    private void creatFish() {
        FishcomboBox.setModel(new DefaultComboBoxModel(new String[]{"", "Cá chép", "Cá thu", "Cua alaska", "Tôm"}));
    }

    private void creatMeat() {
        MeatcomboBox.setModel(new DefaultComboBoxModel(new String[]{"", "Thịt bò", "Thịt lợn", "Thịt gà"}));
    }

    private void creatStarch() {
        StarchcomboBox.setModel(new DefaultComboBoxModel(new String[]{"", "Cơm trắng", "Cơm gạo lứt", "Cơm cháy", "Cơm tấm"}));
    }

    private void creatNum1() {
        comboBox1.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5"}));
    }

    private void creatNum2() {
        comboBox2.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5"}));
    }

    private void creatNum3() {
        comboBox3.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5"}));
    }

    private void creatNum4() {
        comboBox4.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5"}));
    }

    private double countCalo() {
        int sle = comboBox1.getSelectedIndex();
        int slf = comboBox2.getSelectedIndex();
        int slm = comboBox3.getSelectedIndex();
        int sls = comboBox4.getSelectedIndex();

        int eggc = EggcomboBox.getSelectedIndex();
        int meatc = MeatcomboBox.getSelectedIndex();
        int fishc = FishcomboBox.getSelectedIndex();
        int strachc = StarchcomboBox.getSelectedIndex();

        double sum;

        sum = eggcalo(eggc) * sle + meatcalo(meatc) * slm + fcalo(fishc) * slf + scalo(strachc) * sls;
        return sum;
    }

    public double eggcalo(int eggc) {
        double eggcalo = 0;
        switch (eggc) {
            case 0:
                break;
            case 1:
                eggcalo = 155;
                break;
            case 2:
                eggcalo = 185;
                break;
            case 3:
                eggcalo = 226;
                break;
            case 4:
                eggcalo = 317;
                break;
        }
        return eggcalo;

    }

    public double meatcalo(int meatc) {
        double meatcalo = 0;
        switch (meatc) {
            case 0:
                break;
            case 1:
                meatcalo = 251;
                break;
            case 2:
                meatcalo = 198;
                break;
            case 3:
                meatcalo = 155;
                break;
        }
        return meatcalo;
    }

    public double fcalo(int fishc) {
        double fcalo = 0;
        switch (fishc) {
            case 0:
                break;
            case 1:
                fcalo = 127;
                break;
            case 2:
                fcalo = 205;
                break;
            case 3:
                fcalo = 84;
                break;
            case 4:
                fcalo = 100;
                break;

        }
        return fcalo;
    }

    public double scalo(int starchc) {
        double scalo = 0;
        switch (starchc) {
            case 0:
                break;
            case 1:
                scalo = 130;
                break;
            case 2:
                scalo = 110;
                break;
            case 3:
                scalo = 357;
                break;
            case 4:
                scalo = 627;
                break;
        }
        return scalo;
    }

    public void showCalo() {
        if (countCalo() < 1800) {
            JOptionPane.showMessageDialog(this, "Còi quá ăn thêm đi bro", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (1800 <= countCalo() && countCalo() <= 2000) {
            JOptionPane.showMessageDialog(this, "Mức calo tiêu thụ của bạn ở mức trung bình đối với nữ, và hơi thiếu với nam!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (countCalo() < 2500) {
            JOptionPane.showMessageDialog(this, "Mức calo tiêu thụ của bạn ở mức trung bình đối với nam, và hơi nhiều với nữ!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Hơi thừa calo rồi các bạn ơi!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        String calo = String.valueOf(countCalo());
        caloJLabel.setText(calo + " Calo");
    }
}
