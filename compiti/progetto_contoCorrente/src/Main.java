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
                    System.out.println("Inserire la somma da depositare: ");
                    double n = s.nextDouble();
                    conto.deposita(n);
                    break;
                case 3:
                    System.out.println("Inserire la somma da prelevare: ");
                    double p = s.nextDouble();
                    conto.preleva(p);
                    break;
                case 4:
                    System.out.println("Il saldo attuale è di: " + conto.getSaldo());
                    break;
                case 5:
                    System.out.println("Codice conto: " + conto.getCodice());
                    break;
                case 6:
                    System.out.println("Nominativo: " + conto.getNominativo());
                    break;
                case 7:
                    System.out.println(conto.toString());
                    break;
                default:
                    System.out.println("Il numero inserito non è valido");
            }
            System.out.println("Vuoi continuare a interagire? \n 1. Si, no per qualunque altra cosa");
            continua = s.nextInt();
        } while (continua == 1);
    }
}