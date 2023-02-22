package utilities;

import machine.MachineACafe;

public class MachineACafeBuilder {

    private boolean ayantDesGobelets = true;
    private boolean ayantDeLEau = true;
    private boolean ayantDuCafé = true;

    public static MachineACafe Default() {
        return new MachineACafeBuilder().Build();
    }

    public MachineACafe Build(){
        return new MachineACafe(ayantDuCafé ? 1 : 0, ayantDeLEau, ayantDesGobelets);
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
