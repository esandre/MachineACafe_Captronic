import machine.paiement.MoteurPaiementAdapter;
import org.junit.Test;
import utilities.MachineACafeSpy;
import utilities.MoteurPaiementMock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoteurPaiementTest {
    @Test
    public void AppelInsérerSiCartePrélevée(){
        // ETANT DONNE une machine à café abonnée à un moteur de paiement validant les transactions
        var machineOriginale = new MachineACafeSpy();
        var moteurPaiement = new MoteurPaiementMock(true);
        new MoteurPaiementAdapter(machineOriginale, moteurPaiement);

        // QUAND la machine est informée qu'une carte est passée
        moteurPaiement.SimulerPrésentationCarte();

        // ALORS la machine agit comme si Insérer était appelée avec le montant prélevé
        var sommeDesAppelsAInsérer = machineOriginale.SommeDesAppelsAInsérer();
        assertThat(sommeDesAppelsAInsérer.size()).isEqualTo(1);
        //noinspection OptionalGetWithoutIsPresent
        assertThat(sommeDesAppelsAInsérer.stream().findFirst().get()).isEqualTo(40);
    }

    @Test
    public void AppelInsérerSiCarteRejetée(){
        // ETANT DONNE une machine à café abonnée à un moteur de paiement rejetant les transactions
        var machineOriginale = new MachineACafeSpy();
        var moteurPaiement = new MoteurPaiementMock(false);
        new MoteurPaiementAdapter(machineOriginale, moteurPaiement);

        // QUAND la machine est informée qu'une carte est passée
        moteurPaiement.SimulerPrésentationCarte();

        // ALORS la machine agit comme si Insérer n'était pas appelé
        var sommeDesAppelsAInsérer = machineOriginale.SommeDesAppelsAInsérer();
        assertThat(sommeDesAppelsAInsérer.size()).isZero();
    }
}
