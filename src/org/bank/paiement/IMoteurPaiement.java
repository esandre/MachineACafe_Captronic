package org.bank.paiement;

import java.util.function.Consumer;

public interface IMoteurPaiement {
    void ObserverPr√©senceCarte(Consumer<IPrelevable> callback);
}