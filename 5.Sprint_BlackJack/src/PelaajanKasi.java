//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PelaajanKasi {
//
//    private Scanner sc;
//    private int yhteensa;
//    private int kasiSumma;
//    private int uusiKortti = 2;
//    private ArrayList<Kortti> kortitKadessa = new ArrayList<>();
//
//    public PelaajanKasi(Korttipakka pakka) {
//        sc = new Scanner(System.in);
//        this.yhteensa = 0;
//
//        System.out.println("Pelaajankäsi.");
//        for (int i = 0; i < 2; i++) {
//            kortitKadessa.add(pakka.jaaKortti());
//        }
//        for (Kortti k : kortitKadessa) {
//            kasiSumma = k.getArvo();
//            System.out.println(k);
//            selvitaSumma(kasiSumma);
//        }
//        System.out.println("Pelaajan korttien summa: " + yhteensa);
//
//        while (yhteensa < 21) {
//            System.out.println("\nHaluatko uuden kortin? (k/e)");
//            String s = sc.nextLine();
//
//            if (s.equalsIgnoreCase("k")) {
//                kortitKadessa.add(pakka.jaaKortti());
//                System.out.println();
//                otaKortti();
//            } else if (s.equalsIgnoreCase("e")) {
//                break;
//            } else {
//                System.out.println("Etkö osaa lukea!");
//                continue;
//            }
//            System.out.println("Pelaajan korttien summa: " + yhteensa);
//            uusiKortti++;
//        }
//    }
//
//    //lisätään kortti pelaajan käteen.
//    public void otaKortti() { // add kortti, saadusta parametrista
//        System.out.println("Nostit kortin: " + kortitKadessa.get(uusiKortti));
//        Kortti x = kortitKadessa.get(uusiKortti);
//        selvitaSumma(x.getArvo());
//    }
//
//    //selvittää pelaajan käden summan seuraavin säännöin
//    public int selvitaSumma(int kasiSumma) { // tutkii pelkästään käsilistaa
//
//        if (kasiSumma > 1 && kasiSumma < 11) { //Tässä on 2-10 numero.
//            yhteensa += kasiSumma;
//        }
//        if (kasiSumma > 10 && kasiSumma < 14) { //Tästä pitäisi tulla 10.
//            yhteensa += 10;
//        }
//        if (kasiSumma == 14) { //Tässä muutetaan ässän arvo 11.
//            yhteensa += 11;
//        }
//        if (yhteensa > 21 && kortitKadessa.size() < 2) { //Tässä muutetaan toinen ässä 1 ja toinen on 11. Kun pelaaja saa 2 ässää alussa.
//            yhteensa -= 10;
//        }
//        return yhteensa;
//    }
//
//    // tutkii onko kätenä blackjack
//    public boolean onkoBlackjack(int yhteensa) { // Kutsu selvitä summa
//        if (yhteensa > 21) {
//            System.out.println("\nHävisit pelin.");
//            return true;
//        } else if (yhteensa == 21) {
//            System.out.println("\nSait Blackjackin. Voitit pelin.");
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public String toString() {
//        String kasi = "";
//        for (int i = 0; i < kortitKadessa.size(); i++) {
//            kasi += kortitKadessa.get(i).toString() + " ";
//        }
//        return kasi;
//    }
//}
