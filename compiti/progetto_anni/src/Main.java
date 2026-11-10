import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int g, m ,a;
        System.out.println("Inserire giorno, mese e anno di nascita");
        g = s.nextInt();
        m = s.nextInt();
        a = s.nextInt();
        LocalDate nascita = LocalDate.of(a, m, g);
        LocalDate oggi = LocalDate.now();
        LocalDate d = nascita;
        int anni = oggi.getYear() - nascita.getYear();
        if (oggi.getMonthValue() < nascita.getMonthValue() || (oggi.getMonthValue() == nascita.getMonthValue() && oggi.getDayOfMonth() < nascita.getDayOfMonth()))
            anni--;
        System.out.println("Ad oggi, gli anni sono: " + anni);
    }
}