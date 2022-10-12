package Model;

import java.io.Serializable;
public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;


    private int id;  // id cua san pham
    private String name;
    private int MFG; // nam san xuat
    private String EXP; // han su dung
    private int quantity; // so luong
    private String madeBy; // xuat xu
    private double calo; // calo co trong 1 san pham

    public Foods() {
    }

    public Foods(int id, String name, int MFG, String EXP, int quantity, String madeBy, double calo) {
        this.name = name;
        this.id = id;
        this.MFG = MFG;
        this.EXP = EXP;
        this.quantity = quantity;
        this.madeBy = madeBy;
        this.calo = calo;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMFG() {
        return MFG;
    }

    public void setMFG(int MFG) {
        this.MFG = MFG;
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public double getCalo() {
        return calo;
    }

    public void setCalo(double calo) {
        this.calo = calo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
