package machine.paiement;

import machine.IMachineACafe;
import machine.MachineACafe;
import org.bank.paiement.IMoteurPaiement;

public class MoteurPaiementAdapter implements IMachineACafe {
    private final IMachineACafe decorated;

    public MoteurPaiementAdapter(IMachineACafe decorated, IMoteurPaiement moteurPaiement) {
        this.decorated = decorated;
        moteurPaiement.ObserverPrésenceCarte(
                iPrelevable -> {
                    var aPuPrélever = iPrelevable.Prélever(MachineACafe.PrixDuCaféEnCentimes / 100.0);
                    if(aPuPrélever) decorated.Insérer(MachineACafe.PrixDuCaféEnCentimes);
                }
        );
    }

    @Override
    public int GetNbCafe(){
        return decorated.GetNbCafe();
    }

    @Override
    public void Insérer(int sommeEnCentimes) {
        decorated.Insérer(sommeEnCentimes);
    }

    @Override
    public int GetSommeEnCentimes() {
        return decorated.GetSommeEnCentimes();
    }
}
