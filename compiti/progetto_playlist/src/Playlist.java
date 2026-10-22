public class Playlist {
    private String nome;
    private static final int MAX = 0;
    private int braniAttuali;
    private int branoCorrente;
    private String stato;
    private Canzone[] canzoni;

    public Playlist(String nome, Canzone[] canzoni) {
        int braniAttuali = canzoni.length;
        if (braniAttuali > MAX)
            braniAttuali = MAX;
        this.canzoni = new Canzone[MAX];

        System.arraycopy(canzoni, 0, this.canzoni, 0, braniAttuali);

        this.nome = nome;
        branoCorrente = 0;
        stato = "STOP";
    }

    public Playlist(Playlist p) {
        this.nome = p.nome;
        this.braniAttuali = p.braniAttuali;
        this.branoCorrente = p.branoCorrente;
        this.stato = p.stato;
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
        return braniAttuali;
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
        if (branoCorrente == braniAttuali) {
            branoCorrente = 1;
        } else {
            branoCorrente++;
        }
    }

    public void branoPrecedente() {
        if (branoCorrente == 1) {
            branoCorrente = braniAttuali;
        } else {
            branoCorrente--;
        }
    }

    public boolean add(Canzone c) {
        if (braniAttuali >= MAX) {
            return false;
        }
        canzoni[braniAttuali + 1] = c;
        return true;
    }

    public String toString() {
        return "Playlist " + nome + ", " + braniAttuali + " brani, in "
                + stato + " sul brano " + branoCorrente;
    }
}