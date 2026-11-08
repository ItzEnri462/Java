package it.scuola.esercizi;

import java.time.*;

class Azione {
    private String descrizione;
    private Instant i;
    private int attenzione;

    public Azione(String descrizione, int attenzione) {
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

    public Instant getData() {
        return i;
    }

    public int getAttenzione() {
        return attenzione;
    }

    public String getLivelloAttenzione() {
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
        return "Descrizione: " + descrizione + "\n" + i + "\n" + this.getLivelloAttenzione();
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
        if (azioniAttuali >= maxAzioni)
            return false;
        azioni[azioniAttuali] = a;
        azioniAttuali++;
        return true;
    }

    public Azione get(int i) {
        if (i < 0 || i >= azioniAttuali) {
            return null;
        }
        return azioni[i];
    }

    public Azione[] getByAttenzione(int attenzione) {
        int contatore = 0;
        for (int i = 0; i < azioniAttuali; i++) {
            if (azioni[i].getAttenzione() == attenzione) {
                contatore++;
            }
        }
        Azione[] risultato = new Azione[contatore];

        int t = 0;
        for (int i = 0; i < azioniAttuali; i++) {
            if (azioni[i].getAttenzione() == attenzione) {
                risultato[t] = new Azione(azioni[i]);
                t++;
            }
        }

        return risultato;
    }

    public int size() {
        return azioniAttuali;
    }

    public boolean isEmpty() {
        return azioniAttuali == 0;
    }


    @Override
    public String toString() {
        String s = "Numero totale di azioni: " + azioniAttuali;
        if (this.isEmpty())
            return s;
        for (int j = 1; j <= 5; j++) {
            s += "\nLivello " + j + " : " + getByAttenzione(j).length + " azioni";
        }
        LocalDateTime inizio = LocalDateTime.ofInstant(this.get(0).getData(), ZoneId.of("UTC"));
        LocalDate dataInizio = inizio.toLocalDate();

        LocalDateTime fine = LocalDateTime.ofInstant(this.get(azioniAttuali - 1).getData(), ZoneId.of("UTC"));

        LocalDate dataFine = fine.toLocalDate();
        LocalTime oraFine = fine.toLocalTime();
        return s + "\nLe azioni sono state memorizzate a partire\ndalle " +
        inizio.getHour() + ":" + inizio.getMinute() + ":" + inizio.getSecond() + " del " + dataInizio + " UTC \nfino alle ore " + oraFine + " del " + dataFine + " UTC";
    }
}
