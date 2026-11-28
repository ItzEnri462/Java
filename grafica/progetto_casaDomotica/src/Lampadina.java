import graphics.Color;
import graphics.Ellipse;

public class Lampadina {
    private int potenza;
    private Color colore;
    private int intensita;
    private boolean accesa;
    private String nome;
    private int x;
    private int y;
    private int raggio;

    public Lampadina(int potenza){
        this.potenza = potenza;
        if (this.potenza < 1 || this.potenza > 100) {
            this.potenza = 10;
        }
        this.colore = new Color(255, 239, 148);
        this.intensita = 100;
        this.accesa = false;
        this.nome = "";
        this.raggio = this.potenza * 2;
    }

    public Lampadina(int potenza, int x, int y){
        this.potenza = potenza;
        if (this.potenza < 1 || this.potenza > 100) {
            this.potenza = 10;
        }
        this.colore = new Color(255, 239, 148);
        this.intensita = 100;
        this.accesa = false;
        this.nome = "";
        this.x = x;
        this.y = y;
        this.raggio = this.potenza * 2;
    }

    public Lampadina(String nome, int x, int y){
        this.potenza = 35;
        this.colore = new Color(255, 239, 148);
        this.intensita = 100;
        this.accesa = false;
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.raggio = this.potenza * 2;
    }

    public Lampadina(Lampadina l) {
        this.potenza = l.potenza;
        this.colore = l.colore;
        this.intensita = l.intensita;
        this.accesa = l.accesa;
        this.nome = l.nome;
        this.raggio = l.raggio;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPotenza() {
        return this.potenza;
    }

    public int getIntensita() {
        return this.intensita;
    }


    public void accendi(){
        this.accesa = true;
    }

    public void aumentaLuminosita(){
        this.intensita +=10;
        if (this.intensita > 100){
            this.intensita = 100;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColore() {
        return colore;
    }

    public void aumentaPotenza(int valore) {
        if (valore > 100 )
            this.potenza = 100;
        else if (valore < 1)
            this.potenza = 1;
    }

    public void cambiaColore(Color c) {
    this.colore = colore;
    }

    public Ellipse disegna() {
        return new Ellipse(x, y, raggio, raggio);

    }

    public void nascondi(Ellipse e) {
        e.grow(-raggio, -raggio);
    }

    @Override
    public String toString() {
        return "Lampadina{" +
                "potenza=" + potenza +
                ", colore='" + colore + '\'' +
                ", intensita=" + intensita +
                ", accesa=" + accesa +
                ", nome='" + nome + '\'' +
                '}';
    }
}
