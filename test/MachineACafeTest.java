import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineACafeTest {
    @Test
    public void Test_CAS1()
    {
        //Etant donné
        MachineACafe machine = new MachineACafe();
        int nbCafe = machine.GetNbCafe();
        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

        //Alors somme encaissée
        double somme = machine.GetSomme();
        assertEquals( 0.4, somme, 0.05 );
        //Et nb cafés augmente de 1
        assertEquals( nbCafe + 1, machine.GetNbCafe() );
    }

    @Test
    public void Test_CAS2()
    {

        //Etant donné pas de café sans café
        MachineACafe machine = new MachineACafe(0, true);
        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

        //Alors retourne somme
        double somme = machine.GetSomme();
        assertEquals( 0, somme, 0.05 );
    }

    @Test
    public void Test_CAS3()
    {

        //Etant donné machine pas d'eau
        MachineACafe machine = new MachineACafe(1, false);
        //Quand l’utilisateur met somme >= 40 centimes
        machine.Insert( 40 );

        //Alors retourne somme
        double somme = machine.GetSomme();
        assertEquals( 0, somme, 0.05 );
    }
}

