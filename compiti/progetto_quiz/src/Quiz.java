public class Quiz {
    private String titolo;
    private Domanda[] domande;
    private int numeroDomande;

    public Quiz(String titolo) {
        this.titolo = titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = 0;
    }

    public Quiz(Quiz q) {
        this.titolo = q.titolo;
        this.domande = new Domanda[100];
        this.numeroDomande = q.numeroDomande;
        for (int i = 0; i < q.numeroDomande; i++) {
            this.domande[i] = new Domanda(q.domande[i]);
        }
    }

    public boolean add(Domanda d) {
        if (this.numeroDomande < 100) {
            this.domande[this.numeroDomande] = d;
            this.numeroDomande++;
            return true;
        }
        return false;
    }

    public int getQuanteDomande() {
        return this.numeroDomande;
    }

    public int getQuanteRisposte() {
        int conteggio = 0;
        for (int i = 0; i < this.numeroDomande; i++) {
            if (this.domande[i].completata()) {
                conteggio++;
            }
        }
        return conteggio;
    }

    public int[] getDomandeNonDate() {
        int nonDate = 0;
        for (int i = 0; i < this.numeroDomande; i++) {
            if (!this.domande[i].completata()) {
                nonDate++;
            }
        }

        int[] indici = new int[nonDate];
        int index = 0;
        for (int i = 0; i < this.numeroDomande; i++) {
            if (!this.domande[i].completata()) {
                indici[index] = i + 1;
                index++;
            }
        }
        return indici;
    }

    public Domanda getDomanda(int indice) {
        if (indice >= 1 && indice <= this.numeroDomande) {
            return this.domande[indice - 1];
        }
        return null;
    }

    public int getTotale() {
        int totalePunti = 0;
        for (int i = 0; i < this.numeroDomande; i++) {
            totalePunti += this.domande[i].getValore();
        }
        return totalePunti;
    }

    public int getPunteggio() {
        int punteggio = 0;
        for (int i = 0; i < this.numeroDomande; i++) {
            int p = this.domande[i].getPunteggio();
            if (p > 0) {
                punteggio += p;
            }
        }
        return punteggio;
    }

    @Override
    public String toString() {
        return "Quiz: " + this.titolo + "\n" +
                "Numero domande: " + this.numeroDomande + "\n" +
                "Punteggio totale: " + this.getTotale() + " punti";
    }
}
