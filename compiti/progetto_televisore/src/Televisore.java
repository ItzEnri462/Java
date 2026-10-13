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
}
