
import java.util.Arrays;
import java.util.List;

public class Kortti {
    private int arvo;
    private String maa;

//    public Kortti(int arvo, String maa) {
//        this.arvo = arvo;
//        this.maa = maa;
//    }
    public Kortti(int arvo, String maa) {
        setArvo(arvo);  //2
        setMaa(maa);    //"hearts"
    }

//    public static List<Integer> getArvot() {
//        return Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
//    }

    public int getArvo() {
        return this.arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public String getMaa() {
        return this.maa;
    }

    @Override
    public String toString() {
        return arvo + " " + maa;
    }
}
