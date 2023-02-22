package utilities;

import machine.IMachineACafe;

import java.util.ArrayList;
import java.util.Collection;

public class MachineACafeSpy implements IMachineACafe {
    private final ArrayList<Integer> sommesDesAppelsAInsérer = new ArrayList<>();

    public Collection<Integer> SommeDesAppelsAInsérer(){
        return sommesDesAppelsAInsérer;
    }

    @Override
    public int GetNbCafe() {
        return 0;
    }

    @Override
    public void Insérer(int sommeEnCentimes) {
        sommesDesAppelsAInsérer.add(sommeEnCentimes);
    }

    @Override
    public int GetSommeEnCentimes() {
        return 0;
    }
}
