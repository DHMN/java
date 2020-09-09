
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Korttipakka korttipakka = new Korttipakka(1);
        PelaajanKasi pelaajanKasi = new PelaajanKasi();
        PelaajanKasi jakajanKasi = new PelaajanKasi();

        korttipakka.sekoita();

        System.out.println("Aloitetaan peli");

        System.out.println("Pelaaja nosti kortin " + korttipakka.pakka.get(0));
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());
        System.out.println("Pelaaja nosti kortin " + korttipakka.pakka.get(0));
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());

        System.out.println("Pelaajan käden yhteissumma: " + pelaajanKasi.selvitaSumma());

        while (pelaajanKasi.selvitaSumma() < 21) {
            System.out.println("\nHaluatko nostaa uuden kortin? k/e");
            String vastaus = sc.nextLine();

            if (vastaus.equals("k") && pelaajanKasi.selvitaSumma() < 21) {
                System.out.println("Pelaaja nosti kortin " + korttipakka.pakka.get(0));
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

            if (pelaajanKasi.onkoBlackjack()) {
                break;

            } else if (jakajanKasi.selvitaSumma() < 15 && pelaajanKasi.selvitaSumma() <= 21) {
                //System.out.println("Jakaja nosti kortin " + pelaajanKasi.kortit.get(i));
                System.out.println("Jakaja nosti kortin " + korttipakka.pakka.get(0));
                jakajanKasi.otaKortti(korttipakka.jaaKortti());

                System.out.println("Jakajan käden yhteissumma: " + jakajanKasi.selvitaSumma());

            } else {
                break;
            }
        }

        if (pelaajanKasi.selvitaSumma() <= 21) {

            if (jakajanKasi.selvitaSumma() < pelaajanKasi.selvitaSumma() || jakajanKasi.selvitaSumma() > 21) {

                if (pelaajanKasi.selvitaSumma() == 21 && pelaajanKasi.kortit.size() == 2) {
                    System.out.println("\nPelaajalla BlackJack!");
                    System.out.println("\nPelaaja voittaa!");

                } else {
                    System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                    System.out.println("Jakajan käsi: " + jakajanKasi.selvitaSumma());
                    System.out.println("\nPelaaja voittaa!");
                }

            } else if (jakajanKasi.selvitaSumma() > pelaajanKasi.selvitaSumma() && jakajanKasi.selvitaSumma() <= 21) {

                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi.selvitaSumma());
                System.out.println("\nJakaja voittaa!");

            } else {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi.selvitaSumma());
                System.out.println("\nJakaja voittaa!");
            }

        } else {
            System.out.println("\nJakaja voittaa");
        }
    }
}
