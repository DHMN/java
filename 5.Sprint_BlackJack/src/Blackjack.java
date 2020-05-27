
import java.util.Scanner;

public class Blackjack {

    private Scanner sc;
    private Korttipakka pakka;
    private PelaajanKasi pelaajanKasi;
    private JakajanKasi jakajanKasi;

    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        bj.kaynnista();
    }

    public void kaynnista() {
        this.pakka = new Korttipakka();
        this.pelaajanKasi = new PelaajanKasi(pakka);

        if (pelaajanKasi.onkoBlackjack(pelaajanKasi.selvitaSumma(0)) == false) {
            this.jakajanKasi = new JakajanKasi(pakka);
            kasienVertailu(pelaajanKasi.selvitaSumma(0), jakajanKasi.selvitaSumma(0));
        }
    }

    public void kasienVertailu(int pelaajanArvo, int jakajanArvo) {
        if ((pelaajanArvo > jakajanArvo && pelaajanArvo < 21 && jakajanArvo < 21) || (jakajanArvo > 21) || (pelaajanArvo == 21)) {
            System.out.println("Voitit pelin.");
        } else if (pelaajanArvo < jakajanArvo || jakajanArvo == 21 || jakajanArvo == pelaajanArvo || pelaajanArvo > 21) {
            System.out.println("Jakaja voitti pelin.");
        }
    }
}
