package org.bank.paiement;

import java.util.Random;
import java.util.function.Consumer;

public class VraiMoteurDePaiement implements IMoteurPaiement {

    private Consumer<IPrelevable> _callback;

    public VraiMoteurDePaiement(){
        _callback = iPrelevable -> {};
    }

    @Override
    public void ObserverPrésenceCarte(Consumer<IPrelevable> callback) {
        _callback = callback;
    }

    public void PasserLaCarte(){
        _callback.accept(new CarteDePaiement());
    }

    private class CarteDePaiement implements IPrelevable {
        @Override
        public boolean Prélever(double somme) {
            return new Random().nextInt(10) != 1;
        }
    }
}
