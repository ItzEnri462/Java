public class nPerfetto {
    private int n;

    public nPerfetto(int n) {
        this.n = n;
    }

    public boolean verificaPerfetto() {
        if (n <= 0)
            return false;
        int somma = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                somma += i;
                int complementare = n / i;
                if (complementare != i)
                    somma += complementare;
            }
        }
        return somma == n;
    }

    @Override
    public String toString() {
        if (verificaPerfetto())
            return "SI";
        return "NO";
    }

}
