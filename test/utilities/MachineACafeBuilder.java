package utilities;

import machine.MachineACafe;

public class MachineACafeBuilder {

    private boolean _ayantDesGobelets = true;
    private boolean _ayantDeLEau = true;
    private boolean _ayantDuCafé = true;

    public static MachineACafe Default() {
        return new MachineACafeBuilder().Build();
    }

    public MachineACafe Build(){
        return new MachineACafe(_ayantDuCafé ? 1 : 0, _ayantDeLEau, _ayantDesGobelets);
    }

    public MachineACafeBuilder SansGobelets(){
        _ayantDesGobelets = false;
        return this;
    }

    public MachineACafeBuilder SansEau() {
        _ayantDeLEau = false;
        return this;
    }

    public MachineACafeBuilder SansCafé() {
        _ayantDuCafé = false;
        return this;
    }
}
