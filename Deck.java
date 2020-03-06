/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class Deck{
   public ArrayList<Card> deck = new ArrayList<Card>();
   public final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
   public final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
   public final int[] VALUES = {2,3,4,5,6,7,8,9,10,11,12,13,14};
   
   public Deck(){
      for(String s: SUITS){
         for(int i : VALUES){
            deck.add(new Card(NAMES[i-2], s, i));
         }
      }
   }
   public ArrayList<Card> getDeck(){
      return deck;
   }
   public void initializeDeck(){
      this.deck.clear();
      for(String s: SUITS){
         for(int i : VALUES){
            deck.add(new Card(NAMES[i-2], s, i));         
         }
      }
   }
   public Card getCard(int index){
      return getDeck().get(index);
   }
   public Card dealCard(){
      return deck.remove(0);
   }
   public void shuffle(){
      Collections.shuffle(this.deck);
   }
   public void shuffle2(){
      //Math.random(max - min + 1) + min
      //therefore, 2-10 would be (8*Math.random())+2
      //part 2:  (52*Math.random())
      int count = 0;
      while(count<20){
         ArrayList<Card> queue = new ArrayList<Card>();
         for(int i=((int)((8*Math.random())+2)); i>0; i--){
            queue.add(deck.remove(i-1));
         }
         for(Card c : queue){
            deck.add(((int)(deck.size()*Math.random())),c);
         }
         count++;
      }
   }
   public String toString(){
      String result = "";
      for(Card c:this.getDeck()){
         result += c.toString();
      }
      return result;
   }
}