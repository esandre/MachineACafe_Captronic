public class MachineACafe {

    private int servedCafe = 0;

    public MachineACafe(int i, boolean b, boolean b1) {
    }
    public MachineACafe() {
    }

    public int GetNbCafe() {
       return servedCafe++;
    }

    public void Insert(double v) {

    }

    public double GetSomme() {

        return servedCafe * 0.40;
    }
}
