
import java.util.ArrayList;

public class PelaajanKasi {

    public ArrayList<Kortti> kortit = new ArrayList<>();

    public PelaajanKasi() {
    }

    public void otaKortti(Kortti k) {
        this.kortit.add(k);
        // System.out.println("Pelaajan kädessä olevat kortit: " + kortit);
        System.out.println("Pelaajan nosti kortin " + k);
    }

    public int selvitaSumma() {
        int yhteensa = 0;
        //System.out.println("Aletaan laskemaan summaa");

        for (Kortti k : kortit) {
            if (k.getArvo() > 1 && k.getArvo() < 11) {
                yhteensa += k.getArvo();
                //System.out.println("Tässä oli 2-10 numero");
            }
            if (k.getArvo() > 10 && k.getArvo() < 14) {
                yhteensa += 10;
                //System.out.println("Tästä pitäisi tulla 10");
            }
            if (k.getArvo() == 14) {
                if ((yhteensa + 11) > 21) {
                    yhteensa++;
                } else {
                    yhteensa += 11;
                }
            }
            onkoBlackjack(yhteensa);

        }

        if (yhteensa > 21 && kortit.size() == 2) {
            yhteensa -= 10;
        }
        //System.out.println("Käden yhteissumma: " + yhteensa);
        return yhteensa;
    }

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack(int yhteensa) {
        if (kortit.size() == 2 && yhteensa == 21) {
            //System.out.println("BlackJack");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String kasi = "";
        for (int i = 0; i < kortit.size(); i++) {
            kasi += kortit.get(i).toString() + " ";
        }
        return kasi;
    }

}
