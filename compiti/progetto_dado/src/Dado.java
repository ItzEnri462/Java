public class Dado {
    private int nFacce = 6;

    public Dado(int n) {
        if (n <= 3)
            n = 6;
        this.nFacce = n;
    }
    public Dado(Dado d) {
        this.nFacce = d.nFacce;
    }
    public int lancia(Dado d) {
        return (int)(Math.random() * d.nFacce + 1);
    }
}
