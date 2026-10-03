public class Rettangolo {
    private Punto a;
    private Punto b;
    private double perimetro;
    private double area;

    public Rettangolo(){
        this.perimetro = 0;
        this.area = 0;
        this.a = new Punto(0, 0);
        this.b = new Punto(0, 0);
    }

    public Rettangolo(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }

    public void setPunti(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }

    public double getBase() {
        double base = a.getX() - b.getX();
        if (base < 0)
            base = -base;
        return base;
    }

    public double getAltezza() {
        double altezza = a.getY() - b.getY();
        if (altezza < 0) {
            altezza = -altezza;
        }
        return altezza;
    }

    public double calcolaPerimetro() {
        this.perimetro = 2*getAltezza() + 2*getBase();
        return this.perimetro;
    }

    public double calcolaArea() {
        this.area = getAltezza()*getBase();
        return this.area;
    }
}
