import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Punto creaPunto() {
        Scanner s = new Scanner(System.in);
        System.out.println("inserire la coordinata X");
        Punto A = new Punto();
        A.setX(s.nextDouble());
        System.out.println("Inserire la coordinata Y");
        A.setY(s.nextDouble());
        return A;
    }

    public static Vettore creaVettore() {
        System.out.println("Stai creando un vettore: ");
        Punto origine = creaPunto();
        Punto vertice = creaPunto();
        return new Vettore(origine, vertice);
    }

    public static void main(String[] args) {

        Vettore v1 = null;
        Vettore v2 = null;

        int continua;
        do {
            System.out.println("scelte disponibili: \n1. Crea il vettore v1 \n2. Crea il vettore v2 \n3.Visualizza le coordinate dei vettori creati \n4. Calcola la lunghezza di uno dei due vettori \n5. Sposta l'origine di un vettore \n6. Verifica se i due vettori hanno origine uguale\n");
            Scanner s = new Scanner(System.in);
            int scelta = s.nextInt();
            switch (scelta) {
                case 1:
                    v1 = creaVettore();
                    break;
                case 2:
                    v2 = creaVettore();
                case 3:
                    System.out.println("Digitare 1 se vuoi calcolare la lunghezza di v1, 2 per la lunghezza di v2.");
                    int vScelto = s.nextInt();
                    if (v1 != null && vScelto == 1) {
                        System.out.println(v1.calcolaLunghezza());
                    } else if (v2 != null && vScelto == 2) {
                        System.out.println(v2.calcolaLunghezza());
                    } else {
                        System.out.println("Il numero inserito non è valido oppure il vettore scelto non è stato creato.");
                    }
                    break;
                case 4:
                    System.out.println("Digitare 1 se vuoi spostare l'origine di v1, 2 per l'origine di v2.");
                    vScelto = s.nextInt();
                    System.out.println("Ora inserisci il punto che sostituirà l'origine: ");
                    Punto sostituto = creaPunto();
                    if (v1 != null && vScelto == 1) {
                        v1.spostaOrigine(sostituto);
                    } else if (v2 != null && vScelto == 2) {
                        v2.spostaOrigine(sostituto);
                    } else {
                        System.out.println("Il numero inserito non è valido oppure il vettore scelto non è stato creato.");
                    }
                    break;
                case 5:
                    if (v1 != null && v2 != null){
                        if (v1.verificaOrigine(v2))
                            System.out.println("I due vettori hanno origine uguale");
                        else {
                            System.out.println("I due vettori hanno origini diverse");
                        }
                    } else {
                        System.out.println("Non hai creato entrambi i vettori.");
                    }
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
            System.out.println("Vuoi continuare a interagire? premi 0 per interrompere, qualsiasi altro numero per continuare");
            continua = s.nextInt();
        } while (continua != 0);
    }
}