package Model;


import java.io.Serializable;

public class Egg extends Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private final int egg = 155;
    private final int eggVS = 185; // trung vit song
    private final int eggVl = 226;// trung vit lon
    private final int eggRedC = 317; // trung ga song long do


    public Egg(int id, String name, int mfg, String exp, int quantity, String made, int calo, String name1) {
        super(id, name, mfg, exp, quantity, made, calo);
        this.name = name1;
    }

    public Egg(int id, String name, int MFG, String EXP, int quantity, String madeBy, double calo, String name1) {
        super(id, name, MFG, EXP, quantity, madeBy, calo);
        this.name = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEgg() {
        return egg;
    }

    public int getEggVS() {
        return eggVS;
    }

    public int getEggVl() {
        return eggVl;
    }

    public int getEggRedC() {
        return eggRedC;
    }
}
