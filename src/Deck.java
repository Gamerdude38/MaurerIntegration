import java.util.ArrayList;

/**
 * Represents a standard deck of playing cards, for use in various card games.
 * 
 * @author John Maurer
 *
 */
public class Deck {
  /**
   * Holds a standard deck of playing cards using an <code>ArrayList</code> of type
   * <code>PlayingCard</code>.
   */
  private ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();

  /**
   * Constructs a default deck of 52 playing cards.
   */
  public Deck() {
    for (int suit = 0; suit < 4; suit++) {
      for (int denom = 0; denom < 13; denom++) { // "denom" stands for card denomination
        PlayingCard temp = new PlayingCard(this.deriveDenom(denom), this.deriveSuit(suit));
        deck.add(temp);
      }
    }
  }

  /**
   * Given an integer, determines the suit of the playing card. Strictly used by <code>Deck</code>
   * to generate 52 unique playing cards found in a standard deck.
   * 
   * <p>(0 = Spades, 1 = Diamonds, 2 = Hearts, and 3 = Clubs)
   * 
   * <p>If <code>suitNum</code> is not between 0 and 3 inclusive, <code>suit</code> will be given 
   * the value "INVALID".
   * 
   * @param suitNum an integer representing the suit of a playing card.
   * @return the suit as a <code>String</code>.
   */
  private String deriveSuit(int suitNum) {
    // this is a method declaration, AKA the method signature. Right below is its header, followed
    // by the parameter "suitNum".

    switch (suitNum) {
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

  /**
   * Given an integer, determines the denomination of the playing card. Strictly used by
   * <code>Deck</code> to generate 52 unique playing cards found in a standard deck.
   * 
   * <p>(0 = Ace, 1 = Two, 2 = Three, 3 = Four, ... , 10 = Jack, 11 = Queen, 12 = King)
   * 
   * <p>If <code>denomNum</code> is not between 0 and 12 inclusive, <code>denomination</code> will
   * be given the value "INVALID".
   * 
   * @param denomNum an integer representing the denomination of a playing card.
   * @return the denomination as a <code>String</code>.
   */
  private String deriveDenom(int denomNum) {
    switch (denomNum) {
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

  /**
   * Adds a specified <code>PlayingCard</code> to <code>deck</code>.
   * 
   * @param card the card to be added to the deck.
   */
  public void addCard(PlayingCard card) {
    deck.add(card);
  }

  /**
   * Adds a <code>PlayingCard</code> to <code>deck</code>.
   * 
   * @deprecated Use {@link #addCard(PlayingCard)} instead.
   */
  public void addCard() {

  }

  /**
   * Takes a card from the top of <code>deck</code>, usually to hand it to a player.
   * 
   * @return a <code>PlayingCard</code> pulled from the top of <code>deck</code>.
   */
  public PlayingCard dealCard() {
    PlayingCard drawnCard = deck.get(0);

    deck.remove(0);

    return drawnCard;
  }

  /**
   * Shuffles all the cards in <code>deck</code> by randomly picking two cards and swapping their
   * locations, repeating for 200 iterations to ensure good shuffling.
   */
  public void shuffle() {
    int firstIndex = 0;
    int secondIndex = 0;
    // these two indices will serve as the two cards whose positions will be exchanged.

    for (int i = 0; i < 200; i++) {
      // To ensure good shuffling, I give the number generator a chance to shuffle every card. It's
      // a basic shuffling method, but hopefully 200 iterations will shuffle the cards nicely.

      firstIndex = (int) (Math.random() * deck.size());
      secondIndex = (int) (Math.random() * deck.size());

      PlayingCard temp = deck.get(firstIndex);
      deck.set(firstIndex, deck.get(secondIndex));
      deck.set(secondIndex, temp);
    }
  }

  /**
   * Formats a <code>String</code> to display all the cards in the deck.
   * 
   * @return a printable <code>String</code> of the deck.
   * @see java.lang.Object#toString()
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < deck.size(); i++) {
      builder.append(deck.get(i).toString());
      builder.append("\n");
    }

    return builder.toString();
  }
}
