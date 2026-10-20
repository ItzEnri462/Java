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

    public void effettuaTrasla(double dx, double dy) {
        double x = this.a.getX();
        this.a.setX(x + dx);
        double y = this.a.getY();
        this.a.setY(y + dy);
        x = this.b.getX();
        this.b.setX(x + dx);
        y = this.b.getY();
        this.b.setY(y + dy);
    }

    public boolean contenuto(Rettangolo r) {
        double xA_min = Math.min(this.a.getX(), this.b.getX());
        double xA_max = Math.max(this.a.getX(), this.b.getX());
        double xB_min = Math.min(this.b.getX(), this.b.getX());
        double xB_max = Math.max(this.b.getX(), this.b.getX());

        double yA_min = Math.min(r.a.getY(), r.b.getY());
        double yA_max = Math.max(r.a.getY(), r.b.getY());
        double yB_min = Math.min(r.b.getY(), r.b.getY());
        double yB_max = Math.max(r.b.getY(), r.b.getY());

    }
}
