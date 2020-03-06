
import java.util.*;
import java.io.*;
public class TestCardShark{
    public static void main(String[] args){
        System.out.println(">>> Constructor");
        String[] s = {"Mueller0", "Ross1", "Mueller2", "Ross3"};
        String name = "***Hearts***";
        //Test 2: Play 2000 times
        CardShark cardGame2 = new CardShark(name, 4, s, 0);
        cardGame2.setPlayers(s);
        for(int i = 0; i<s.length; i++){
            if(i%2==0){
                System.out.println("Player " + s[i] + " is a CardPlayerMueller");
            }else{
                System.out.println("Player " + s[i] + " is a CardPlayerRoss");
            }
        }
        System.out.println(">>> Printing game in TestCardGame \n" + cardGame2);
        for (int i=0; i<2000; i++){
            System.out.println(">>> playGame() " + cardGame2.playGame());
        }
        System.out.println(">>> Printing Total Score and Player % in TestCardGame");
        System.out.println(cardGame2.calculate(2000));
    }
}