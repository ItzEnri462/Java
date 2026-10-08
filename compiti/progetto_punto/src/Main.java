import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Punto a = null;
        Punto b = null;
        Scanner s = new Scanner(System.in);
        int continua;
        do {
            int scelta;
            boolean creato = false;
            System.out.println("Scelte disponibili: \n1. Creare un nuovo punto \n2. Copiare il punto precedentemente creato in un nuovo punto \n3. Calcolare la distanza tra due punti (la copia e il sovrascritto) \n4. Calcolare il punto medio tra due punti (la copia e il sovrascritto) \n5. Ruota il punto originale rispetto all'origine \n6. ritorna le coordinate del punto scelto in formato P(x,y)");
            scelta = s.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci la coordinata x");
                    double x = s.nextDouble();
                    System.out.println("Inserisci la coordinata y");
                    double y = s.nextDouble();
                    a = new Punto(x, y);
                    creato = true;
                    break;
            }

        } while (continua == 1);
    }
}
