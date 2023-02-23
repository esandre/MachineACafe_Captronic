import machine.MachineACafe;
import org.junit.Ignore;
import org.junit.Test;
import utilities.MachineACafeBuilder;

import static utilities.MachineACafeMatchers.assertThat;

public class Recette_20230223 {
    @Test
    //@Ignore("Test de recette")
    public void Scenario1(){
        var machine = new MachineACafeBuilder().Build();

        // Café allongé
        {
            var nombreCafésInitiaux = machine.GetNbCafe();
            var consommationEauInitiale = machine.GetConsommationEau();
            machine.pressCafeLong();
            machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);

            assertThat(machine).sertUnCaféLong(nombreCafésInitiaux, consommationEauInitiale);
        }

        // Café court sucré
        {
            var nombreCafésInitiaux = machine.GetNbCafe();
            var stockSucreInitial = machine.GetStockSucre();
            var consommationEauInitiale = machine.GetConsommationEau();

            machine.DemanderSucre();
            machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);

            assertThat(machine).sertUnCaféCourtSucré(nombreCafésInitiaux, stockSucreInitial, consommationEauInitiale);
        }


        // Café allongé sucré
        {
            var nombreCafésInitiaux = machine.GetNbCafe();
            var stockSucreInitial = machine.GetStockSucre();
            var consommationEauInitiale = machine.GetConsommationEau();

            machine.DemanderSucre();
            machine.pressCafeLong();
            machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);

            assertThat(machine).sertUnCaféLongSucré(nombreCafésInitiaux, stockSucreInitial, consommationEauInitiale);
        }
    }
}
