import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int continua;
        boolean creato = false;
        Dado d;
        
        do {
            System.out.println("Digitare il numero relativo all'azione per eseguira: \n1.Creare un nuovo dado da 6 facce \n2. Creare un dado con nFacce \n3. Copiare il dado \n4. Lanciare un dado \n5. Ritornare le informazioni di un dado");
            int scelta = s.nextInt();
            switch (scelta) {
                case 1:
                    d = new Dado();
                    System.out.println("Creato un nuovo dado da 6 facce");
                    creato = true;
                    break;
                case 2:
                    System.out.println("Inserisci il numero di facce:");
                    int n = s.nextInt();
                    d = new Dado(n);
                    System.out.println("Creato un nuovo dado da " + n + " facce");
                    creato = true;
                    break;
                case 3:
                    Dado copia;
                    if (creato) {
                        copia = new Dado(d);
                        System.out.println("Dado copiato");
                    }
                    else
                        System.out.println("Il dado da copiare non esiste");
            }
        } while (continua == 1);
    }
}