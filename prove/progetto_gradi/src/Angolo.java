public class Angolo {
    private int gradi;
    private int minuti;
    private int secondi;

    public Angolo() {
        this.gradi = 0;
        this.minuti = 0;
        this.secondi = 0;
    }

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

    public int getGradi() {
        return gradi;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public int toSecondi() {
        return this.gradi * 3600 + this.minuti * 3600 + this.secondi;
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

    public Angolo differenzaAngolo(Angolo b) {
        Angolo c = new Angolo();
        Angolo maggiore = null;
        Angolo minore = null;

        if (this.toSecondi() > b.toSecondi()) {
            maggiore = this;
            minore = b;
        } else {
            maggiore = b;
            minore = this;
        }
        int diffSecondi = maggiore.toSecondi() - minore.toSecondi();
        c.gradi = diffSecondi / 3600;
        c.minuti = (diffSecondi % 3600) / 60;
        c.secondi = diffSecondi % 60;
        return c;
    }


}
