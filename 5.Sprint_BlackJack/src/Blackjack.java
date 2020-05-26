
import java.util.ArrayList;
import java.util.Collections;
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
        
        System.out.println("Siirrytään jakajaan");
        this.jakajanKasi = new JakajanKasi(pakka);
    }
}
