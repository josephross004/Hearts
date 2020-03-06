/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class TestDeck{
   public static void main(String args[]){
      Deck newDeck = new Deck();
      System.out.println("new deck " + newDeck);
      newDeck.shuffle();
      System.out.println("shuffled " + newDeck);
      for(int i=0; i<4; i++){
         System.out.print("\n13 cards ");
         for(int j=0; j<13; j++){
            System.out.print(newDeck.dealCard());
         }
         System.out.println("\nRemaining " + newDeck);
      }
      newDeck.initializeDeck();
      Card card = newDeck.getCard((int)(52*Math.random()));
      System.out.println("\nrandom card from new deck " + card + ".");
      int index = newDeck.getDeck().indexOf(card);
      int count = 0;
      int equals = 0;
      while(count < 52000){
         newDeck.shuffle();
         if(newDeck.getCard(index).equals(card)){
            equals += 1;
         }
         count++;  
      }
      System.out.println("Found " + card + " at location " + index + " in the deck " + equals + " times. ");
   }
}
