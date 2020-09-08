
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        int jakajanKasi = 0;
        int muuttuja = 0;

        Scanner sc = new Scanner(System.in);
        Korttipakka korttipakka = new Korttipakka(1);
        PelaajanKasi pelaajanKasi = new PelaajanKasi();

        korttipakka.sekoita();
        System.out.println("Aloitetaan peli");
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());
        System.out.println("Pelaajan käden yhteissumma: " + pelaajanKasi.selvitaSumma());

        while (pelaajanKasi.selvitaSumma() < 21) {
            System.out.println("\nHaluatko nostaa uuden kortin? k/e");
            String vastaus = sc.nextLine();

            if (vastaus.equals("k") && pelaajanKasi.selvitaSumma() < 21) {
                pelaajanKasi.otaKortti(korttipakka.jaaKortti());
                pelaajanKasi.selvitaSumma();
                System.out.println("Pelaajan käden yhteissumma: " + pelaajanKasi.selvitaSumma());

            } else if (vastaus.equals("e")) {
                break;

            } else {
                System.out.println("Väärä vastaus! yritä uudelleen!");
            }
        }

        while (true) {

            if (jakajanKasi < 15 && pelaajanKasi.selvitaSumma() <= 21) {
                System.out.println("\nJakaja nosti kortin " + korttipakka.pakka.get(0));

                muuttuja = korttipakka.jaaKortti().getArvo();

                if (muuttuja > 1 && muuttuja < 11) {
                    jakajanKasi += muuttuja;
                    //System.out.println("Tässä oli 2-10 numero");
                }
                if (muuttuja > 10 && muuttuja < 14) {
                    jakajanKasi += 10;
                    //System.out.println("Tästä pitäisi tulla 10");
                }
                if (muuttuja == 14) {
                    if ((muuttuja + jakajanKasi) > 21) {
                        jakajanKasi++;
                    } else {
                        jakajanKasi += 11;
                    }
                }

                //jakajanKasi += muuttuja;
                System.out.println("Jakajan käden yhteissumma: " + jakajanKasi);

            } else {
                break;
            }
        }

        if (pelaajanKasi.selvitaSumma() <= 21) {

            if (jakajanKasi < pelaajanKasi.selvitaSumma() || jakajanKasi > 21) {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi);
                System.out.println("\nPelaaja voittaa!");

            } else if (jakajanKasi > pelaajanKasi.selvitaSumma() && jakajanKasi <= 21) {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi);
                System.out.println("\nJakaja voittaa!");

            } else {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi);
                System.out.println("\nJakaja voittaa!");
            }

        } else {
            System.out.println("\nJakaja voittaa");
        }
    }
}
