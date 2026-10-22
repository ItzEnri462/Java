import java.time.Duration;

public class Playlist {
    private String nome;
    private static final int MAX = 100;
    private int quantiBrani;
    private int numeroCanzone;
    private String stato;
    private Canzone[] canzoni;

    public Playlist(String nome, Canzone[] canzoni) {
        int braniAttuali = canzoni.length;
        if (braniAttuali > MAX)
            braniAttuali = MAX;
        this.canzoni = new Canzone[MAX];

        for (int i = 0; i < canzoni.length && this.quantiBrani < MAX; i++) {
            if (canzoni[i] != null) {
                this.canzoni[this.quantiBrani] = canzoni[i];
                this.quantiBrani++;
            }
        }

        this.nome = nome;
        numeroCanzone = 0;
        stato = "STOP";
    }

    public Playlist(Playlist p) {
        this.nome = p.nome;
        this.quantiBrani = p.quantiBrani;
        this.numeroCanzone = p.numeroCanzone;
        this.stato = p.stato;
        this.canzoni = new Canzone[MAX];
        System.arraycopy(p.canzoni, 0, this.canzoni, 0, p.quantiBrani);
    }

    public Canzone getCanzone(int n) {
        n--;
        if (n < 0 || n > 99)
            return null;
        return this.canzoni[n];
    }

    public String getNome() {
        return nome;
    }

    public int getQuantiBrani() {
        return quantiBrani;
    }

    public void play() {
        stato = "PLAY";
    }

    public void pause() {
        if (!stato.equals("STOP")) {
            stato = "PAUSE";
        }
    }

    public void stop() {
        if (stato.equals("STOP")) {
            numeroCanzone = 1;
        }
        stato = "STOP";
    }

    public void branoSuccessivo() {
        if (numeroCanzone == quantiBrani) {
            numeroCanzone = 1;
        } else {
            numeroCanzone++;
        }
    }

    public void branoPrecedente() {
        if (numeroCanzone == 1) {
            numeroCanzone = quantiBrani;
        } else {
            numeroCanzone--;
        }
    }

    public boolean add(Canzone c) {
        if (quantiBrani >= MAX) {
            return false;
        }
        canzoni[quantiBrani + 1] = c;
        quantiBrani++;
        return true;
    }

    public Duration durataTotale() {
        Duration somma = Duration.ZERO;
        for (int i = 0; i < quantiBrani; i++) {
            somma = somma.plus(canzoni[i].getDurata());
        }
        return somma;
    }

    @Override
    public String toString() {
        String descrizione = "Playlist " + nome + ", " + quantiBrani + " brani, in " + stato;
        Canzone corrente = getCanzone(numeroCanzone);
        if (corrente != null) {
            descrizione += " sul brano " + corrente.getTitolo() + " di " + corrente.getArtista();
        }
        return descrizione;
    }
}