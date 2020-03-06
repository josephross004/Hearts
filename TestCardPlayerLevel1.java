import java.util.*;
import java.io.*;

public class TestCardPlayerLevel1 {
    public static void main(String[] args){
        CardPlayerMueller cp1 = new CardPlayerMueller("Kara Jones", 0, new ArrayList<Card>());
        System.out.println("New CardPlayer -> " + cp1);
        cp1.addCard(new Card("A", "hearts", 14));
        cp1.addCard(new Card("6", "hearts", 6));
        cp1.addCard(new Card("Q", "spades", 12));
        cp1.addCard(new Card("2", "clubs", 2));
        cp1.addCard(new Card("3", "clubs", 3));
        System.out.println("After adding 5 specific cards. Player -> " + cp1);
        ArrayList<Card> round = new ArrayList<Card>();
        ArrayList<Card> game = new ArrayList<Card>();
        System.out.println("Cards played in round ->" + round);
        System.out.println("Cards played in game ->" + game);
        System.out.println("Chose 2 of clubs -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
        round.clear();
        round.add(new Card("2", "diamonds", 2));
        System.out.println("Cards played in round ->" + round);
        System.out.println("Queen of Spades selected -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
        round.clear();
        round.add(new Card("3", "diamonds", 3));
        System.out.println("Cards played in round ->" + round);
        System.out.println("Highest heart chosen -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
        round.clear();
        System.out.println("Cards played in round ->" + round);
        System.out.println("RANDOMLY chosen card -> " + cp1.chooseCard(round, game) + " Player -> " + cp1);
    }
}