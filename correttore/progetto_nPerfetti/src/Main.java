import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    nPerfetto numero = new nPerfetto(s.nextInt());
        System.out.println(numero.toString());
    }
}