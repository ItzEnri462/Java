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
        disegni[lampadineAttuali] = lampadine[lampadineAttuali].disegna();
    }

    public void disegnaLampadina(String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome().toLowerCase().equals(nome)) {
                lampadine[i].disegna();
            }
        }

    }

    private void nascondiLampadina(String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (lampadine[i].getNome().toLowerCase().equals(nome)) {
                lampadine[i].nascondi(disegni[i]);
            }
        }
    }

    public void togliLampadina(String nome) {
        this.nascondiLampadina(nome);
        this.rimuovi(nome);
    }

    public void aumentaPotLampadina(int valore, String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (nome.equals(lampadine[i].getNome().toLowerCase())) {
                lampadine[i].aumentaPotenza(valore);
            }
        }
    }

    public void aumentaLumLampadina(String nome) {
        nome = nome.toLowerCase();
        for (int i = 0; i < lampadineAttuali; i++) {
            if (nome.equals(lampadine[i].getNome().toLowerCase())) {
                lampadine[i].aumentaLuminosita();
            }
        }
    }

    public void cambiaColoreLampadina(String nome, Color colore) {
        for (int i = 0; i < lampadineAttuali; i++) {
            if (nome.equals(lampadine[i].getNome().toLowerCase())) {
                lampadine[i].cambiaColore(colore);
            }
        }
    }

    public void accendiLampadina(String nome) {
        for (int i = 0; i < lampadineAttuali; i++) {
            if (nome.equals(lampadine[i].getNome().toLowerCase())) {
                lampadine[i].cambiaColore(colore);
            }
        }
    }

    public void spegniLampadina(String nome) {
        this.cambiaColoreLampadina(nome, Color.DARK_GRAY);
    }

    @Override
    public String toString() {
        return "Sistema domotico con " + lampadineAttuali + " lampadine, su " + max + " totali";
    }
}
