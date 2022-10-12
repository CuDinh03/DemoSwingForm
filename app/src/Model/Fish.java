package Model;

import java.io.Serializable;

public class Fish extends Foods implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private final int fishC = 127; // ca chep
    private final int fishT = 205; // ca thu
    private final int crabAl = 84; // cua alaska
    private final int shrimp = 100; // tom

    public Fish(int id, String name, int mfg, String exp, int quantity, String made, int calo, String name1) {
        super(id, name, mfg, exp, quantity, made, calo);
        this.name = name1;
    }

    public Fish(int id, String name, int MFG, String EXP, int quantity, String madeBy, double calo, String name1) {
        super(id, name, MFG, EXP, quantity, madeBy, calo);
        this.name = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFishC() {
        return fishC;
    }

    public int getFishT() {
        return fishT;
    }

    public int getCrabAl() {
        return crabAl;
    }

    public int getShrimp() {
        return shrimp;
    }
}
