package Model;

import java.io.Serializable;

public class Meat extends Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;// ten thit
    private final int beef = 251;// thit bo
    private final int pork = 198;
    private final int chicken = 155;

    public Meat(int id, String name, int mfg, String exp, int quantity, String made, int calo) {
        super(id, name, mfg, exp, quantity, made, calo);
    }

    public Meat(int id, String name, int mfg, String exp, int quantity, String made, int calo, String name1) {
        super(id, name, mfg, exp, quantity, made, calo);
        this.name = name1;
    }

    public Meat(int id, String name, int MFG, String EXP, int quantity, String madeBy, double calo, String name1) {
        super(id, name, MFG, EXP, quantity, madeBy, calo);
        this.name = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeef() {
        return beef;
    }

    public int getPork() {
        return pork;
    }

    public int getChicken() {
        return chicken;
    }
}
