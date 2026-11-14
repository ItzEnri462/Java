import graphics.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scelta = 0;
        do {
            System.out.println("Vuoi disegnare un cerchio (1), un rettangolo(2) o un'immagine(3) o uscire(0)?");
            scelta = in.nextInt();
            if (scelta == 1){
                System.out.println("Stai creando un cerchio, digitare la x e la y di partenza");
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println("Ora digitare larghezza e altezza");
                int w = in.nextInt();
                int h = in.nextInt();
                Ellipse e = new Ellipse(x, y, w, h);
                System.out.println("Vuoi crearlo pieno o solo contorno? (1 pieno, tutto il resto contorno");
                int sceltaTipo = in.nextInt();
                if (sceltaTipo != 1)
                    e.draw();
                else {
                    System.out.println("Scegli il colore tra i disponibili: \n" +
                            "1. RED\n2. GREEN\n3. BLUE\n4. WHITE\n5. GRAY\n6. BLACK");
                    int sceltaColore = in.nextInt();
                    Color colore;
                    switch (sceltaColore) {
                        case 1:
                            colore = Color.RED;
                            break;
                        case 2:
                            colore = Color.GREEN;
                            break;
                        case 3:
                            colore = Color.BLUE;
                            break;
                        case 4:
                            colore = Color.WHITE;
                            break;
                        case 5:
                            colore = Color.GRAY;
                            break;
                        case 6:
                            colore = Color.BLACK;
                            break;
                        default:
                            colore = Color.CYAN;
                    }
                    e.setColor(colore);
                    e.fill();
                }
            }
            else if (scelta == 2){
                Rectangle r = new Rectangle(50, 100, 200, 400);
                r.setColor(new graphics.Color(255, 0,0));
                r.fill();
            }
            else{
                Picture p = new Picture("java.png");
                p.draw();
                Text t = new Text(170, 450, "The Duke");
                t.setColor(new Color(255, 100, 0));
                t.grow(100, 40);
                t.draw();
            }
        } while (scelta != 0);
    }
}