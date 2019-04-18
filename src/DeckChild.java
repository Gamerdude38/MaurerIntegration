// Inheritance occurs when a class, such as this one, builds on an already existing class. This
// allows for ease of coding, so that the programmer doesn't have to type the same code in every
// class
/**
 * Demonstrates inheritance of the <code>Deck.java</code> class.
 * 
 * @author John Maurer
 *
 */
public class DeckChild extends Deck {

  /**
   * Constructs a <code>DeckChild</code> object by inheriting fields from <code>Deck.java</code>.
   */
  public DeckChild() {
    super();
  }

  /**
   * Adds a specified <code>PlayingCard</code> to <code>deck</code>.
   * 
   * @deprecated Merely used as a visual example to override methods from other classes.
   * @see Deck#addCard()
   */
  public void addCard() {
    System.out.println("HAH! You thought you could ADD a card!");
  }
}
