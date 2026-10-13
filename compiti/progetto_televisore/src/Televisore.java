public class Televisore {
    int canaliTotali;
    int canale;
    boolean isAcceso;
    int volume;

    public Televisore() {
        this.canaliTotali = 999;
        this.isAcceso = false;
        this.volume = 0;
        this.canale = 1;
    }

    public int getVolume() {
        return volume;
    }

    public int getCanale() {
        return canale;
    }

    public boolean setVolume(int volume) {
        if (volume < 0 || volume > 100)
            return false;
        this.volume = volume;
        return true;
    }

    public boolean canaleSuccessivo() {
        if (!this.isAcceso)
            return false;
        if (canale == canaliTotali)
            canale = 1;
        else
            canale++;
        return true;
    }

    public boolean canalePrecedente() {
        if (!this.isAcceso)
            return false;
        if (canale == 1)
            canale = canaliTotali;
        else
            canale--;
        return true;
    }

    public boolean selezionaCanale(int canale) {
        if (canale < 1 || canale > canaliTotali)
            return false;
        this.canale = canale;
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        if (!isAcceso)
            return "Il televisore è spento.";
        return "Il televisore è acceso, sul canale " + this.canale + " e il volume a " + this.volume;
    }
}
