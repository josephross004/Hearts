import java.util.ArrayList;

public class CardPlayerMueller extends CardPlayer {
  public CardPlayerMueller(String name, int score, ArrayList<Card> hand) {
    super(name, score, hand);
  }
  
  public Card maxValueCard(ArrayList<Card> setOfCards) {
    Card maxCard = new Card();
    for (Card card : setOfCards) {
      if (card.compareTo(maxCard) > 0)
        maxCard = card; 
    } 
    return maxCard;
  }
  
  public Card chooseCard(ArrayList<Card> cardsPlayedThisRound, ArrayList<Card> cardsPlayedThisGame) {
    int randCard = 0;
    Card card = new Card();
    Card twoOfClubs = new Card("2", "clubs", 2);
    Card queenOfSpades = new Card("Q", "spades", 12);
    Card kingOfSpades = new Card("K", "spades", 13);
    Card aceOfSpades = new Card("A", "spades", 14);
    ArrayList<Card> heartsInMyHand = new ArrayList<>();
    ArrayList<Card> cardsInMyHandThatMatchSuitThatWasLed = new ArrayList<>();
    ArrayList<Card> otherSuits = new ArrayList<>();
    if (cardsPlayedThisGame.size() == 0 && getHand().contains(twoOfClubs)) {
      int twoOfClubsIdx = getHand().indexOf(twoOfClubs);
      card = playCard(twoOfClubsIdx);
    } else if (cardsPlayedThisRound.size() == 0) {
      randCard = (int)(Math.random() * getHand().size());
      card = playCard(randCard);
    } else {
      Card cardLed = cardsPlayedThisRound.get(0);
      Card highestCardPlayedInSuitThatWasLed = cardLed;
      for (Card cardPlayed : cardsPlayedThisRound) {
        if (cardPlayed.getSuit().equals(cardLed.getSuit()) && cardPlayed.compareTo(cardLed) == 1)
          highestCardPlayedInSuitThatWasLed = cardPlayed; 
      } 
      for (Card playerCard : getHand()) {
        if (playerCard.getSuit().equals("hearts"))
          heartsInMyHand.add(playerCard); 
        if (playerCard.getSuit().equals(cardLed.getSuit())) {
          cardsInMyHandThatMatchSuitThatWasLed.add(playerCard);
          continue;
        } 
        otherSuits.add(playerCard);
      } 
      if (cardsInMyHandThatMatchSuitThatWasLed.size() != 0) {
        if (cardsInMyHandThatMatchSuitThatWasLed.indexOf(queenOfSpades) != -1 && (cardsPlayedThisRound.indexOf(kingOfSpades) != -1 || cardsPlayedThisRound.indexOf(aceOfSpades) != -1)) {
          card = queenOfSpades;
        } else {
          randCard = (int)(Math.random() * cardsInMyHandThatMatchSuitThatWasLed.size());
          card = cardsInMyHandThatMatchSuitThatWasLed.get(randCard);
        } 
      } else if (getHand().indexOf(queenOfSpades) != -1) {
        card = queenOfSpades;
      } else if (getHand().indexOf(aceOfSpades) != -1) {
        card = aceOfSpades;
      } else if (getHand().indexOf(kingOfSpades) != -1) {
        card = kingOfSpades;
      } else if (heartsInMyHand.size() != 0) {
        card = maxValueCard(heartsInMyHand);
      } else {
        card = maxValueCard(otherSuits);
      } 
      card = playCard(getHand().indexOf(card));
    } 
    return card;
  }
}
