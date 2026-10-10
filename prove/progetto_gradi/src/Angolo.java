public class Angolo {
    private int gradi;
    private int minuti;
    private int secondi;

    public Angolo(Angolo a) {
        this.gradi = a.gradi;
        this.minuti = a.minuti;
        this.secondi = a.secondi;
    }

    public void setGradi(int n) {
        this.gradi = n;
    }
    public void setMinuti(int n) {
        this.minuti = n;
    }
    public void setSecondi(int n) {
        this.secondi = n;
    }
}
