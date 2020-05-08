
import java.util.ArrayList;

public class PelaajanKasi {
    private int kasiSumma;
    private ArrayList<Kortti> kortitKadessa = new ArrayList<>();

    public PelaajanKasi(Korttipakka pakka) {

        for (int i = 0; i < 2; i++) {
            kortitKadessa.add(pakka.jaaKortti());            
        }
        for (Kortti k : kortitKadessa) {
            kasiSumma += k.getArvo();
            System.out.println(k);
        }
        System.out.println("Testi 1");
        
        selvitaSumma(kasiSumma);
    }

    public int getKasiArvo() {
        return kasiSumma;
    }

    public ArrayList<Kortti> getKortit() {
        return kortitKadessa;
    }

    // otaKortti 
    //lisää kortit-listaan parametrina saamansa kortin
    public void otaKortti(Kortti k) {
        this.kortitKadessa.add(k);
    }

    // selvitaSumma 
    //selvittää pelaajan käden summan seuraavin säännöin
    public int selvitaSumma(int kasiSumma) {
        //int kasiSumm4 = kasiSumma;
        int yhteensa = 0;
        System.out.println("Aletaan laskemaan summaa");
        for (Kortti k : kortitKadessa) {
            if (k.getArvo() > 1 && k.getArvo() < 11) {
                yhteensa += k.getArvo();
                System.out.println("Tässä oli 2-10 numero");
            }                        
            if (k.getArvo() > 10 && k.getArvo() < 14) {
                yhteensa += 10;
                System.out.println("Tästä pitäisi tulla 10");
            }
            if (k.getArvo() == 1) {
                yhteensa += 11;
                System.out.println("Tässä oli ässä");
            }
            if (k.getArvo() == 14) {
                yhteensa += 11;
                System.out.println("Ässä 14");
            }
            onkoBlackjack(yhteensa);
            
        }

        if (yhteensa > 21) {
            yhteensa -= 10;
        }
        System.out.println("Käden yhteissumma: "+yhteensa);
        return yhteensa;
    }
    

    // tutkii onko kätenä blackjack
    public boolean onkoBlackjack(int yhteensa) {
        if (kortitKadessa.size() == 2 && yhteensa== 21) {
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
