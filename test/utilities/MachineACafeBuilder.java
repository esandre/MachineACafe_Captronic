package utilities;

import machine.MachineACafe;
import machine.eau.IFournisseurEau;
import java.util.Optional;

public class MachineACafeBuilder {
    private boolean ayantDesGobelets = true;
    private boolean ayantDuCafé = true;

    private boolean ayantDuSucre = true;
    private Optional<IFournisseurEau> fournisseurEau = Optional.empty();

    public static MachineACafe Default() {
        return new MachineACafeBuilder().Build();
    }

    public MachineACafe Build(){
        var fournisseurChoisi = fournisseurEau.orElse(new FournisseurEauMock(true));
        return new MachineACafe(ayantDuCafé ? 1 : 0, fournisseurChoisi, ayantDesGobelets);
    }

    public MachineACafeBuilder AyantPourFournisseurEau(IFournisseurEau fournisseurEau){
        this.fournisseurEau = Optional.of(fournisseurEau);
        return this;
    }

    public MachineACafeBuilder SansGobelets(){
        ayantDesGobelets = false;
        return this;
    }

    public MachineACafeBuilder SansEau() {
        fournisseurEau = Optional.of(new FournisseurEauMock(false));
        return this;
    }

    public MachineACafeBuilder SansCafé() {
        ayantDuCafé = false;
        return this;
    }

    public MachineACafeBuilder SansSucre() {
        ayantDuSucre = false;
        return this;
    }
}
