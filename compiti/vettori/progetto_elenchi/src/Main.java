import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] v = new int[10];
        System.out.println("Quanti elementi vuoi inserire? (max 10)");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n > 10)
            n = 10;

        int[] pari = new int[n];
        int[] dispari = new int[n];

        System.out.println("Inserisci i numeri");
        for (int i = 0; i < n; i++) {
            v[i] = s.nextInt();
        }

        int contapari = 0;
        int contadispari = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] % 2 == 0) {
                pari[contapari] = v[i];
                contapari++;
            }
            else {
                dispari[contadispari] = v[i];
                contadispari++;
            }
        }
        System.out.println("Ci sono " + contapari + " elementi pari e sono: ");
        for (int i = 0; i < contapari; i++) {
            System.out.println(pari[i] + " ");
        }

        System.out.println("Ci sono " + contadispari + " elementi dispari e sono: ");
        for (int i = 0; i < contadispari; i++) {
            System.out.println(dispari[i] + " ");
        }
    }
}