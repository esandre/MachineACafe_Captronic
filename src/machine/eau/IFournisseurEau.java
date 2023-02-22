package machine.eau;

public interface IFournisseurEau {
    void Consommer(int doses) throws PasAssezEauException;
}
