// John Maurer
// This class defines a PlayingCard object with a suit, a denomination, and a value (calculated via
// denomination)

public class PlayingCard {
  private String suit;
  private String denomination;
  private int value;

  public PlayingCard(String denomination, String suit) {
    this.suit = suit;
    this.denomination = denomination;

    switch (denomination) {
      case "Ace":
        value = 1;
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

  public String getSuit() {
    return suit;
  }

  public String getDenomination() {
    return denomination;
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return denomination + " of " + suit + ".";
  }
}
