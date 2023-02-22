import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineACafeTest {
    @Test
    public void Test_Env()
    {
        //Etant donné
        MachineACafe machine = new MachineACafe();
        int nbCafe = machine.GetNbCafe();
        //Quand l’utilisateur met somme >= 0.40
        machine.Insert( 0.40 );

        //Alors somme encaissée
        double somme = machine.GetSomme();
        assertEquals( 0.40, somme, 0.05 );
        //Et nb cafés augmente de 1
        assertEquals( nbCafe + 1, machine.GetNbCafe() );
    }
}
