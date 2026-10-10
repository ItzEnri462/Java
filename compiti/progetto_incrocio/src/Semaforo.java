public class Semaforo {
    private boolean acceso;
    private String colore;

    public Semaforo() {
        this.acceso = false;
        this.colore = "VERDE";
    }

    public void accendi() {
        this.acceso = true;
        this.colore = "VERDE";
    }

    public void spegni() {
        this.acceso = false;
    }

    public void toggle() {
        if (this.acceso) {
            spegni();
        } else {
            accendi();
        }
    }

    public void avanza() {
        if (this.acceso) {
            if (this.colore.equals("VERDE")) {
                this.colore = "GIALLA";
            } else if (this.colore.equals("GIALLA")) {
                this.colore = "ROSSA";
            } else if (this.colore.equals("ROSSA")) {
                this.colore = "VERDE";
            }
        }
    }

    public boolean isAcceso() {
        return this.acceso;
    }

    public String getColore() {
        if (this.acceso) {
            this.colore.equals("GIALLA");
            return this.colore;
        }
        return "";
    }

    @Override
    public String toString() {
        if (this.acceso) {
            return "Il semaforo è acceso sul " + this.colore;
        } else {
            return "Il semaforo è spento";
        }
    }
}