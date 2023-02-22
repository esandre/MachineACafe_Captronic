import machine.MachineACafe;
import org.junit.Test;
import utilities.MachineACafeBuilder;

import static org.assertj.core.api.Assertions.*;

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
        int somme = machine.GetSomme();
        assertThat(somme).isEqualTo(40);
        //Et nb cafés augmente de 1
        assertThat(machine.GetNbCafe()).isEqualTo(nbCafe +1);
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
        int somme = machine.GetSomme();
        assertThat(somme).isZero();
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
        int somme = machine.GetSomme();
        assertThat(somme).isZero();
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
        int somme = machine.GetSomme();
        assertThat(somme).isZero();
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
        int somme = machine.GetSomme();
        assertThat(somme).isZero();
        //Et nb cafés n'augmente pas
        assertThat(machine.GetNbCafe()).isEqualTo(nbCafe);
    }
}

