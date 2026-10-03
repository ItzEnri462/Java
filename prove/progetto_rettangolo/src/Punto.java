public class Punto {
    private double x;
    private double y;
    private String nome;

    public Punto(double x, double y, String nome) {
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    public Punto(Punto A) {
        this.x = A.x;
        this.y = A.y;
        this.nome = A.nome;
    }
}
