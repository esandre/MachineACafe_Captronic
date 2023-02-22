package machine;

public class MachineACafe {

    private final boolean eau;
    private final boolean gobelets;
    private int cafésServis = 0;
    private int sommeEncaisséeEnCentimes = 0;
    private int stockCafe;

    public MachineACafe(int stockCafe, boolean eau, boolean gobelets) {
        this.stockCafe = stockCafe;
        this.eau = eau;
        this.gobelets = gobelets;
    }

    public int GetNbCafe() {
       return cafésServis;
    }

    private boolean PeutServirCafé(int sommeInséréeEnCentimes){
        return sommeInséréeEnCentimes >= 40 && eau && gobelets && stockCafe > 0;
    }

    public void Insérer(int sommeEnCentimes) {
        if(PeutServirCafé(sommeEnCentimes)) {
            cafésServis++;
            sommeEncaisséeEnCentimes = sommeEnCentimes;
        }
    }

    public int GetSommeEnCentimes() {
        return sommeEncaisséeEnCentimes;
    }
}
