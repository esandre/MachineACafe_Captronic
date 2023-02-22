import machine.MachineACafe;
import org.junit.Test;
import utilities.MachineACafeBuilder;

import static utilities.MachineACafeMatchers.assertThat;

public class MachineACafeTest {
    @Test
    public void Test_CAS1()
    {
        //Etant donné
        MachineACafe machine = MachineACafeBuilder.Default();
        int nbCafe = machine.GetNbCafe();
        //Quand l’utilisateur met somme >= au prix du café
        machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);

        //Alors somme encaissée
        assertThat(machine).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        //Et nb cafés augmente de 1
        assertThat(machine).sertUnCafé(nbCafe);
    }

    @Test
    public void Test_CAS2()
    {
        //Etant donné pas de café
        MachineACafe machine = new MachineACafeBuilder()
                .SansCafé()
                .Build();

        //Quand l’utilisateur met une somme >= au prix du café
        machine.Insérer( MachineACafe.PrixDuCaféEnCentimes );

        //Alors retourne somme
        assertThat(machine).rendLArgent();
    }

    @Test
    public void Test_CAS3()
    {
        //Etant donné machine pas d'eau
        MachineACafe machine = new MachineACafeBuilder()
                .SansEau()
                .Build();

        //Quand l’utilisateur met somme >= au prix du café
        machine.Insérer(MachineACafe.PrixDuCaféEnCentimes);

        //Alors retourne somme
        assertThat(machine).rendLArgent();
    }

    @Test
    public void Test_CAS4()
    {
        //Etant donné machine pas de gobelet
        MachineACafe machine = new MachineACafeBuilder()
                .SansGobelets()
                .Build();

        //Quand l’utilisateur met somme >= au prix du café
        machine.Insérer( MachineACafe.PrixDuCaféEnCentimes);

        //Alors retourne somme
        assertThat(machine).rendLArgent();
    }

    @Test
    public void Test_CAS5()
    {
        //Etant donné
        MachineACafe machine = MachineACafeBuilder.Default();
        int nbCafe = machine.GetNbCafe();

        //Quand l’utilisateur met somme < au prix du café
        machine.Insérer(MachineACafe.PrixDuCaféEnCentimes - 1);

        //Alors somme non encaissée
        assertThat(machine).rendLArgent();
        //Et nb cafés n'augmente pas
        assertThat(machine).neSertPasDeCafé(nbCafe);
    }
}

