
import java.util.ArrayList;

public class PelaajanKasi {

    public ArrayList<Kortti> kortit = new ArrayList<>();

    public PelaajanKasi() {
    }

    public void otaKortti(Kortti k) {
        this.kortit.add(k);
    }

    public int selvitaSumma() {
        int yhteensa = 0;

        for (Kortti k : kortit) {
            if (k.getArvo() > 1 && k.getArvo() < 11) {
                yhteensa += k.getArvo();
                //System.out.println("Tässä oli 2-10 numero");
            }
            if (k.getArvo() > 10 && k.getArvo() < 14) {
                yhteensa += 10;
                //System.out.println("Tästä pitäisi tulla 10");
            }
            if (k.getArvo() == 1) {
                if ((yhteensa + 11) > 21) {
                    yhteensa++;
                } else {
                    yhteensa += 11;
                }
            }
            
           

        }

        return yhteensa;
    }

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack() {
        if (kortit.size() == 2 && selvitaSumma() == 21) {
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
