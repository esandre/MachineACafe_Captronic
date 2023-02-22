package utilities;

import machine.MachineACafe;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class MachineACafeMatchers extends AbstractAssert<MachineACafeMatchers, MachineACafe>
{
    public static MachineACafeMatchers assertThat(MachineACafe actual) {
        return new MachineACafeMatchers(actual);
    }

    public MachineACafeMatchers(MachineACafe machineACafe) {
        super(machineACafe, MachineACafeMatchers.class);
    }

    public MachineACafeMatchers rendLArgent(){
        if(actual.GetSomme() != 0){
            failWithMessage("Il était attendu que la machine n'ait pas d'argent encaissé. Elle possède %s",
                    actual.GetSomme());
        }
        return this;
    }

    public MachineACafeMatchers encaisse(int somme){
        if(actual.GetSomme() != somme){
            failWithMessage("Il était attendu que la machine encaise %s. Elle a encaissé %s",
                    somme, actual.GetSomme());
        }
        return this;
    }

    public MachineACafeMatchers neSertPasDeCafé(int nombrePrécédent){
        if(actual.GetNbCafe() != nombrePrécédent){
            failWithMessage("Il était attendu que la machine ne serve pas de café. Elle en a servi %s",
                    actual.GetNbCafe() - nombrePrécédent);
        }
        return this;
    }

    public MachineACafeMatchers sertUnCafé(int nombrePrécédent){
        if(actual.GetNbCafe() != nombrePrécédent + 1){
            failWithMessage("Il était attendu que la machine serve un café. Elle en a servi %s",
                    actual.GetNbCafe() - nombrePrécédent);
        }
        return this;
    }
}
