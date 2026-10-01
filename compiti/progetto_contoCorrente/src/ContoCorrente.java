public class ContoCorrente {
    private String nome;
    private String cognome;
    private String codice;
    private double saldo;

    public ContoCorrente(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
    }

    public double preleva(double n) {
        if (n >= 0 && this.saldo - n >= n) {
            this.saldo -= n;
        }
        return this.saldo;
    }

    public double deposita(double n) {
        if (n >= 0) {
            this.saldo += n;
        }
        return this.saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getCodice() {
        return this.codice;
    }

    public String getNominativo() {
        return this.cognome + " " + this.cognome;
    }

    @Override
    public String toString() {
        return "Nominativo: " + this.getNominativo() + ", Codice: " + this.codice + ", Saldo: " + this.saldo;
    }
}
