import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Le capitali europee");

        Risposta[] r1 = {
                new Risposta("Zurigo", false),
                new Risposta("Berna", true),
                new Risposta("Basilea", false),
                new Risposta("Ginevra", false)
        };
        Domanda d1 = new Domanda("Qual è la capitale della Svizzera?", r1);
        d1.setValore(2);
        quiz.add(d1);

        Risposta[] r2 = {
                new Risposta("Parigi", true),
                new Risposta("Lione", false),
                new Risposta("Marsiglia", false),
                new Risposta("Nizza", false)
        };
        Domanda d2 = new Domanda("Qual è la capitale della Francia?", r2);
        d2.setValore(3);
        quiz.add(d2);

        System.out.println("INFORMAZIONI INIZIALI");
        System.out.println(quiz);
        System.out.println("Domande totali: " + quiz.getQuanteDomande());
        System.out.println("Risposte date finora: " + quiz.getQuanteRisposte());

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nINIZIO SOMMINISTRAZIONE QUIZ");

        for (int i = 1; i <= quiz.getQuanteDomande(); i++) {
            Domanda corrente = quiz.getDomanda(i);
            System.out.println("\nDomanda " + i + " (Valore: " + corrente.getValore() + " punti):");
            System.out.println(corrente);
            System.out.print("Inserisci il numero della tua risposta (1-4): ");

            int scelta = scanner.nextInt();
            boolean esito = corrente.rispondi(scelta);

            if (esito) {
                System.out.println("--> Risposta corretta!");
            } else {
                System.out.println("--> Risposta errata! La risposta corretta era: " + corrente.getRispostaCorretta());
            }
        }

        System.out.println("\nRIEPILOGO FINALE");
        System.out.println("Risposte fornite: " + quiz.getQuanteRisposte() + " su " + quiz.getQuanteDomande());

        int[] nonDate = quiz.getDomandeNonDate();
        if (nonDate.length > 0) {
            System.out.print("Domande a cui non si è risposto: ");
            for (int id : nonDate) {
                System.out.print(id + " ");
            }
            System.out.println();
        } else {
            System.out.println("Tutte le domande hanno ricevuto una risposta.");
        }

        System.out.println("Punteggio finale ottenuto: " + quiz.getPunteggio() + " su " + quiz.getTotale() + " punti.");

        scanner.close();
    }
}
