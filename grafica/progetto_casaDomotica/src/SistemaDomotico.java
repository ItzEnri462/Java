import graphics.Color;
import graphics.Ellipse;

public class SistemaDomotico {
    private final int max;
    private int lampadineAttuali;
    private Lampadina[] lampadine;
    private Ellipse[] disegni;

    public SistemaDomotico() {
        max = 100;
        lampadine = new Lampadina[max];
        lampadineAttuali = 0;
        disegni = new Ellipse[max];
    }

    public SistemaDomotico(int n) {
        if (n < 1)
            n = 100;
        max = n;
        lampadine = new Lampadina[max];
        lampadineAttuali = 0;
        disegni = new Ellipse[max];
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

    public void disegnaLampadina() {
        int raggio = lampadine[lampadineAttuali].getPotenza() * 2;
        disegni[lampadineAttuali] = new Ellipse(lampadine[lampadineAttuali].getX(), lampadine[lampadineAttuali].getY(), raggio, raggio);
        Color colore = new Color(254, 255, 153);
        disegni[lampadineAttuali].setColor(colore);
        disegni[lampadineAttuali].fill();
    }

    public void disegnaLampadina(String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome().toLowerCase().equals(nome)) {
                int raggio = lampadine[i].getPotenza() * 2;
                disegni[i] = new Ellipse(lampadine[i].getX(), lampadine[i].getY(), raggio, raggio);
                Color colore = new Color(254, 255, 153);
                disegni[i].setColor(colore);
                disegni[i].fill();
            }
        }

    }

    public void nascondiLampadina(String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome().toLowerCase().equals(nome)) {
                int raggio = lampadine[i].getPotenza() * 2;
                disegni[i].grow(-raggio, -raggio);
            }
        }
    }

    public void togliLampadina(String nome) {
        this.rimuovi(nome);
        this.nascondiLampadina(nome);
    }

    @Override
    public String toString() {
        return "Sistema domotico con " + lampadineAttuali + " lampadine, su " + max + " totali";
    }
}
