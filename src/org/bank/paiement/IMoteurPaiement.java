package org.bank.paiement;

import java.util.function.Consumer;

public interface IMoteurPaiement {
    void ObserverPrésenceCarte(Consumer<IPrelevable> callback);
}