
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Korttipakka korttipakka = new Korttipakka(1);
        PelaajanKasi pelaajanKasi = new PelaajanKasi();
        int jakajanKasi = 0;
        int yht = 0;

        //korttipakka.sekoita();
        System.out.println("Aloitetaan peli");
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());
        pelaajanKasi.otaKortti(korttipakka.jaaKortti());
//        pelaajanKasi.selvitaSumma();
        System.out.println("Pelaajan käden yhteissumma: " + pelaajanKasi.selvitaSumma());

        while (pelaajanKasi.selvitaSumma() < 21) {
            System.out.println("\nHaluatko nostaa uuden kortin. k/e");
            String vastaus = sc.nextLine();

            if (vastaus.equals("k") && pelaajanKasi.selvitaSumma() < 21) {
                pelaajanKasi.otaKortti(korttipakka.jaaKortti());
                pelaajanKasi.selvitaSumma();
                System.out.println("Pelaajan käden yhteissumma: " + pelaajanKasi.selvitaSumma());
            } else {
                break;
            }
        }

        System.out.println("Siirrytään jakajan käteen");

        while (true) {
            if (jakajanKasi < 15 && pelaajanKasi.selvitaSumma() < 21) {
                jakajanKasi = jakajanKasi + korttipakka.jaaKortti().getArvo();
                //System.out.println("\nJakaja nosti kortin " + korttipakka.jaaKortti().getArvo());// + " " + korttipakka.jaaKortti().getMaa());
                System.out.println("Jakajan käden yhteissumma: " + jakajanKasi);
            } else {
                break;
            }

        }
        if (pelaajanKasi.selvitaSumma() < 21) {

            if (jakajanKasi < pelaajanKasi.selvitaSumma()) {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi);
                System.out.println("\nPelaaja voittaa!");

            } else {
                System.out.println("\nPelaajan käsi: " + pelaajanKasi.selvitaSumma());
                System.out.println("Jakajan käsi: " + jakajanKasi);
                System.out.println("\nJakaja voittaa!");
            }
        } else {
            System.out.println("Jakaja voittaa");
        }
    }
}
