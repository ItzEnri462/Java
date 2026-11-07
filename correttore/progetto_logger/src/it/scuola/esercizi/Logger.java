package it.scuola.esercizi;

import java.time.Instant;

class Azione {
    private String descrizione;
    private Instant i;
    private int attenzione;

    public Azione(int attenzione, String descrizione) {
        if (attenzione < 1)
            attenzione = 1;
        else if (attenzione > 5)
            attenzione = 5;
        this.attenzione = attenzione;
        this.descrizione = descrizione;
        i = Instant.now();
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Instant getI() {
        return i;
    }

    public String getAttenzione() {
        if (attenzione == 1)
            return "nessun problema";
        if (attenzione == 2)
            return "annotazione";
        if (attenzione == 3)
            return "evento moderato";
        if (attenzione == 4)
            return "evento grave";
        return "evento critico";
    }

    @Override
    public String toString() {
        return "Descrizione: " + descrizione + "\n" + i + "\n" + this.getAttenzione();
    }
}

public class Logger {
}
