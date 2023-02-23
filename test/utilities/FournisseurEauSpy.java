package utilities;

import machine.eau.IFournisseurEau;
import machine.eau.PasAssezEauException;

public class FournisseurEauSpy implements IFournisseurEau {

    public int eauconsomme=0;
    private final int stockEau;

    public FournisseurEauSpy(int stockEauInitial){
        this.stockEau = stockEauInitial;
    }

    public void Consommer(int doses) throws PasAssezEauException {
        if(doses > stockEau ) throw new PasAssezEauException();
        else{
            eauconsomme+= doses;
        }
    }
}
