
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Korttipakka p = new Korttipakka();
        PelaajanKasi k = new PelaajanKasi(p);
            
        System.out.println("Haluatko pelata? k/e");
        String vastaus = lukija.nextLine();
        if (vastaus.equals("k")) {

            System.out.println(k);
            System.out.println("Haluatko uuden kortin? k/e");
            vastaus = lukija.nextLine();
                while (true) {
                    if (vastaus.equals("k")) {
                        
                        //k.otaKortti();
                    }
                }
        }
        
    }
    private ArrayList<Kortti> kortit;

    public Blackjack() {
        this.kortit = kortit;

    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }

    public void kaynnista() {

        while (true) {

        }
    }

    public void sekoita() {
        for (int i = 0; i < 52; ++i) {

        }

        Collections.shuffle(kortit);
    }
}
