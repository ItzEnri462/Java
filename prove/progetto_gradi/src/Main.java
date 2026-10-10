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
        Scanner s = new Scanner(System.in);
        Angolo a = null;
        Angolo b = null;
        int continua;
        do {
            System.out.println("Scelte disponibili: \n1. Crea un nuovo angolo \n2. Somma due angoli \n3. Sottrai due angoli");
            int scelta = s.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Scegli se creare l'angolo 1 o l'angolo 2:");
                    int t = s.nextInt();
                    if (t == 1)
                        a = creaAngolo();
                    else if(t == 2)
                        b = creaAngolo();
                    else
                        System.out.println("Scelta non valida.");
                    break;

            }

        } while (continua == 1);

    }
}