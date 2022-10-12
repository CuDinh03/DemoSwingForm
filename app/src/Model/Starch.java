package Model;

import java.io.Serializable;

public class Starch extends Foods implements Serializable {
    private static final long serialVersionUID = 1L;
    // do an co tinh bot
    private String name;
    private final int rice = 130; // com trắng;
    private final int riceL = 110; // gao lứt
    private final int riceC = 357; // com cháy
    private final int riceT = 627; // com tấm

    public Starch() {
    }

    public Starch(String name) {
        this.name = name;
    }

    public Starch(String id, String MFG, String EXP, int quantity, String madeBy, double calo, String name) {
        super(id, MFG, EXP, quantity, madeBy, calo);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRice() {
        return rice;
    }

    public int getRiceL() {
        return riceL;
    }

    public int getRiceC() {
        return riceC;
    }

    public int getRiceT() {
        return riceT;
    }
}
