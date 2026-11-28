import graphics.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Picture p = new Picture("images/Planimetria.jpg");
        p.draw();
        int scelta;
        boolean giaCreato = false;
        SistemaDomotico sistema = null;
        SistemaDomotico sistemaDefault = new SistemaDomotico(15);
        String nome;
        do {
            System.out.println("Opzioni disponibili:");
            System.out.println("1. Aggiungi una lampadina a un secondo sistema domotico");
            System.out.println("2. Togli una lampadina");
            System.out.println("3. Aumenta la potenza di una lampadina");
            System.out.println("4. Aumenta la luminosità di una lampadina");
            //System.out.println("5. Cambia il colore di una lampadina");
            //System.out.println("6. Leggi le informazioni di una lampadina");
            System.out.println("7. Accendi una o più lampadine");
            System.out.println("8. Spegni una o più lampadine");
            //System.out.println("9. Nascondi una o più lampadine");
            //System.out.println("10. Mostra una o più lampadine");
            System.out.println("11. Mostra o nascondi il sistema domotico di default");

            int opzione = s.nextInt();
            int sistemaScelto;
            switch (opzione) {
                case 1:
                    if(sistema == null) {
                        System.out.println("Quante lampadine al massimo ci saranno?");
                        int nLampadine = s.nextInt();
                        sistema = new SistemaDomotico(nLampadine);
                    }

                    System.out.println("Inserisci le coordinate della tua lampadina");
                    int x = s.nextInt();
                    int y = s.nextInt();
                    System.out.println("Inserisci il nome");
                    String n = s.nextLine();
                    Lampadina l = new Lampadina(n, x, y);
                    sistema.add(l);
                    sistema.disegnaLampadina();
                    break;
                case 2:
                    if (sistema != null) {
                        System.out.println("Inserisci il nome della lampadina da rimuovere");
                        nome = s.nextLine();
                        sistema.togliLampadina(nome);
                    }
                    else {
                        System.out.println("Non hai ancora creato il sistema domotico secondario!");
                    }

                    break;
                case 3:

                    System.out.println("Digitare 1 per interagire con il sistema domotico di default, 2 per quello secondario");
                    sistemaScelto = s.nextInt();
                    if (sistemaScelto == 1) {
                        System.out.println("Inserisci il nome della lampadina di cui aumentare la potenza");
                        nome = s.nextLine();
                        System.out.println("Adesso inserisci la potenza che desideri impostare");
                        int valore = s.nextInt();
                        sistemaDefault.aumentaPotLampadina(valore, nome);
                    }
                    //else if (sistemaScelto == 2 && sistema != null) {
                    //System.out.println("Inserisci il nome della lampadina di cui aumentare la potenza");
                    //    nome = s.nextLine();
                    //    System.out.println("Adesso inserisci la potenza che desideri impostare");
                    //    int valore = s.nextInt();
                    //    sistema.aumentaPotLampadina(valore, nome);
                    //}
                    //else {
                    //    System.out.println("Non hai ancora creato il sistema domotico secondario!");
                    //}
                    break;
                case 4:
                    System.out.println("Digitare 1 per interagire con il sistema domotico di default, 2 per quello secondario");
                    sistemaScelto = s.nextInt();
                    if (sistemaScelto == 1) {
                        System.out.println("Inserisci il nome della lampadina a cui aumentare la luminosità");
                        nome = s.nextLine();
                        sistemaDefault.aumentaLumLampadina(nome);
                        System.out.println("Hai aumentato la luminosità della tua lampadina di 10. (valore max = 100, valore min = 1)");
                    }
                    //if (sistemaScelto == 2 && sistema != null) {
                    //    System.out.println("Inserisci il nome della lampadina a cui aumentare la luminosità");
                    //    nome = s.nextLine();
                    //    sistema.aumentaLumLampadina(nome);
                    //    System.out.println("Hai aumentato la luminosità della tua lampadina di 10. (valore max = 100, valore min = 1)");
                    //}
                    //else {
                    //    System.out.println("Non hai ancora creato il sistema domotico secondario!");
                    //}
                    break;
                case 5:
                    /**if (sistema != null) {
                     *
                     * }
                     * else {
                     * System.out.println("Non hai ancora creato il sistema domotico secondario!");
                     * }
                     * break;
                     *
                     *
                     */
                    break;
                case 6:
                    //
                    break;
                case 7:
                    System.out.println("Inserisci il nome della lampadina da accendere");
                    nome = s.nextLine();

                    break;
                case 8:
                    break;
                case 9:
                    //
                    break;
                case 10:
                    //
                    break;
                case 11:
                    break;
                default:

            }

            scelta = 2;
        } while (scelta != 0);
    }
}