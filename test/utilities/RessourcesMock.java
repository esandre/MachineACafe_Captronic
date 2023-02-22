package utilities;

import machine.IRessourcesMachineACafe;

public class RessourcesMock implements IRessourcesMachineACafe {
    private boolean ayantDesGobelets = true;
    private boolean ayantDeLEau = true;
    private boolean ayantDuCafé = true;

    public RessourcesMock(boolean ayantDesGobelets, boolean ayantDeLEau, boolean ayantDuCafé){
        this.ayantDesGobelets = ayantDesGobelets;
        this.ayantDeLEau = ayantDeLEau;
        this.ayantDuCafé = ayantDuCafé;
    }

    @Override
    public boolean EauDisponible() {
        return ayantDeLEau;
    }

    @Override
    public int CaféDisponible() {
        return ayantDuCafé ? 1 : 0;
    }

    @Override
    public boolean GobeletsDisponibles() {
        return ayantDesGobelets;
    }
}
