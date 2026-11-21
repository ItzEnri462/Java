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
            if (lampadine[i].getNome().equals( l.getNome())) {
                return false;
            }
        }
        lampadine[lampadineAttuali] = l;
        return true;
    }

    public Lampadina cerca(String nome) {
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome().equals(nome)) {
                return lampadine[i];
            }
        }
        return null;
    }

    public boolean rimuovi(String nome) {
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i] != null && lampadine[i].getNome().equals(nome)) {
                for (int j = i; j < lampadineAttuali - 1; j++) {
                    lampadine[j] = lampadine[j + 1];
                }
                lampadine[lampadineAttuali - 1] = null;
                lampadineAttuali--;
                return true;
            }
        }
        return false;
    }

    public int getQuanteLampadine() {
        return lampadineAttuali;
    }

    public double getPotenzaAttuale() {
        double potenzaTot = 0;
        for (int i = 0; i < lampadineAttuali; i++) {
            potenzaTot += lampadine[i].getPotenza() * (lampadine[i].getIntensita() / 100.0);
        }
        return potenzaTot;
    }

    @Override
    public String toString() {
        return "Sistema domotico con " + lampadineAttuali + " lampadine, su " + max + " totali";
    }
}
