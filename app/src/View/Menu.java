package View;

import Data.IOWriteAndRead;
import Model.Foods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Menu extends JDialog implements Serializable {
    private static final long serialVersionUID = 1L;
    private JPanel menuJPanel;
    private JButton addBtn;
    private JButton changeBtn;
    private JButton deleteBtn;
    private JButton showBtn;
    private JTable menuTable;
    private JButton exitBtn;
    private JTextField findProductJF;
    private JButton findJbt;
    private JLabel idLb;
    private JLabel mfgLb;
    private JLabel expLB;
    private JLabel quantityLB;
    private JLabel madeLB;
    private JLabel caloLB;
    private JButton outBtn;
    private JTextField mfgJTF;
    private JTextField expJTF;
    private JTextField quantityJFT;
    private JTextField madeJFT;
    private JLabel idProducts;
    private JLabel findFroductsJL;
    private JLabel menuJLB;
    private JTextField caloJFT;
    private JTextField nameProductJTF;

    File file = new File("Products.txt");
    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();
    ArrayList<Foods> foods = ioWriteAndRead.read(file);

    private String[] columnName = new String[]{
            "ID","Tên sản phẩm","Năm sản xuất","Hạn sử dụng","Số lượng","Xuất xứ","Calo"
    };
    private Foods obfoods = new Foods();
    private Object data = new Object[][]{};

    public Menu(JDialog parent){
        super(parent);
        setTitle(".....Menu Main.....");
        setContentPane(menuJPanel);
        setMinimumSize(new Dimension(900,600));
        setModal(true);
        setLocationRelativeTo(parent);


        menuTable.setModel(new DefaultTableModel((Object[][]) data,columnName));
        findJbt.addActionListener(e -> {
                Foods f = find();
                show2(f);
        });
        findJbt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        Foods f = find();
                        show2(f);
                    }
            }
        });
        addBtn.addActionListener(e -> {
                if (checked()){
                    menuMain();
                }else {
                    JOptionPane.showMessageDialog(this,"Tên sản phẩm này đã có","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
        });
        changeBtn.addActionListener(e -> {
                Foods f = find();
                setChangeBtn(f);
        });
        showBtn.addActionListener(e -> showDataProducts());
        deleteBtn.addActionListener(e ->  {
                obfoods = find();
                if (obfoods!=null){
                    setDeleteBtn(file,foods,obfoods);
                }else {
                    JOptionPane.showMessageDialog(this,"Đừng để trống tên!","Thống báo",JOptionPane.ERROR_MESSAGE);
                }

        });
        outBtn.addActionListener(e -> {
                Out out = new Out(null);
                out.setVisible(true);
        });
        exitBtn.addActionListener(e -> {
            dispose();
            AdminView adminView = new AdminView(null);
            adminView.setVisible(true);
        });

        setVisible(false);
    }

    public void menuMain(){

        String name = String.valueOf(nameProductJTF.getText());
        String exp = String.valueOf(expJTF.getText());
        String made = String.valueOf(madeJFT.getText());
        //id
        int id = 0;
        int i=0;
        try {
            while (i<foods.size()){
                if (id == foods.get(i).getId()){
                    id+=1;
                }
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // mfg
        int mfg = 0;
        try {
            mfg = Integer.parseInt(String.valueOf(mfgJTF.getText()));
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lỗi định dạng năm","Thử lại",JOptionPane.ERROR_MESSAGE);
        }
//quantity
        int quantity = 0;
        try{
            quantity = Integer.parseInt(String.valueOf(quantityJFT.getText()));

        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lỗi định dạng số lượng","Thử lại",JOptionPane.ERROR_MESSAGE);
        }
        //calo
        double calo=0;
        try{
            calo = Double.parseDouble(String.valueOf(caloJFT.getText()));
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lỗi định dạng số lượng calo","Thử lại",JOptionPane.ERROR_MESSAGE);
        }

        if (mfg==0||exp.isEmpty()||quantity==0||made.isEmpty()||calo==0||name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Không được để trống thông tin","Thử lại",JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Đã thêm thành công","Xong!",JOptionPane.ERROR_MESSAGE);
        Foods foods1 = new Foods(id,name,mfg,exp,quantity,made,calo);
        foods.add(foods1);
        ioWriteAndRead.write(file,foods);

    }

    public boolean checked(){
        int i=0;
        while (i<foods.size()){
            if (nameProductJTF.getText().equals(foods.get(i).getName())) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void showDataProducts(){
        foods = ioWriteAndRead.read(file);
        int size = foods.size();
        Object[][] listfood = new Object[size][7];
        for (int i=0; i<size;i++){
            listfood[i][0] = foods.get(i).getId();
            listfood[i][1] = foods.get(i).getName();
            listfood[i][2] = foods.get(i).getMFG();
            listfood[i][3] = foods.get(i).getEXP();
            listfood[i][4] = foods.get(i).getQuantity();
            listfood[i][5] = foods.get(i).getMadeBy();
            listfood[i][6] = foods.get(i).getCalo();
        }
        menuTable.setModel(new DefaultTableModel(listfood,columnName));
    }

   public void setChangeBtn(Foods food1){
        if (food1==null){
            return;
        }

        String name = String.valueOf(nameProductJTF.getText());
        int mfg = 0;
        try {
            mfg = Integer.parseInt(String.valueOf(mfgJTF.getText()));
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lỗi định dạng năm","Thử lại",JOptionPane.ERROR_MESSAGE);
        }

        String exp = String.valueOf(expJTF.getText());
        String made = String.valueOf(madeJFT.getText());
        double calo=0;
        try{
            calo = Double.parseDouble(String.valueOf(caloJFT.getText()));
        }catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Lỗi định dạng số lượng calo","Thử lại",JOptionPane.ERROR_MESSAGE);
        }
        if (name.isEmpty()||mfg==0||exp.isEmpty()||calo==0||made.isEmpty()){
            JOptionPane.showMessageDialog(this,"Không được để trống thông tin","Thử lại",JOptionPane.ERROR_MESSAGE);

        }
        for (int i = 0; i < foods.size() ; i++) {
            if (foods.get(i).getId()==food1.getId()){
                foods.get(i).setName(name);
                foods.get(i).setMFG(Integer.parseInt(String.valueOf(mfg)));
                foods.get(i).setEXP(exp);
                foods.get(i).setName(made);
                foods.get(i).setCalo(Double.parseDouble(String.valueOf(calo)));
                ioWriteAndRead.write(file,foods);
                JOptionPane.showMessageDialog(this,"Thay đổi thành công","Done",JOptionPane.ERROR_MESSAGE);

                return;
            }
        }
    }

    public Foods find(){
        String name = findProductJF.getText();
        int i =0;
        while (i< foods.size()){
            if (Objects.equals(name, foods.get(i).getName() )&& name != null ){
                obfoods = foods.get(i);
                return foods.get(i);
            }
            i++;
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public void setDeleteBtn(File file, ArrayList<Foods> list, Foods f){
        int i=0;
        String namechoice = f.getName();
        while (i<list.size()){
            if (list.get(i).getName().equals(namechoice)){
                list.remove(i);
                ioWriteAndRead.write(file,list);
                JOptionPane.showMessageDialog(this,"Đã xoá thành công","Thông báo",JOptionPane.ERROR_MESSAGE);
                return;
            }
            i++;
        }
    }

    public void show2(Foods f){
        if (f == null){
            return;
        }
        idProducts.setText(String.valueOf(f.getId()));
        nameProductJTF.setText(String.valueOf(f.getName()));
        mfgJTF.setText(String.valueOf(f.getMFG()));
        expJTF.setText(String.valueOf(f.getEXP()));
        quantityJFT.setText(String.valueOf(f.getQuantity()));
        madeJFT.setText(String.valueOf(f.getMadeBy()));
        caloJFT.setText(String.valueOf(f.getCalo()));
    }




}
