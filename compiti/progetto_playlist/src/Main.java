import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Canzone c1 = new Canzone("Suspicious Minds", "Elvis Presley", Duration.ofMinutes(4).plusSeconds(22));
        Canzone c2 = new Canzone("Let It Be","The Beatles", Duration.ofMinutes(4).plusSeconds(3));
        Canzone c3 = new Canzone("Hotel California","Eagles",  Duration.ofMinutes(6).plusSeconds(30));

        Canzone[] braniIniziali = {c1, c2};
        Playlist playlist = new Playlist("Rock Classico", braniIniziali);
        playlist.add(c3);

        int scelta = 0;
        do {
            System.out.println("\n--- MENU PLAYLIST ---");
            System.out.println("1. Mostra stato playlist");
            System.out.println("2. Play");
            System.out.println("3. Pause");
            System.out.println("4. Stop");
            System.out.println("5. Brano successivo");
            System.out.println("6. Brano precedente");
            System.out.println("7. Mostra durata totale");
            System.out.println("8. Aggiungi canzone");
            System.out.println("9. Esci");
            System.out.print("Scelta: ");

            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1:
                        System.out.println(playlist.toString());
                        break;
                    case 2:
                        playlist.play();
                        System.out.println("Riproduzione avviata.");
                        break;
                    case 3:
                        playlist.pause();
                        System.out.println("Riproduzione in pausa.");
                        break;
                    case 4:
                        playlist.stop();
                        System.out.println("Riproduzione interrotta.");
                        break;
                    case 5:
                        playlist.branoSuccessivo();
                        System.out.println("Passato al brano successivo.");
                        break;
                    case 6:
                        playlist.branoPrecedente();
                        System.out.println("Tornato al brano precedente.");
                        break;
                    case 7:
                        Duration durata = playlist.durataTotale();
                        System.out.println("Durata totale: " + durata.toMinutes() + " minuti e " + durata.toSecondsPart() + " secondi.");
                        break;
                    case 8:
                        System.out.print("Titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.print("Artista: ");
                        String artista = scanner.nextLine();
                        System.out.print("Minuti: ");
                        long minuti = scanner.nextLong();
                        System.out.print("Secondi: ");
                        long secondi = scanner.nextLong();
                        scanner.nextLine();
                        Canzone nuova = new Canzone(titolo, artista, Duration.ofMinutes(minuti).plusSeconds(secondi));
                        if (playlist.add(nuova)) {
                            System.out.println("Canzone aggiunta con successo.");
                        } else {
                            System.out.println("Impossibile aggiungere la canzone.");
                        }
                        break;
                    case 9:
                        System.out.println("Uscita in corso...");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } else {
                scanner.nextLine();
                scelta = 0;
            }
        } while (scelta != 9);

        scanner.close();
    }
}