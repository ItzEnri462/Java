public class Playlist {
    private String nome;
    private int n_brani;
    private int branoCorrente;
    private String stato;
    private Canzone[] canzoni;

    public Playlist(String nome, Canzone[] canzoni) {
        int n_brani = canzoni.length;
        if (n_brani > 100)
            n_brani = 100;
        this.canzoni = new Canzone[n_brani];
        for (int i = 0; i < n_brani; i++) {
            this.canzoni[i] = canzoni[i];
        }
        this.nome = nome;
        branoCorrente = 0;
        stato = "STOP";
    }

    public Playlist(Playlist p) {
        this.nome = p.nome;
        this.n_brani = p.n_brani;
        this.branoCorrente = p.branoCorrente;
        this.stato = p.stato;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantiBrani() {
        return n_brani;
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
            branoCorrente = 1;
        }
        stato = "STOP";
    }

    public void branoSuccessivo() {
        if (branoCorrente == n_brani) {
            branoCorrente = 1;
        } else {
            branoCorrente++;
        }
    }

    public void branoPrecedente() {
        if (branoCorrente == 1) {
            branoCorrente = n_brani;
        } else {
            branoCorrente--;
        }
    }

    public String toString() {
        return "Playlist " + nome + ", " + n_brani + " brani, in "
                + stato + " sul brano " + branoCorrente;
    }
}