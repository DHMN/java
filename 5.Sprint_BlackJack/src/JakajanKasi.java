import java.util.ArrayList;
import java.util.Scanner;

public class JakajanKasi {

    private Scanner sc;
    private int yhteensa;
    private int kasiSumma;
    private int uuskortti = 2;
    private ArrayList<Kortti> jakajanKortit = new ArrayList<>();

    public JakajanKasi(Korttipakka pakka) {
        sc = new Scanner(System.in);
        this.yhteensa = 0;

        System.out.println("public Jakajankasi");
        for (int i = 0; i < 2; i++) {
            jakajanKortit.add(pakka.jaaKortti());
        }
        for (Kortti k : jakajanKortit) {
            kasiSumma = k.getArvo();
            System.out.println(k);
            selvitaSumma(kasiSumma);
        }

        while (yhteensa < 21) {
            System.out.println("Haluutko lisää korttei? (k/e)");
            String s = sc.nextLine();

            if (s.equalsIgnoreCase("k")) {
                jakajanKortit.add(pakka.jaaKortti());
                otaJakajanKortti();
            }
            uuskortti++;
        }
    }

    // otaKortti 
    //lisää kortit-listaan parametrina saamansa kortin
    public void otaJakajanKortti() {
        System.out.println(jakajanKortit.get(uuskortti));
        Kortti mustikka = jakajanKortit.get(uuskortti);
        selvitaSumma(mustikka.getArvo());
    }

    //selvittää pelaajan käden summan seuraavin säännöin
    public int selvitaSumma(int kasiSumma) {
        System.out.println("Aletaan laskemaan summaa");

        if (kasiSumma > 1 && kasiSumma < 11) {
            yhteensa += kasiSumma;
            //System.out.println("Tässä oli 2-10 numero");
        }
        if (kasiSumma > 10 && kasiSumma < 14) {
            yhteensa += 10;
            // System.out.println("Tästä pitäisi tulla 10");
        }
        if (kasiSumma == 1) {
            yhteensa += 11;
            //System.out.println("Tässä oli ässä");
        }
        if (kasiSumma == 14) {
            yhteensa += 11;
            //System.out.println("Ässä 14");
        }
        onkoBlackjack(yhteensa);

        if (yhteensa > 21 && jakajanKortit.size() < 2) {
            yhteensa -= 10;
        }
        if (yhteensa > 21 && jakajanKortit.size() > 2) {
            System.out.println("Hävisit! peli päättyy");
        }

        System.out.println("Käden yhteissumma: " + yhteensa);
        return yhteensa;
    }

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack(int yhteensa) {
        if (jakajanKortit.size() == 2 && yhteensa == 21) {
            System.out.println("BlackJack");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String kasi = "";
        for (int i = 0; i < jakajanKortit.size(); i++) {
            kasi += jakajanKortit.get(i).toString() + " ";
        }
        return kasi;
    }
}
