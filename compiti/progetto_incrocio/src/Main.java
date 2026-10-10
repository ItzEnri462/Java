import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Incrocio i = new Incrocio();
        Scanner sc = new Scanner(System.in);
        int continua;
        do {
            System.out.println("Scelte a disposizione: \n1. Accendi tutti i semafori \n2. Spegni tutti i semafori \n3. Avanza lo stato di un semaforo \n4. Verifica l'incrocio sia acceso o spento \n5. Ritorna il colore di un semaforo \n6. Verifica lo stato dell'incrocio");
            int scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Hai acceso l'incrocio");
                    i.accendi();
                    break;
                case 2:
                    System.out.println("Hai spento l'incrocio");
                    i.spegni();
                    break;
                case 3:
                    System.out.println("Inserisci il semaforo da avanzare (N, S, O, E)");
                    Character s = sc.next().charAt(0);
                    i.avanza(s);
                    break;
                case 4:
                    if (i.isAcceso())
                        System.out.println("L'incrocio ha almeno un semaforo acceso (è acceso)");
                    else
                        System.out.println("L'incrocio è spento");
                    break;
                case 5:
                    System.out.println("Inserisci il semaforo di cui controllare il colore");
                    Character semaforo = sc.next().charAt(0);
                    System.out.println("Il semaforo " + semaforo + " è " + i.getColore(semaforo));
                    break;
                case 6:
                    System.out.println(i.toString());
                default:
                    System.out.println("scelta non valida");
            }
            System.out.println("Digitare 1 per continuare a interagire, tutto il resto per smettere");
            continua = sc.nextInt();
        } while (continua == 1);
    }
}