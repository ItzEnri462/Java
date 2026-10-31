public class Domanda {
    private static final int MAXRISPOSTE = 4;
    private String testo;
    private Risposta[] risposte;
    private int valore;
    private int scelta;
    private boolean isEsatta;

    public Domanda(String testo, Risposta[] risposte) {
        this.testo = testo;
        this.valore = 1;
        this.risposte = new Risposta[MAXRISPOSTE];
        for (int i = 0; i < MAXRISPOSTE; i++) {
            this.risposte[i] = risposte[i];
        }
        this.scelta = -1;
    }

    public Domanda(Domanda d) {
        this.testo = d.testo;
        this.valore = d.valore;
        this.scelta = -1;
        this.risposte = new Risposta[MAXRISPOSTE];
        for (int i = 0; i < MAXRISPOSTE; i++) {
            this.risposte[i] = new Risposta(risposte[i]);
        }
    }

    public boolean rispondi(int scelta) {
        this.scelta = scelta;
        if (risposte[scelta].getCorrect()) {
            isEsatta = true;
            return true;
        }
        isEsatta = false;
        return false;
    }
}
