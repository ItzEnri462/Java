import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Semaforo s = new Semaforo();
        Scanner sc = new Scanner(System.in);
        int continua;
        do {
            System.out.println("Scelte a disposizione: \n1. Accendi tutti i semafori \n2. Spegni tutti i semafori \n3. Avanza lo stato di un semaforo \n4. Verifica che un semaforo sia acceso o spento \n5. Ritorna il colore di un semaforo \n6. Verifica lo stato dell'incrocio");
            int scelta = sc.nextInt();

        } while (continua == 1);
    }
}