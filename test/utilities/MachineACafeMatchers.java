package utilities;

import machine.MachineACafe;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class MachineACafeMatchers extends AbstractAssert<MachineACafeMatchers, MachineACafe>
{
    public static MachineACafeMatchers assertThat(MachineACafe actual) {
        return new MachineACafeMatchers(actual);
    }

    public MachineACafeMatchers(MachineACafe machineACafe) {
        super(machineACafe, MachineACafeMatchers.class);
    }

    public MachineACafeMatchers rendLArgent(){
        if(actual.GetSommeEnCentimes() != 0){
            failWithMessage("Il était attendu que la machine n'ait pas d'argent encaissé. Elle possède %s",
                    actual.GetSommeEnCentimes());
        }
        return this;
    }

    public MachineACafeMatchers encaisse(int somme){
        if(actual.GetSommeEnCentimes() != somme){
            failWithMessage("Il était attendu que la machine encaisse %s. Elle a encaissé %s",
                    somme, actual.GetSommeEnCentimes());
        }
        return this;
    }

    public MachineACafeMatchers neSertPasDeCafé(int nombrePrécédent){
        if(actual.GetNbCafe() != nombrePrécédent){
            failWithMessage("Il était attendu que la machine ne serve pas de café. Elle en a servi %s",
                    actual.GetNbCafe() - nombrePrécédent);
        }
        return this;
    }

    public MachineACafeMatchers sertUnCafé(int nombrePrécédent){
        if(actual.GetNbCafe() != nombrePrécédent + 1){
            failWithMessage("Il était attendu que la machine serve un café. Elle en a servi %s",
                    actual.GetNbCafe() - nombrePrécédent);
        }
        return this;
    }

    public MachineACafeMatchers consommeNDosesEau(int consommationAttendue, int consommationEauPrécédente){
        int consommationEauActuelle = actual.GetConsommationEau();

        if(consommationEauActuelle != consommationEauPrécédente + consommationAttendue){
            failWithMessage("Il était attendu que la machine consomme %s volumes d'eau. Elle en a consommé %s",
                    consommationAttendue, consommationEauActuelle - consommationEauPrécédente);
        }

        return this;
    }

    public MachineACafeMatchers consommeNDosesDeSucre(int consommationAttendue, int stockSucrePrécédent){
        if(actual.GetStockSucre() != stockSucrePrécédent - consommationAttendue){
            failWithMessage("Il était attendu que la machine consomme %s doses de sucre. Elle en a consommé %s",
                    consommationAttendue, actual.GetStockSucre() - stockSucrePrécédent);
        }

        return this;
    }

    public MachineACafeMatchers sertUnCaféLong(int nombreCafésPrécédent, int consommationEauPrécédente){
        assertThat(actual).sertUnCafé(nombreCafésPrécédent);
        assertThat(actual).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        assertThat(actual).consommeNDosesEau(2, consommationEauPrécédente);
        return this;
    }

    public MachineACafeMatchers sertUnCaféCourtNonSucré(int nombreCafésPrécédent, int stockSucrePrécédent, int consommationEauPrécédente){
        assertThat(actual).sertUnCafé(nombreCafésPrécédent);
        assertThat(actual).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        assertThat(actual).consommeNDosesEau(1, consommationEauPrécédente);
        assertThat(actual).consommeNDosesDeSucre(0, stockSucrePrécédent);

        return this;
    }

    public MachineACafeMatchers sertUnCaféCourtSucré(int nombreCafésPrécédent, int stockSucrePrécédent, int consommationEauPrécédente){
        assertThat(actual).sertUnCafé(nombreCafésPrécédent);
        assertThat(actual).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        assertThat(actual).consommeNDosesEau(1, consommationEauPrécédente);
        assertThat(actual).consommeNDosesDeSucre(1, stockSucrePrécédent);

        return this;
    }

    public MachineACafeMatchers sertUnCaféLongSucré(int nombreCafésPrécédent, int stockSucrePrécédent, int consommationEauPrécédente){
        assertThat(actual).sertUnCafé(nombreCafésPrécédent);
        assertThat(actual).encaisse(MachineACafe.PrixDuCaféEnCentimes);
        assertThat(actual).consommeNDosesEau(2, consommationEauPrécédente);
        assertThat(actual).consommeNDosesDeSucre(1, stockSucrePrécédent);

        return this;
    }
}
