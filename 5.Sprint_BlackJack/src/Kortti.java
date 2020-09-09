
public class Kortti {

    private int arvo;
    private String maa;

    public Kortti(int arvo, String maa) {
        setArvo(arvo);  //2
        setMaa(maa);    //"hearts"
    }

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
