import machine.MachineACafe;
import org.junit.Test;
import utilities.FournisseurEauMock;

import static org.junit.Assert.assertEquals;

public class Defect_20230223 {
    @Test
    public void Apres_NCafes_Rend_Argent(){
        var stockInitialCafé = 10;

        var machine = new MachineACafe(10, new FournisseurEauMock(true), true);
        var cafésServisInitiaux = machine.GetNbCafe();

        for (var i = 0; i < stockInitialCafé; i++){
            machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);
        }

        var cafésServisFinaux = machine.GetNbCafe();
        assertEquals(cafésServisInitiaux + stockInitialCafé, cafésServisFinaux);
    }
}
