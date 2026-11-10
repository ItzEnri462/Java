import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una data nel futuro (g, m ,a)");
        int g = s.nextInt();
        int m = s.nextInt();
        int a = s.nextInt();
        LocalDate oggi = LocalDate.now();
        LocalDate data = LocalDate.of(a, m, g);
        LocalDate d = oggi;
        int giorni = 0;
        while (!d.isEqual(data)) {
            d = d.plusDays(1);
            giorni++;
        }
        System.out.println("All'evento mancano " + giorni + " giorni");
    }
}