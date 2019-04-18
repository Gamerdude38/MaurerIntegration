/**
 * Represents a standard playing card, usually found within a deck of 52 other cards.
 * 
 * @author John Maurer
 *
 */
public class PlayingCard {
  /**
   * The suit of the card (Either Spades, Diamonds, Clubs, or Hearts).
   */
  private String suit;
  /**
   * The denomination of the card (Ace, Two, Three, Four, ... , Ten, Jack, Queen, or King).
   */
  private String denomination;
  /**
   * The value of the card, mainly used for determining score (number cards have that integer value,
   * Aces are either 1 or 11, and face cards have a value of 10).
   */
  private int value;

  /**
   * Constructs a default playing card, particularly the Ace of Spades.
   */
  public PlayingCard() {
    suit = "Ace";
    denomination = "Spades";
    value = 11;
  }

  /**
   * Constructs a playing card using a given suit and denomination.
   * 
   * @param denomination a <code>String</code> to represent the denomination of the card.
   * @param suit a <code>String</code> to represent the suit of the card.
   */
  public PlayingCard(String denomination, String suit) {
    this.suit = suit;
    this.denomination = denomination;

    switch (denomination) {
      case "Ace":
        value = 11;
        break;
      case "Two":
        value = 2;
        break;
      case "Three":
        value = 3;
        break;
      case "Four":
        value = 4;
        break;
      case "Five":
        value = 5;
        break;
      case "Six":
        value = 6;
        break;
      case "Seven":
        value = 7;
        break;
      case "Eight":
        value = 8;
        break;
      case "Nine":
        value = 9;
        break;
      case "Ten":
        value = 10;
        break;
      case "Jack":
        value = 10;
        break;
      case "Queen":
        value = 10;
        break;
      case "King":
        value = 10;
        break;
      default:
        value = 0;
        suit = "INVALID";
        break;
    }

  }

  /**
   * Gets the value stored in <code>suit</code>.
   * 
   * @return the suit of the card.
   */
  public String getSuit() {
    return suit;
  }

  /**
   * Gets the value stored in <code>denomination</code>.
   * 
   * @return the denomination of the card.
   */
  public String getDenomination() {
    return denomination;
  }

  /**
   * Gets the value stored in <code>value</code>.
   * 
   * @return the value of the card.
   */
  public int getValue() {
    return value;
  }

  /**
   * Changes the value of a card to a specified value.
   * 
   * @param value the new value of the card.
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * Formats a <code>String</code> to display the suit and denomination of the card in the standard
   * way of reading a card (<code>denomination</code> of <code>suit</code>).
   * 
   * @return a printable <code>String</code> of the card.
   * @see java.lang.Object#toString()
   */
  public String toString() {
    return denomination + " of " + suit;
  }
}
