package View;

import Data.IOWriteAndRead;
import Model.Foods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Out extends JDialog implements Serializable {
    private static final long serialVersionUID = 1L;
    private JPanel quantityPanel;
    private JTextField nameJTF;
    private JButton findBtn;
    private JCheckBox upbtn;
    private JCheckBox downbtn;
    private JButton okbtn;
    private JTextField quantityJTF;
    private JButton exitbtn;
    private JLabel outMenuLabel;
    private JLabel findJLB;
    private JLabel idJLb;
    private JLabel nameJLb;
    private JLabel quantityJLb;
    private JLabel quantity;
    private JLabel name;
    private JLabel id;
    private JLabel quantityWant;

    File file = new File("Products.txt");
    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();
    ArrayList<Foods> list = ioWriteAndRead.read(file);

    Foods fs = new Foods();

    public Out(JDialog parent) {
        super(parent);
        setTitle("Kho");
        setContentPane(quantityPanel);
        setMinimumSize(new Dimension(600, 300));
        setModal(true);
        setLocationRelativeTo(parent);

        ActionListener listener = e -> {

        };


        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantiTy(index1());
            }
        });
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Foods f = findf();
                show2(f);
            }
        });
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(false);
        nameJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
        quantityJTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }

    public Foods findf() {
        String name = String.valueOf(nameJTF.getText());
        int i = 0;
        while (i < list.size()) {
            if (Objects.equals(name, list.get(i).getName()) && name != null) {
                fs = list.get(i);
                return list.get(i);
            }
            i++;
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
        return null;
    }

//    public boolean check1() {
//        int i = 0;
//        while (i < list.size()) {
//            if (nameJTF.getText().equals(list.get(i).getName())) {
//                return false;
//            }
//            i++;
//        }
//        return true;
//    }

    public void show2(Foods f) {
        if (f == null) {
            return;
        }
        id.setText(String.valueOf(f.getId()));
        name.setText(String.valueOf(f.getName()));
        quantity.setText(String.valueOf(f.getQuantity()));
    }

    public void quantiTy(int i) {
        int number = Integer.parseInt(String.valueOf(quantity.getText()));
        int number2 = Integer.parseInt(String.valueOf(quantityJTF.getText()));
        int sum = 0;

        if (downbtn.isBorderPaintedFlat()) {
            sum = number - number2;
            list.get(i).setQuantity(sum);
            ioWriteAndRead.write(file, list);
            JOptionPane.showMessageDialog(this,"Nhập kho thành công","Thông báo",JOptionPane.ERROR_MESSAGE);

            quantity.setText(String.valueOf(list.get(i).getQuantity()));

        } else if (upbtn.isBorderPaintedFlat()) {
            sum = number + number2;
            list.get(i).setQuantity(sum);
            ioWriteAndRead.write(file, list);
            JOptionPane.showMessageDialog(this,"Xuất kho thành công","Thông báo",JOptionPane.ERROR_MESSAGE);
            quantity.setText(String.valueOf(list.get(i).getQuantity()));

        }else{
            JOptionPane.showMessageDialog(this,"Hãy tích vào nhập hoặc xuất","Thông báo",JOptionPane.ERROR_MESSAGE);
        }

    }


    public int index1(){
        int id1 = Integer.parseInt(id.getText());
        int i = 0;
        while (i < list.size()) {
            if (id1 == list.get(i).getId()) {
return i;
            }
        }
        return 0;
    }

}
