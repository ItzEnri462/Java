import graphics.Color;
import graphics.Ellipse;

public class Lampadina {
    private int potenza;
    private Color colore;
    private int intensita;
    private boolean accesa;
    private String nome;
    Ellipse lampada;

    public Lampadina(int potenza){
        this.potenza = potenza;
        if (this.potenza < 1 || this.potenza > 100) {
            this.potenza = 10;
        }
        this.colore = new Color(255, 239, 148);
        this.intensita = 100;
        this.accesa = false;
        this.nome = "";
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
        lampada = new Ellipse(x,y, potenza * 2, potenza * 2);
        lampada.setColor(this.colore);
        lampada.fill();
    }

    public Lampadina(Lampadina l) {
        this.potenza = l.potenza;
        this.colore = l.colore;
        this.intensita = l.intensita;
        this.accesa = l.accesa;
        this.nome = l.nome;
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
