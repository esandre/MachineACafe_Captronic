package utilities;

import machine.IRessourcesMachineACafe;
import machine.MachineACafe;
import org.mockito.Mockito;

public class MachineACafeBuilder {

    private boolean ayantDesGobelets = true;
    private boolean ayantDeLEau = true;
    private boolean ayantDuCafé = true;

    public static MachineACafe Default() {
        return new MachineACafeBuilder().Build();
    }

    public MachineACafe Build()
    {
        IRessourcesMachineACafe ressources = Mockito.mock();
        Mockito.when(ressources.CaféDisponible()).thenReturn(ayantDuCafé ? 1 : 0);
        Mockito.when(ressources.EauDisponible()).thenReturn(ayantDeLEau);
        Mockito.when(ressources.GobeletsDisponibles()).thenReturn(ayantDesGobelets);

        return new MachineACafe(ressources);
    }

    public MachineACafeBuilder SansGobelets(){
        ayantDesGobelets = false;
        return this;
    }

    public MachineACafeBuilder SansEau() {
        ayantDeLEau = false;
        return this;
    }

    public MachineACafeBuilder SansCafé() {
        ayantDuCafé = false;
        return this;
    }
}
