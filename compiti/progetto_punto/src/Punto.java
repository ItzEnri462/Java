public class Punto {
    private double x;
    private double y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double distanza(Punto p) {
        return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
    }

    public Punto puntoMedio(Punto p) {
        Punto m = new Punto();
        m.x = (this.x + p.x) / 2;
        m.y = (this.y + p.y) / 2;
        return m;
    }

    public void ruota(double a) {
        Punto k = new Punto();
        k.x = this.x * Math.cos(a) - this.y * Math.sin(a);
        k.y = this.x * Math.sin(a) + this.y * Math.cos(a);
        this.x = k.x;
        this.y = k.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
