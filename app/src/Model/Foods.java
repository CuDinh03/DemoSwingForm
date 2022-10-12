package Model;

import java.io.Serializable;

abstract public class Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;  // id cua san pham
    private String MFG; // nam san xuat
    private String EXP; // han su dung
    private int quantity; // so luong
    private String madeBy; // xuat xu
    private double calo; // calo co trong 1 san pham

    public Foods() {
    }

    public Foods(String id, String MFG, String EXP, int quantity, String madeBy, double calo) {
        this.id = id;
        this.MFG = MFG;
        this.EXP = EXP;
        this.quantity = quantity;
        this.madeBy = madeBy;
        this.calo = calo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMFG() {
        return MFG;
    }

    public void setMFG(String MFG) {
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
}
