/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class TestCardPlayer{
  public static void main(String[] args){
      CardPlayer cp1 = new CardPlayer("Kara Jones", 0, new ArrayList<Card>());
      System.out.println("New CardPlayer -> " + cp1);
      cp1.addCard(new Card("3", "diamonds", 3));
      cp1.addCard(new Card("A", "hearts", 14));
      cp1.addCard(new Card("6", "spades", 6));
      cp1.addCard(new Card("7", "spades", 7));
      cp1.addCard(new Card("2", "clubs", 2));
      cp1.addCard(new Card("3", "clubs", 3));
      System.out.println("After adding 6 specific cards. Player -> " + cp1);
      cp1.updateScore(27);
      System.out.println("Played " + cp1.playCard(5) + " at index 5 and scored 27 points. Player -> " + cp1);
      ArrayList<Card> round = new ArrayList<Card>();
      ArrayList<Card> game = new ArrayList<Card>();
      System.out.println("Cards played in round ->" + round);
      System.out.println("Cards played in game ->" + game);
      System.out.println("Chose 2 of clubs -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
      ArrayList<Card> round2 = new ArrayList<Card>();
      round2.add(new Card("10", "spades", 10));
      System.out.println("Cards played in round ->" + round2);
      System.out.println("RANDOMLY chosen spade -> " + cp1.chooseCard(round2, game) + " Player -> " + cp1);
      ArrayList<Card> round3 = new ArrayList<Card>();
      round3.add(new Card("9", "clubs", 9));
      System.out.println("Cards played in round ->" + round2);
      System.out.println("heart chosen -> " + cp1.chooseCard(round3, game) + " Player -> " + cp1);
      System.out.println("Cards played in round ->" + round);
      System.out.println("RANDOMLY chosen card -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
  }
}