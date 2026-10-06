public class GeneratoreAutoIncrementale {
    private String lettere;
    private String nCifre;
    private int ultimoValore;
    private int max;

    public GeneratoreAutoIncrementale(String a, int nCifre) {
        this.lettere = a;
        this.nCifre = nCifre;
        this.max = (int) Math.pow(10, nCifre) - 1;
        this.ultimoValore = 0;
    }

    public String genera() {
        if (ultimoValore > max)
            return "Codici esauriti";
        String f = "%0" + nCifre + "d";
        ultimoValore++;
        return lettere + String.format(f, ultimoValore);
    }

    @Override
    public String toString() {
        return "Prefisso: " + lettere + " ultimo valore generato: " + ultimoValore;
    }
}
