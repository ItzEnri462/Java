package it.scuola.esercizi;

import java.awt.event.WindowStateListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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

    public Azione(Azione a) {
        this.descrizione = a.descrizione;
        this.i = a.i;
        this.attenzione = a.attenzione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Instant getI() {
        return i;
    }

    public int getNumAttenzione() {
        return attenzione;
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
    private final int maxAzioni;
    Azione[] azioni;
    int azioniAttuali;

    public Logger(int maxAzioni) {
        this.maxAzioni = maxAzioni;
        azioni = new Azione[maxAzioni];
        azioniAttuali = 0;
    }

    public boolean add(Azione a) {
        if (azioniAttuali >= maxAzioni - 1)
            return false;
        azioni[azioniAttuali] = a;
        azioniAttuali++;
        return true;
    }

    public Azione getAzione(int i) {
        if (azioni[i] != null)
            return azioni[i];
        return null;
    }

    public Azione[] getByAttenzione(int attenzione) {
        Azione[] a = new Azione[azioniAttuali];
        int t = 0;
        for (int i = 0; i < azioniAttuali; i++) {
            if (azioni[i].getNumAttenzione() == attenzione) {
                a[t] = new Azione(azioni[i]);
                t++;
            }
        }
        return a;
    }

    public int size() {
        return azioniAttuali;
    }

    public boolean isEmpty() {
        if (azioni[0] == null)
            return true;
        return false;
    }


    @Override
    public String toString() {
        LocalDate i = LocalDate.from(this.getAzione(0).getI());
        LocalDateTime inizio = LocalDateTime.from(this.getAzione(0).getI());
        LocalDate dataFine = LocalDate.from(this.getAzione(azioni.length - 1).getI());
        LocalTime fine = LocalTime.from(this.getAzione(azioni.length - 1).getI());
        for (int j = 1; j <= 5; j++) {
            String s = "\nLivello " + j + " : " + getByAttenzione(j).length;
        }
        if (this.isEmpty())
            return "numero totale di azioni: " + azioniAttuali;
        return "numero totale di azioni: " + azioniAttuali + s + "\nLe azioni sono state memorizzate a partire dalle " +
        inizio.getHour() + ":" + inizio.getMinute() + ":" + inizio.getSecond() + " del " + i + " UTC \nfino alle ore " + fine + " del " + dataFine + " UTC";
    }
}
