import java.util.*;
import java.io.*;

public class CardPlayerRoss extends CardPlayer{
    public CardPlayerRoss(String name, int score, ArrayList<Card> hand){
        super(name, score, hand);
    }

    public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
      int order = round.size();
      // Play 2 of clubs if player is first, player has 2 of clubs, game is empty
      if(game.size() == 0 && order == 0 && this.getHand().indexOf(new Card("2", "clubs", 2))>=0){
         return this.playCard(this.getHand().indexOf(new Card("2", "clubs", 2)));
      }
      if(order==0){
         for(int c=0; c<this.getHand().size(); c++){
            for(int j=0; j<=14; j++){
               if(this.getHand().get(c).getValue()<=j && !(this.getHand().get(c).getSuit().equals("hearts")) && !(this.getHand().get(c).getSuit().equals("spades"))){
                  return this.playCard(this.getHand().indexOf(this.getHand().get(c)));
               }
            }
         }
      }
      //If the player is not first:
      else{
         ArrayList<Card> possible = new ArrayList<Card>();
         //Play low card that has the same suit
         for(int i=0; i<this.getHand().size(); i++){
            if(this.getHand().get(i).getSuit().equals(round.get(0).getSuit())){
               possible.add(this.playCard(i));
               i--;
            }
         }
         if(possible.size()>0){
            Card res = possible.get(possible.indexOf(Collections.min(possible)));
            possible.remove(res);
            this.getHand().addAll(possible);
            return(res);
         }
        //Play queen of spades, if necessary
        if(this.getHand().indexOf(new Card("Q", "spades", 12)) >= 0){
            return this.playCard(this.getHand().indexOf(new Card("Q", "spades", 12)));
        }
        //Then, play king, ace of spades
        for(Card c : this.getHand()){
         if(c.compareTo(new Card("Q", "spades", 12))==1){
            return this.playCard(this.getHand().indexOf(c));
         }
        }
         //Play a high heart
         for(int i=0; i<this.getHand().size(); i++){
            if(this.getHand().get(i).getSuit().equals("hearts")){
               possible.add(this.playCard(i));
               i--;
            }
         }
         if(possible.size()>0){
            Collections.sort(possible);
            Card res = possible.get(possible.size()-1);
            possible.remove(res);
            ArrayList<Card> remainingHand = new ArrayList<Card>();
            remainingHand.addAll(this.getHand());
            remainingHand.addAll(possible);
            this.setHand(remainingHand);
            return(res);
         }
      }
      //Otherwise, play a low card
      Card res = Collections.min(this.getHand());
      return res;
   }
}