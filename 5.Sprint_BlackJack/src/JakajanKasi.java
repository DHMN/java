
import java.util.ArrayList;
import java.util.Scanner;

public class JakajanKasi {

    private Scanner sc;
    private int yhteensa;
    private int kasiSumma;
    private int uusiKortti = 2;
    private ArrayList<Kortti> jakajanKortit = new ArrayList<>();

    public JakajanKasi(Korttipakka pakka) {
        sc = new Scanner(System.in);
        this.yhteensa = 0;

        System.out.println("\nJakajankäsi.");
        for (int i = 0; i < 2; i++) {
            jakajanKortit.add(pakka.jaaKortti());
        }
        for (Kortti k : jakajanKortit) {
            kasiSumma = k.getArvo();
            System.out.println(k);
            selvitaSumma(kasiSumma);
        }
        System.out.println("Jakajan korttien summa: " + yhteensa+"\n");

        while (yhteensa < 15) {
            jakajanKortit.add(pakka.jaaKortti());
            otaJakajanKortti();
            System.out.println("Jakajan korttien summa: " + yhteensa+"\n");
            uusiKortti++;
        }
    }

    //lisää uuden kortin jakajan käteen.
    public void otaJakajanKortti() {
        System.out.println(jakajanKortit.get(uusiKortti));
        Kortti x = jakajanKortit.get(uusiKortti);
        selvitaSumma(x.getArvo());
    }

    //selvittää jakajan käden summan seuraavin säännöin
    public int selvitaSumma(int kasiSumma) {

        if (kasiSumma > 1 && kasiSumma < 11) { //Tässä on 2-10 numero.
            yhteensa += kasiSumma;
        }
        if (kasiSumma > 10 && kasiSumma < 14) { //Tästä pitäisi tulla 10.
            yhteensa += 10;
        }
        if (kasiSumma == 14) { //Tässä muutetaan ässän arvo 11.
            yhteensa += 11;
        }
        if (yhteensa > 21 && jakajanKortit.size() < 2) { //Tässä muutetaan toinen ässä 1 ja toinen on 11. Kun pelaaja saa 2 ässää alussa.
            yhteensa -= 10;
        }
        return yhteensa;
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
