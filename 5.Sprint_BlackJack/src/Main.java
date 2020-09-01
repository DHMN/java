
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Kortti k = new Kortti(3, "diamonds");
//        System.out.println(k);
        Korttipakka pakka = new Korttipakka(1);
        PelaajanKasi kasi = new PelaajanKasi();
        
        pakka.sekoita();
        System.out.println(pakka);
        System.out.println("jaaKortti");
        pakka.jaaKortti();
        System.out.println(pakka);
        kasi.otaKortti();
        kasi.selvitaSumma();
        System.out.println("Tästä alkaa pelaajan käden summa.. ehkä");
        System.out.println(kasi);
        System.out.println("ja tähän se toivottavastiloppuu");

//    BlackJack bj = BlackJack();
//    bj.kaynnista();
    }
}
