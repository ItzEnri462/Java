
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int continua;
        Punto a = new Punto();
        Punto b = new Punto();
        Rettangolo r = new Rettangolo();
        boolean creato = false;
        do {
            System.out.println("Digitare il numero corrispondente alla scelta per continuare: \n1. Creare un nuovo rettangolo nel piano cartesiano \n2. Calcolarne il perimetro \n3. Calcolarne l'area");
            int scelta = s.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Stai creando un nuovo rettangolo (partendo da due punti). \n");
                    System.out.println("Inserire la x del primo punto: ");
                    double x = s.nextDouble();
                    System.out.println("Inserire la y del primo punto: ");
                    double y = s.nextDouble();
                    a.setX(x);
                    a.setY(y);
                    System.out.println("Inserire la x del secondo punto: ");
                    x = s.nextDouble();
                    System.out.println("Inserire la y del secondo punto: ");
                    y = s.nextDouble();
                    b.setX(x);
                    b.setY(y);
                    r.setPunti(a, b);
                    creato = true;
                    break;
                case 2:
                    if (creato) {
                        System.out.println("Il perimetro del rettangolo precedentemente creato è: " + r.calcolaPerimetro());
                    }
                    else {
                        System.out.println("Non hai ancora creato il rettangolo.");
                    }
                    break;
                case 3:
                    if (creato) {
                        System.out.println("L'area del rettangolo precedentemente creato è: " + r.calcolaArea());
                    }
                    else {
                        System.out.println("Non hai ancora creato il rettangolo.");
                    }
                    break;
                default:
                    System.out.println("Il numero selezionato non è valido.");
            }
            System.out.println("Digitare 1 per continuare a interagire, tutto il resto per terminare il programma");
            continua = s.nextInt();
        } while (continua == 1);
    }
}