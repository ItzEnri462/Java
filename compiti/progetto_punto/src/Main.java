import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Punto a = null;
        Punto b = null;
        Punto m = null;
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
                    break;
                case 2:
                    b = new Punto(a);
                    break;
                case 3:
                    System.out.println("La distanza tra i due punti è: " + a.distanza(b));
                    break;
                case 4:
                    System.out.println("Calcolato il punto medio tra i due punti");
                    m = a.puntoMedio(b);
                    break;
                case 5:
                    System.out.println("Inserisci l'angolo di cui ruotare il punto");
                    double alpha = s.nextDouble();
                    System.out.println("Hai ruotato il punto a");
                    a.ruota(alpha);
                    break;
                case 6:
                    int sel;
                    System.out.println("Scegli il punto: \n1. A (originale) \n2. B (copia) \n3. M (punto medio)");
                    sel = s.nextInt();
                    if (sel == 1) {
                        System.out.println(a.toString());
                    } else if (sel == 2) {
                        System.out.println(b.toString());
                    } else if (sel == 3) {
                        System.out.println(m.toString());
                    } else
                        System.out.println("Scelta non valida");
                    break;
            }
            System.out.println("Digitare 1 per continuare a interagire, tutto il resto per smettere");
            continua = s.nextInt();
        } while (continua == 1);
    }
}
