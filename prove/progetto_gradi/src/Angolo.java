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

    public Angolo sommaAngoli(Angolo b) {
        Angolo c = new Angolo();
        int gradi = this.gradi + b.gradi;
        int minuti = this.minuti + b.minuti;
        int secondi = this.secondi + b.secondi;

        minuti = minuti + secondi / 60;
        secondi = secondi % 60;

        gradi = gradi + minuti / 60;
        minuti = minuti % 60;

        gradi = gradi %360;

        c.gradi = gradi;
        c.minuti = minuti;
        c.secondi = secondi;
        return c;
    }
}
