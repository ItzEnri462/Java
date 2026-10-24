public class Vettore {
    Punto o;
    Punto v;

    public Vettore(Punto o, Punto v) {
        this.o = o;
        this.v = v;
    }

    public Vettore() {
    }

    public Punto getO() {
        return o;
    }

    public Punto getV() {
        return v;
    }

    public double calcolaLunghezza() {
        return Math.sqrt(Math.pow(v.getX() - o.getX(), 2) + Math.pow(v.getY() - o.getY(), 2));
    }

    public void spostaOrigine(Punto p) {
        this.o.setX(p.getX());
        this.o.setY(p.getY());
    }

    public boolean verificaOrigine(Vettore v2) {
        return this.o.getX() == v2.o.getX() && this.o.getY() == v2.o.getY();
    }
}
