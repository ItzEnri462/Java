public class SistemaDomotico {
    private final int max;
    private int lampadineAttuali;
    private Lampadina[] lampadine;

    public SistemaDomotico() {
        max = 100;
        lampadine = new Lampadina[max];
        lampadineAttuali = 0;
    }

    public SistemaDomotico(int n) {
        if (n < 1)
            n = 100;
        max = n;
        lampadine = new Lampadina[max];
        lampadineAttuali = 0;
    }

    public boolean add(Lampadina l) {
        if (lampadineAttuali >= max)
            return false;
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome() == l.getNome()) {
                return false;
            }
        }
        lampadine[lampadineAttuali] = l;
        return true
    }
}
