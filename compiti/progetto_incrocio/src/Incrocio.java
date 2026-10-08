public class Incrocio {
    Semaforo nord;
    Semaforo sud;
    Semaforo ovest;
    Semaforo est;

    public Incrocio() {
        this.nord = new Semaforo();
        this.sud = new Semaforo();
        this.ovest = new Semaforo();
        this.est = new Semaforo();
    }

    public void accendi() {
        this.nord.accendi();
        this.sud.accendi();
        this.ovest.accendi();
        this.est.accendi();
        for (int i = 0; i < 2; i++) {
            this.sud.avanza();
            this.nord.avanza();
        }
    }

    public void spegni() {
        this.nord.spegni();
        this.sud.spegni();
        this.ovest.spegni();
        this.est.spegni();
    }

    public void avanza(Character strada) {
        strada = Character.toUpperCase(strada);
        Semaforo scelta = null;
        Semaforo p1 = null;
        Semaforo p2 = null;

        switch (strada) {
            case 'N':
                scelta = nord;
                p1 = est;
                p2 = ovest;
                break;
            case 'S':
                scelta = sud;
                p1 = est;
                p2 = ovest;
                break;
            case 'O':
                scelta = ovest;
                p1 = nord;
                p2 = sud;
                break;
            case 'E':
                scelta = est;
                p1 = nord;
                p2 = sud;
                break;
            default:
                return;
        }
        if (scelta.isAcceso() && scelta.getColore().equals("ROSSA")) {
            if ((p1.isAcceso() && p1.getColore().equals("VERDE")) || (p2.isAcceso() && p2.getColore().equals("VERDE"))) {
                return;
            }
        }
        scelta.avanza();
    }

    public boolean isAcceso() {
        return nord.isAcceso() || sud.isAcceso() || ovest.isAcceso() || est.isAcceso();
    }

    public String getColore(Character scelta) {
        scelta = Character.toUpperCase(scelta);

        switch (scelta) {
            case 'N':
                return this.nord.getColore();
            case 'S':
                return this.sud.getColore();
            case 'O':
                return this.ovest.getColore();
            case 'E':
                return this.est.getColore();
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        String n = " ";
        String s = " ";
        String o = " ";
        String e = " ";

        if (nord.isAcceso()) {
            n = nord.getColore().substring(0, 1);
        }

        if (sud.isAcceso()) {
            s = sud.getColore().substring(0, 1);
        }

        if (ovest.isAcceso()) {
            o = ovest.getColore().substring(0, 1);
        }

        if (est.isAcceso()) {
            e = est.getColore().substring(0, 1);
        }
        return
                "          | N |\n" +
                "          |   |\n" +
                "          | " + n + " |\n" +
                "--------------------------\n" +
                "  O " + o + "                 " + e + " E\n" +
                "--------------------------\n" +
                "          | " + s + " |\n" +
                "          |   |\n" +
                "          | S |";
    }
}