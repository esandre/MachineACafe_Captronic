package machine;

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

    public int GetNbCafe() {
       return servedCafe;
    }

    public void Insert(int sommeEnCentimes) {
        if(sommeEnCentimes >= 40 && eau && gobelets && stockCafe > 0) {
            servedCafe++;
            somme = sommeEnCentimes;
        }
    }

    public int GetSomme() {
        return somme;
    }
}
