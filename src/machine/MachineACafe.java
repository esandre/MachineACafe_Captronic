package machine;

import machine.eau.IFournisseurEau;
import machine.eau.PasAssezEauException;

public class MachineACafe implements IMachineACafe {
    public static final int PrixDuCaféEnCentimes = 40;

    private final IFournisseurEau fournisseurEau;
    private final boolean gobelets;
    private int cafésServis = 0;
    private int sommeEncaisséeEnCentimes = 0;
    private final int stockCafe;
    private int stockSucre;
    private int consommationEau;
    private boolean sucréDemandé;
    private byte nbDeDoseEau = 0;

    public MachineACafe(int stockCafe, IFournisseurEau eau, boolean gobelets) {
        this.stockCafe = stockCafe;
        this.fournisseurEau = eau;
        this.gobelets = gobelets;
        this.stockSucre = 1;
    }

    public int GetNbCafe() {
       return cafésServis;
    }

    private boolean PeutServirCafé(int sommeInséréeEnCentimes){
        try {
            nbDeDoseEau++;
            fournisseurEau.Consommer(nbDeDoseEau);
            consommationEau += nbDeDoseEau;
        } catch (PasAssezEauException e){
            return false;
        }

        return sommeInséréeEnCentimes >= PrixDuCaféEnCentimes
                && gobelets
                && stockCafe > 0;
    }

    public void Insérer(int sommeEnCentimes) {
        if(PeutServirCafé(sommeEnCentimes)) {
            cafésServis++;
            sommeEncaisséeEnCentimes = sommeEnCentimes;
            if(sucréDemandé) stockSucre --;
            nbDeDoseEau = 0;
        }
    }

    public int GetSommeEnCentimes() {
        return sommeEncaisséeEnCentimes;
    }

    public void pressCafeLong() {
        nbDeDoseEau ++;
    }

    public int GetStockSucre() {
        return stockSucre;
    }

    public void DemanderSucre() {
        sucréDemandé = true;
    }

    public int GetConsommationEau() {
        return consommationEau;
    }
}
