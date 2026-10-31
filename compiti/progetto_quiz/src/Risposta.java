public class Risposta {
    private String r;
    private Boolean isCorrect;

    public Risposta(String r, Boolean isCorrect) {
    }

    public Risposta(Risposta risposta) {
        this.r = risposta.r;
        this.isCorrect = risposta.isCorrect;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
