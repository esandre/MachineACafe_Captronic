public class MachineACafe {

    private final boolean eau;
    private final boolean gobelets;
    private int servedCafe = 0;
    private int somme = 0;
    private int stockCafe = 0;

    public MachineACafe(int i, boolean eau, boolean gobelets) {
        stockCafe = i;
        this.eau = eau;
        this.gobelets = gobelets;
    }
    public MachineACafe() {
        eau = true;
        gobelets = true;
    }

    public int GetNbCafe() {
       return servedCafe;
    }

    public void Insert(int v) {
        if(v >= 40 && eau && gobelets) {
            servedCafe++;
            somme = v;
        }
    }

    public int GetSomme() {
        return somme;
    }
}
