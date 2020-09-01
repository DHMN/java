
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Kortti k = new Kortti(3, "diamonds");
//        System.out.println(k);
        
        Korttipakka pakka = new Korttipakka(1);
//        pakka.sekoita();
        System.out.println(pakka);
        System.out.println("jaaKortti");
        pakka.jaaKortti();
        System.out.println(pakka);

//    BlackJack bj = BlackJack();
//    bj.kaynnista();
    }
}
