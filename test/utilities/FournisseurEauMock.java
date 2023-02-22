package utilities;

import machine.eau.IFournisseurEau;
import machine.eau.PasAssezEauException;

public class FournisseurEauMock implements IFournisseurEau {
    private final boolean possèdeDeLEau;

    public FournisseurEauMock(boolean possèdeDeLEau){
        this.possèdeDeLEau = possèdeDeLEau;
    }

    public void Consommer(int doses) throws PasAssezEauException {
        if(!possèdeDeLEau) throw new PasAssezEauException();
    }
}
