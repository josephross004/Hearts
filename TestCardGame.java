/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;
public class TestCardGame{
    public static void main(String[] args){
        System.out.println(">>> Constructor");
        String[] s = {"Player0", "Player1", "Player2", "Player3"};
        String name = "***Hearts***";
        CardGame cardGame = new CardGame(name, 4, s, 0);
        cardGame.setPlayers(s);
        for(String str : s){
            System.out.println("Player " + str + " is a CardPlayer");
        }
        System.out.println(">>> Printing game in TestCardGame \n" + cardGame);
        System.out.println(">>> playGame() " + cardGame.playGame());
        System.out.println(">>> playGame() " + cardGame.playGame());
        System.out.println(">>> playGame() " + cardGame.playGame());
        System.out.println(">>> playGame() " + cardGame.playGame());
        System.out.println(">>> Printing Total Score and Player % in TestCardGame");
        System.out.println(cardGame.calculate(4));
        //Test 2: Play 2000 times
        CardGame cardGame2 = new CardGame(name, 4, s, 0);
        for(String str : s){
            System.out.println("Player " + str + " is a CardPlayer");
        }
        System.out.println(">>> Printing game in TestCardGame \n" + cardGame2);
        for (int i=0; i<2000; i++){
            System.out.println(">>> playGame() " + cardGame2.playGame());
        }
        System.out.println(">>> Printing Total Score and Player % in TestCardGame");
        System.out.println(cardGame2.calculate(2000));
        //Test 3: Play 2000 times
        CardGame cardGame3 = new CardGame(name, 4, s, 0);
        for(String str : s){
            System.out.println("Player " + str + " is a CardPlayer");
        }
        System.out.println(">>> Printing game in TestCardGame \n" + cardGame3);
        for (int i=0; i<2000; i++){
            System.out.println(">>> playGame() " + cardGame3.playGame());
        }
        System.out.println(">>> Printing Total Score and Player % in TestCardGame");
        System.out.println(cardGame3.calculate(2000));

        //test 4: unofficial
        System.out.println(">>> Printing game in TestCardGame \n" + cardGame3);
        for (int i=0; i<Integer.MAX_VALUE; i++){
            System.out.println(">>> playGame() " + cardGame3.playGame());
        }
        System.out.println(">>> Printing Total Score and Player % in TestCardGame");
        System.out.println(cardGame3.calculate(Integer.MAX_VALUE));
    }
}