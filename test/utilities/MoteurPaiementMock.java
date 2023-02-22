package utilities;

import org.bank.paiement.IMoteurPaiement;
import org.bank.paiement.IPrelevable;

import java.util.function.Consumer;

public class MoteurPaiementMock implements IMoteurPaiement {
    private final boolean réponseFixe;
    private Consumer<IPrelevable> callback;

    public MoteurPaiementMock(boolean réponseFixe) {
        this.réponseFixe = réponseFixe;
    }

    @Override
    public void ObserverPrésenceCarte(Consumer<IPrelevable> callback) {
        this.callback = callback;
    }

    public void SimulerPrésentationCarte() {
        callback.accept(somme -> réponseFixe);
    }
}
