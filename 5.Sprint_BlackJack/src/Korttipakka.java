
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Korttipakka {

    public ArrayList<Kortti> pakka;

    public Korttipakka(int korttipakkojenMaara) {
        List<String> maat = Arrays.asList("hearts", "diamonds", "spades", "clubs");
        List<Integer> arvot = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11/*jack*/, 12/*queen*/, 13/*king*/, 14/*ace*/);

        pakka = new ArrayList<>();  // size=0
        for (int i = 0; i < korttipakkojenMaara; i++) {
            for (String maa : maat) {  // "hertta" | size=4
                for (Integer arvo : arvot) {  // 3 | size=13
                    pakka.add(new Kortti(arvo, maa));  //arvo:3, maa:"hertta" | pakka:size=1
                }
            }
        }
    }

    // sekoita; sekoittaa atribuutin pakka korttien järjestyksen
    public void sekoita() {
        Collections.shuffle(pakka);
    }

    // jaaKortti palauttaa pakan ekan kortin ja poistaa sen pakasta
    public Kortti jaaKortti() {
        if (pakka.size() > 0) {
            return pakka.remove(0);
        }
        return null; // pakka.get(0)
    }

    @Override
    public String toString() {
//        return "" + pakka;
        String str = "";
        for (Kortti k : this.pakka) {
            str += "\n" + k.toString();
        }
        return str;
    }
}
