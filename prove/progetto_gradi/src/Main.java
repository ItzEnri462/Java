import java.util.Scanner;

public class Main {

    public static Angolo creaAngolo() {
        Angolo a = null;
        System.out.println("Inserisci i gradi:");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        a.setGradi(n);
        System.out.println("Inserisci i minuti");
        n = s.nextInt();
        a.setMinuti(n);
        System.out.println("Inserisci i secondi");
        n = s.nextInt();
        a.setSecondi(n);
        return a;
    }

    public static void main(String[] args) {

    }
}