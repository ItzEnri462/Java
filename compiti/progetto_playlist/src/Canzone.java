import java.time.Duration;

public class Canzone {
    String titolo;
    String artista;
    Duration durata;

    public Canzone(String titolo, String artista, Duration durata) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public Duration getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        long minuti = durata.toMinutes();
        long secondi = durata.toSeconds();
        return "Titolo: " + titolo + "\nDurata: " + minuti + " minuti e " + secondi + " secondi" + "\nArtista: " + artista;
    }
}
