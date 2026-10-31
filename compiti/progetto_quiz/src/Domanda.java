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
        if (scelta == -1)
            return false;
        this.scelta = scelta;
        if (!risposte[scelta].getCorrect()) {
            isEsatta = false;
            return false;
        }
        isEsatta = true;
        return true;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        if (valore > 0)
            this.valore = valore;
    }

    public int getPunteggio() {
        if (rispondi(scelta)) {
            return valore;
        }
        if (!rispondi(scelta) && scelta != -1) {
            return 0;
        }
        return -1;
    }

    public boolean completata() {
        return this.scelta != -1;
    }

    public String getRispostaCorretta() {
        for (int i = 0; i < MAXRISPOSTE; i++) {
            if (risposte[i].getCorrect()) {
                return risposte[i].getR();
            }
        }
        return "La domanda non ha risposte giuste";
    }

    public String getRispostaData() {
        if (scelta == -1)
            return null;
        return risposte[scelta].getR();
    }

    @Override
    public String toString() {
        return testo + "\n1. " + risposte[0].getR() + "\n2. " + risposte[1].getR() + "\n3. " + risposte[2].getR() + "\n4. " + risposte[3].getR();
    }
}
