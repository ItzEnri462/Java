import graphics.*;
import graphics.Color;
import graphics.Rectangle;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scelta = 0;
        Ellipse e = null;
        Rectangle r = null;
        Picture p = null;
        do {
            System.out.println("Vuoi disegnare un cerchio (1), un rettangolo(2) o un'immagine(3), traslare una figura (se esistente)(4) o uscire(0)?");
            scelta = in.nextInt();
            if (scelta == 1){
                System.out.println("Stai creando un cerchio, digitare la x e la y di partenza");
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println("Ora digitare larghezza e altezza");
                int w = in.nextInt();
                int h = in.nextInt();
                e = new Ellipse(x, y, w, h);
                System.out.println("Vuoi crearlo pieno o solo contorno? (1 pieno, tutto il resto contorno)");
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
                System.out.println("Stai creando un rettangolo, digitare la x e la y di partenza");
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println("Ora digitare larghezza e altezza");
                int w = in.nextInt();
                int h = in.nextInt();
                r = new Rectangle(x, y, w, h);
                System.out.println("Vuoi crearlo pieno o solo contorno? (1 pieno, tutto il resto contorno)");
                int sceltaTipo = in.nextInt();
                if (sceltaTipo != 1)
                    r.draw();
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
                    r.setColor(colore);
                    r.fill();
                }
            }
            else if (scelta == 3){
                System.out.println("Stai creando un'immagine, digitare la x e la y di partenza");
                int x = in.nextInt();
                int y = in.nextInt();
                p = new Picture("images/gargantua.jpg");
                p.draw();
            }
            else {
                System.out.println("Stai per traslare una figura, seleziona se vuoi traslare il cerchio(1), rettangolo(2), immagine(3) o vuoi uscire(0)");
                int sceltaTrasl = in.nextInt();
                if (sceltaTrasl == 0)
                    scelta = sceltaTrasl;
                else if (sceltaTrasl == 1 && e != null) {
                    System.out.println("Digitare lo spostamento laterale e lo spostamnto verticale");
                    int dx = in.nextInt();
                    int dy = in.nextInt();
                    e.translate(dx, dy);
                }
            }
        } while (scelta != 0);
    }
}