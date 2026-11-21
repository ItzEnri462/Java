import graphics.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Picture p = new Picture("images/Planimetria.jpg");
        p.draw();
        System.out.println("Quante lampadine al massimo ci saranno?");
        int nLampadine = s.nextInt();
        SistemaDomotico sistema = new SistemaDomotico(nLampadine);
        int potenzaDefault = 35;
        int scelta;
        do {
            System.out.println("Opzioni disponibili: \n 1. Aggiungi una lampadina\n 2. Togli una lampadina\n 3. Aumenta la potenza di una lampadina\n 4. Aumenta la luminosità di una lampadina\n 5. Cambia il colore di una lampadina\n 6. Leggi le informazioni di una lampadina\n 7. Accendi una o più lampadine \n 8. Spegni una o più lampadine\n 9. Nascondi una o più lampadine\n 10. Mostra una o più lampadine");

            int opzione = s.nextInt();
            switch (opzione) {
                case 1:
                    System.out.println("Inserisci le coordinate della tua lampadina");
                    int x = s.nextInt();
                    int y = s.nextInt();
                    System.out.println("Inserisci il nome");
                    String n = s.nextLine();
                    Lampadina l = new Lampadina(n, x, y);
                    sistema.add(l);
                    sistema.disegnaLampadina();
                    break;
            }

            scelta = 2;
        } while (scelta != 0);
    }
}