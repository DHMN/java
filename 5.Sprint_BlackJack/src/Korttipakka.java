import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Korttipakka {

    private ArrayList<Kortti> pakka;

    public Korttipakka(ArrayList<Kortti> pakka) {
        this.pakka = pakka;
    }
    
    //luodaan uusi korttipakka.
    public Korttipakka() {
        List<String> maat = Kortti.getMaat(); //luodaan lista maat(hertta,risti,etc.).
        List<Integer> arvot = Kortti.getArvot(); //luodaan lista korttien arvot(numerot).

        pakka = new ArrayList<>();  // luodaan lista pakka.
        for (String maa : maat) {  // käydään pakkalistan maat läpi.
            for (Integer arvo : arvot) {  //käydään pakkalistan arvot läpi.
                pakka.add(new Kortti(arvo, maa));  //Luo uudet kortit maa&arvo. 
            }
        }
        sekoita();
    }

    public void sekoita() {
        Collections.shuffle(pakka); //Käyttää kirjaston komentoa sekoittaa pakka.
    }

    //palauttaa pakan ekan kortin ja poistaa sen pakasta.
    public Kortti jaaKortti() {
        if (pakka.size() > 0) {
            return pakka.remove(0);
        }
        return null; // Jos pakka on loppu, palauttaa null arvon.
    }

    public void lisaaKortti(Kortti k) {
        this.pakka.add(k);
    }

    public Kortti getKortti(int i) {
        return this.pakka.get(i);
    }

    @Override
    public String toString() {
        String str = "";
        for (Kortti k : this.pakka) {
            str += "\n " + "-" + k.toString();
        }
        return str;
    }
}
