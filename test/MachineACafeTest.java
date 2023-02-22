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
        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

        //Alors somme encaissée
        assertThat(machine).encaisse(40);
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

        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

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
        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

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

        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

        //Alors retourne somme
        assertThat(machine).rendLArgent();
    }

    @Test
    public void Test_CAS5()
    {
        //Etant donné
        MachineACafe machine = MachineACafeBuilder.Default();
        int nbCafe = machine.GetNbCafe();

        //Quand l’utilisateur met somme < 40 centimes
        machine.Insert( 39 );

        //Alors somme non encaissée
        assertThat(machine).rendLArgent();
        //Et nb cafés n'augmente pas
        assertThat(machine).neSertPasDeCafé(nbCafe);
    }
}

