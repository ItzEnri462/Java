import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int continua;
        boolean creato = false;
        ContoCorrente conto = null;
        do {
            System.out.println("\nDigitare il numero relativo all'azione da eseguire: \n1. Creare un nuovo conto corrente \n2. Deposita denaro \n3. Preleva denaro \n4. Visualizza saldo attuale \n5. Visualizza codice del conto \n6. Visualizza nominativo correntista \n7. Visualizza informazioni complete");
            int scelta = s.nextInt();
            s.nextLine();
            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome del correntista: ");
                    String nome = s.nextLine();

                    System.out.print("Inserisci il cognome del correntista: ");
                    String cognome = s.nextLine();
                    System.out.print("Inserisci il codice del conto: ");
                    String codice = s.nextLine();
                    conto = new ContoCorrente(nome, cognome, codice);

                    System.out.println("Conto creato con successo per " + conto.getNominativo());
                    creato = true;
                    break;
                    case 2:

                    }

                } while (continua == 1);

                s.close();
            }
        }
    }
}