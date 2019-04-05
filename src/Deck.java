// John Maurer
// A class that uses the PlayingCard class to create a Deck object, with 52 unique cards. Also has
// handy methods for shuffling and stuff

import java.util.ArrayList;

public class Deck {
  private ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();

  public Deck() {
    for (int suit = 0; suit < 4; suit++) {
      for (int denom = 0; denom < 13; denom++) { // "denom" stands for card denomination
        PlayingCard temp = new PlayingCard(this.deriveDenom(denom), this.deriveSuit(suit));
        deck.add(temp);
      }
    }
  }

  private String deriveSuit(int suit) { // this is a method declaration, AKA the method signature.
                                        // Right below is its header, followed by the parameter
                                        // "suit".
    switch (suit) {
      case 0:
        return "Spades";
      case 1:
        return "Diamonds";
      case 2:
        return "Hearts";
      case 3:
        return "Clubs";
      default:
        return "INVALID";
    }
  }

  private String deriveDenom(int denom) {
    switch (denom) {
      case 0:
        return "Ace";
      case 1:
        return "Two";
      case 2:
        return "Three";
      case 3:
        return "Four";
      case 4:
        return "Five";
      case 5:
        return "Six";
      case 6:
        return "Seven";
      case 7:
        return "Eight";
      case 8:
        return "Nine";
      case 9:
        return "Ten";
      case 10:
        return "Jack";
      case 11:
        return "Queen";
      case 12:
        return "King";
      default:
        return "INVALID";
    }
  }

  public void addCard(PlayingCard card) {
    deck.add(card);
  }

  public void addCard() {

  }

  public PlayingCard dealCard() {
    PlayingCard drawnCard = deck.get(0);

    deck.remove(0);

    return drawnCard;
  }

  public void shuffle() {
    int firstIndex = 0;
    int secondIndex = 0; // these two indices will serve as the two cards whose positions will be
                         // exchanged

    for (int i = 0; i < 200; i++) { // to ensure good shuffling, I give the random number generator
                                    // a chance to shuffle every card. Its a basic shuffling method,
                                    // but hopefully 200 iterations will shuffle the cards nicely
      firstIndex = (int) (Math.random() * deck.size());
      secondIndex = (int) (Math.random() * deck.size());

      PlayingCard temp = deck.get(firstIndex);
      deck.set(firstIndex, deck.get(secondIndex));
      deck.set(secondIndex, temp);
    }
  }

  public String toString() {
    String str = "";

    for (int i = 0; i < deck.size(); i++) {
      str += (deck.get(i).toString() + "\n");
    }

    return str;
  }
}
