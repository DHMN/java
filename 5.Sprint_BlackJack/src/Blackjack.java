
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    private Scanner sc;
    private Korttipakka pakka;
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
        this.pakka = new Korttipakka();
        this.pelaajanKasi = new PelaajanKasi(pakka);

    }

    public void annaKorttiPelaajalle() {
        Kortti kortti = pakka.jaaKortti();
        pelaajanKasi.otaKortti(kortti);
        System.out.println("Sait kortin " + kortti);
    }

    public void kaynnista() {
//        System.out.println("sekoitetaan");
//        pakka.sekoita();
//        System.out.println("annetaan kortit pelaajalle 2x");
//        annaKorttiPelaajalle();
//        annaKorttiPelaajalle();
        int summa = pelaajanKasi.getKasiArvo();
        System.out.println("Olet tuloksessa " + summa + "\n");
        jaaLisakortitPelaajalle();
    }

    public void jaaLisakortitPelaajalle() {
        int summa = pelaajanKasi.getKasiArvo();
        System.out.println("summa on " + summa);
        String vastaus = "k";
        //jaetaan lisäkortteja niin kauan kuin käyttäjä haluaa
//        while (summa < 21 && vastaus.equalsIgnoreCase("k")) {
//            System.out.println("Haluatko lisäkortin (k/e)?");
//            vastaus = sc.nextLine();
//            if (vastaus.equalsIgnoreCase("k")) {
//                annaKorttiPelaajalle();
//                summa = pelaajanKasi.getKasiArvo();
//                
//                
//                System.out.println("Olet tuloksessa " + summa);
//            }
//        }
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
