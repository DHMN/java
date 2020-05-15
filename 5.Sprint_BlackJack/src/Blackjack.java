
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {

    private Scanner sc;
    private Korttipakka kortit;
    private PelaajanKasi pelaajanKasi;

    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        bj.kaynnista();

//        Scanner lukija = new Scanner(System.in);
//        
//        Korttipakka p = new Korttipakka();
//        PelaajanKasi k = new PelaajanKasi(p);
//            
//        System.out.println("Haluatko pelata? k/e");
//        String vastaus = lukija.nextLine();
//        if (vastaus.equals("k")) {
//
//            System.out.println(k);
//            System.out.println("Haluatko uuden kortin? k/e");
//            vastaus = lukija.nextLine();
//                while (true) {
//                    if (vastaus.equals("k")) {
//                        annaKorttiPelaajalle();
////                        k.otaKortti(new Kortti());
//                    }
//                }
//        }     
    }

    public Blackjack() {
        sc = new Scanner(System.in);
        this.kortit = new Korttipakka();
//        this.pelaajanKasi = new PelaajanKasi();

    }

    public static void annaKorttiPelaajalle() {
//        Kortti kortti = kortit.jaaKortti();
//        pelaajanKasi.otaKortti(kortti);
//        System.out.println("Sait kortin " + kortti);
    }

    public void kaynnista() {
        kortit.sekoita();
        annaKorttiPelaajalle();
        annaKorttiPelaajalle();

    }
//
//    public void sekoita() {
//        for (int i = 0; i < 52; ++i) {
//
//        }
//
//        Collections.shuffle(kortit);
//    }
}
