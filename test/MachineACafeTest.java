import machine.MachineACafe;
import machine.eau.PasAssezEauException;
import org.junit.Assert;
import org.junit.Test;
import utilities.FournisseurEauSpy;
import utilities.MachineACafeBuilder;

import static org.junit.Assert.assertEquals;
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



    @Test
    public void Test_CASDosageEau() throws PasAssezEauException {

        //Etant donné une machine a café avec un fournisseur d'eau avec du stock
        var fournisseur = new FournisseurEauSpy(5);
        MachineACafe machine = new MachineACafeBuilder()
                .AyantPourFournisseurEau(fournisseur)
                .Build();
        int nbCafe = machine.GetNbCafe();
        machine.pressCafeLong();

        //Quand l’utilisateur met >4 au prix du café
        machine.Insérer(MachineACafe.PrixDuCaféEnCentimes );

        //Alors somme  encaissée
        assertThat(machine).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        //Et on consomme un café
        assertThat(machine).sertUnCafé(nbCafe);
        //Et on a consommé un café long (2 doses)
        assertEquals(2, fournisseur.eauconsomme);
    }

    @Test
    public void Test_CASDosageEau_2() throws PasAssezEauException {

        //Etant donné une machine a café avec un fournisseur d'eau avec du stock
        var fournisseur = new FournisseurEauSpy(5);
        MachineACafe machine = new MachineACafeBuilder()
                .AyantPourFournisseurEau(fournisseur)
                .Build();
        //Quand presse café long
        machine.pressCafeLong();

        //Alors on ne consommme pas d'eau
        assertEquals(0, fournisseur.eauconsomme);
    }

    @Test
    public void Test_Ajout_Sucre(){
        //Etant donné bouton sucre appuyé
        var machine = MachineACafeBuilder.Default();
        var nbCafésInitiaux = machine.GetNbCafe();
        var stockSucreInitial = machine.GetStockSucre();
        machine.DemanderSucre();

        //Quand l’utilisateur met une somme >= au prix du café
        machine.Insérer(40);

        //Alors un café sucré est payé et servi
        assertThat(machine).sertUnCaféSucré(nbCafésInitiaux, stockSucreInitial);
    }

    public void Test_Stock_Sucre_Insuffisant(){

        //Etant donné bouton sucre appuyé et stock sucre insuffisant
        var machine = new MachineACafeBuilder()
                .SansSucre()
                .Build();
        //    Quand l’utilisateur met somme >= au prix du café
        machine.Insérer(40);

        //    Alors retourne somme et on ne sert pas de café
        assertThat(machine).rendLArgent();
    }


}

