public class Dado {
    private int nFacce;

    public Dado() {
        this.nFacce = 6;
    }

    public Dado(int n) {
        if (n <= 3)
            n = 6;
        this.nFacce = n;
    }

    public Dado(Dado d) {
        this.nFacce = d.nFacce;
    }

    public int lancia() {
        return (int)(Math.random() * this.nFacce + 1);
    }

    @Override
    public String toString() {
        return "Il dado ha " + this.nFacce + " facce";
    }
}
