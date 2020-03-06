/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class CardGame{
    public final Card TWO_OF_CLUBS = new Card("2", "clubs", 2);
    public int CARDS_PER_HAND = 13;
    private Deck deckOfCards = new Deck();
    private String nameOfGame;
    public ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
    private int numberOfPlayers;
    private int currentPlayer;

    public CardGame(String name, int players, String[] names, int current){
        this.deckOfCards.initializeDeck();
        this.deckOfCards.shuffle();
        this.nameOfGame = name;
        this.numberOfPlayers = players;
        this.currentPlayer = current;
    }

    public void setPlayers(String[] names){
        for(String s : names){
            this.addPlayer(s, false);
        }
    }
    
    public void addPlayer(String name, boolean cpl1){
        if(cpl1){
            this.players.add(new CardPlayerRoss(name,0,new ArrayList<Card>()));
        }else{
            this.players.add(new CardPlayerMueller(name,0,new ArrayList<Card>()));
        }
    }

    public void deal(int cardsToDeal, int index){
        for(int i=0; i<cardsToDeal; i++){
            this.players.get(index).addCard(deckOfCards.dealCard());
        }
    }
    public void checkRound(ArrayList<Card> round, int startingPlayer) {
        System.out.print(startingPlayer + " ");
        // Establish what the suit to match is
        String roundSuit = round.get(0).getSuit(); 
        // For all other players
        for (int i = 1; i < round.size(); i++) { 
           // If their card doesn't match suit, check to see if they're incorrect
            if (!round.get(i).getSuit().equals(roundSuit)) { 
                CardPlayer player = players.get((i + startingPlayer) % round.size());
                // Go through their cards
                for (Card c : player.getHand()) { 
                    // If incorrect, print out offending card and that they're incorrect
                    if (c.getSuit().equals(roundSuit)) { 
                        System.out.println("*** INCORRECT ***" + player.getName() + " playing " + round.get(i) + " in " + round + " while having " + player.getHand());
                        break;
                    }
                }
            }
        }
    }
     
    public String playGame(){
        //Reset taken cards after score calculation update
        for(CardPlayer cp : players){
            cp.resetTakenCards();
        }
        //Shuffle deck and deal
        this.deckOfCards.shuffle();
        for(int i=0; i<players.size(); i++){
            this.deal(this.CARDS_PER_HAND, i);
        }
        //Detect 2 of clubs
        for(CardPlayer cp : this.players){
            if(cp.getHand().contains(TWO_OF_CLUBS)){
                currentPlayer = this.players.indexOf(cp);
            }
        }
        //instantiate round and game ArrayLists
        ArrayList<Card> round = new ArrayList<Card>();
        ArrayList<Card> game = new ArrayList<Card>();
        //Instantiate suit string for comparison
        String suit = "";
        //13 times - play one "game"
        for(int i=0; i<13; i++){
            //clear the round
            round.clear();
            //4 times - play cards
            for(int j=0; j<4; j++){
                //add the card selection to the round
                round.add(this.players.get(this.currentPlayer).chooseCard(round, game));
                if(j==0){
                    //if the current player is the first player, then the suit of the first card in the round is the suit that all players must force play
                    suit = round.get(0).getSuit();
                }
                //change the current player
                if(this.currentPlayer <= 2){
                    this.currentPlayer++;
                }
                else{
                    this.currentPlayer = 0;
                }
            }
            //determine winner
            ArrayList<Card> possible = new ArrayList<Card>();
            for(Card c : round){
                if(c.getSuit().equals(suit)){
                    possible.add(c);
                }
            }
            //the winner index is the index of the player in players that is at the index of the first player plus the index of the maximum value of the round's correct suit cards
            int winnerIndex = this.players.indexOf(this.players.get(((this.currentPlayer+(round.indexOf(Collections.max(possible))))%4)));
            //give that player the cards
            this.players.get(winnerIndex).setTakenCards(round);
            checkRound(round, currentPlayer);
            currentPlayer = winnerIndex;
        }

        String res = "";
        //for cardplayer in players
        for(CardPlayer cp : this.players){
            //calculate the score
            cp.setScore();
            //add the name and score to the string
            res += ""+cp.getName()+" ("+cp.getScore()+") ";
        }
        //reset the deck
        this.deckOfCards.initializeDeck();
        //return the scores and players
        return res;
    }

    public String calculate(int gamesPlayed){
        String res = "";
        res += "Total Score: ";
        res += 26*gamesPlayed;
        res += "\n";
        for(CardPlayer cp : players){
            res += "" + cp.getName() + " ";
            double num = cp.getScore();
            double den = gamesPlayed*26;
            double percentage = (num/den);
            Math.round(percentage);
            res += (percentage*100) + "\n";
        }
        return res;
    }

    public String toString(){
        String res = this.nameOfGame;
        for(CardPlayer cp : this.players){
            res += ("\n" + cp);
        }
        res += "\ndeck ->\n" + deckOfCards;
        return res;
    }
}