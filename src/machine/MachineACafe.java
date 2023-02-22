package machine;

public class MachineACafe {
    private final IRessourcesMachineACafe ressources;
    private int cafésServis = 0;
    private int sommeEncaisséeEnCentimes = 0;

    public MachineACafe(IRessourcesMachineACafe ressources) {
        this.ressources = ressources;
    }

    public int GetNbCafe() {
       return cafésServis;
    }

    private boolean PeutServirCafé(int sommeInséréeEnCentimes){
        return sommeInséréeEnCentimes >= 40 &&
                ressources.EauDisponible() &&
                ressources.CaféDisponible() > 0 &&
                ressources.GobeletsDisponibles();
    }

    public void Insérer(int sommeEnCentimes) {
        if(PeutServirCafé(sommeEnCentimes)) {
            cafésServis++;
            sommeEncaisséeEnCentimes = sommeEnCentimes;
        }
    }

    public int GetSommeEnCentimes() {
        return sommeEncaisséeEnCentimes;
    }
}
