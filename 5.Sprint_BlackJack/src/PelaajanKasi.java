
import java.util.ArrayList;
import java.util.Scanner;

public class PelaajanKasi {

    private Scanner sc;
    private int yhteensa;
    private int kasiSumma;
    private int uuskortti = 2;
    private ArrayList<Kortti> kortitKadessa = new ArrayList<>();

    public PelaajanKasi(Korttipakka pakka) {
        sc = new Scanner(System.in);
        this.yhteensa = 0;

        System.out.println("public Pelaajankasi");
        for (int i = 0; i < 2; i++) {
            kortitKadessa.add(pakka.jaaKortti());
        }
        for (Kortti k : kortitKadessa) {
            kasiSumma = k.getArvo();
            System.out.println(k);
            selvitaSumma(kasiSumma);
        }

        while (yhteensa < 21) {
            System.out.println("Haluutko lisää korttei? (k/e)");
            String s = sc.nextLine();

            if (s.equalsIgnoreCase("k")) {
                kortitKadessa.add(pakka.jaaKortti());
                otaKortti();
            }
            uuskortti++;
        }
    }

    // otaKortti 
    //lisää kortit-listaan parametrina saamansa kortin
    public void otaKortti() {
        System.out.println(kortitKadessa.get(uuskortti));
        Kortti mustikka = kortitKadessa.get(uuskortti);
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

        if (yhteensa > 21 && kortitKadessa.size() < 2) {
            yhteensa -= 10;
        }
        if (yhteensa > 21 && kortitKadessa.size() > 2) {
            System.out.println("Hävisit! peli päättyy");
        }

        System.out.println("Käden yhteissumma: " + yhteensa);
        return yhteensa;
    }

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack(int yhteensa) {
        if (kortitKadessa.size() == 2 && yhteensa == 21) {
            System.out.println("BlackJack");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String kasi = "";
        for (int i = 0; i < kortitKadessa.size(); i++) {
            kasi += kortitKadessa.get(i).toString() + " ";
        }
        return kasi;
    }
}
