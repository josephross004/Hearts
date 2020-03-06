/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class CardPlayer extends Player{
   private ArrayList<Card> hand;
   private ArrayList<Card> takenCards = new ArrayList<Card>();
   

   public CardPlayer(String name, int score, ArrayList<Card> hand){
      super(name, score);
      this.hand = hand;
   }
   
   public ArrayList<Card> getHand(){
      return this.hand;
   }
   
   public ArrayList<Card> getTakenCards(){
      return this.takenCards;
   }
   
   public void setHand(ArrayList<Card> hand){
      this.hand.clear();
      for(Card c : hand){
         this.hand.add(c);
      }
   }
   
   public void setTakenCards(ArrayList<Card> takenCards){
      for(Card c : takenCards){
         this.takenCards.add(c);
      }
   }

   public void resetTakenCards(){
      this.takenCards.clear();
   }
   
   public void addCard(Card c){
      this.hand.add(c);
   }   
   
   public Card playCard(int index){
      return this.hand.remove(index);
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
      int order = round.size();
      if(game.size() == 0 && order == 0 && this.hand.indexOf(new Card("2", "clubs", 2))>=0){
         return this.playCard(this.hand.indexOf(new Card("2", "clubs", 2)));
      }
      if(order==0){
         //Math.random(max - min + 1) + min
         int a = ((int)Math.random()*((int)(this.hand.size())));
         int b = ((int)Math.random()*((int)(this.hand.size())));
         int c = ((int)Math.random()*((int)(this.hand.size())));
         return this.playCard((int)(Math.random()*((int)(this.hand.size()))));
      }
      else{
         ArrayList<Card> possible = new ArrayList<Card>();
         for(int i=0; i<this.getHand().size(); i++){
            if(this.getHand().get(i).getSuit().equals(round.get(0).getSuit())){
               possible.add(this.playCard(i));
               i--;
            }
         }
         if(possible.size()>0){
            Card res = possible.get(((int)(Math.random()*((int)(possible.size())))));
            possible.remove(res);
            this.hand.addAll(possible);
            return(res);
         }
         for(int i=0; i<this.getHand().size(); i++){
            if(this.getHand().get(i).getSuit().equals("hearts")){
               possible.add(this.playCard(i));
               i--;
            }
         }
         if(possible.size()>0){
            Card res = possible.get(((int)(Math.random()*((int)(possible.size())))));
            possible.remove(res);
            this.hand.addAll(possible);
            return(res);
         }
      }
      return this.playCard((int)Math.random()*((int)(this.hand.size())));
   }
   
   public void setScore(){
      for(Card c : this.getTakenCards()){
         if(c.getSuit().equals("hearts")){
            this.updateScore(1);
         }else if(c.getSuit().equals("spades") && c.getName().equals("Q")){
            this.updateScore(13);
         }
      }
   }
   public String toString(){
      Collections.sort(this.hand);
      return "" + super.getName() + " (" + super.getScore() + ") " + this.getHand();
   }
}