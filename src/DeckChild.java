// John Maurer
// A completely and totally worthless class for Blackjack, but an example for inheritance.

// Inheritance occurs when a class, such as this one, builds on an already existing class. This
// allows for ease of coding, so that the programmer doesn't have to type the same code in every
// class
public class DeckChild extends Deck {

  public DeckChild() {
    super();
  }

  public void addCard() {
    System.out.println("HAH! You thought you could ADD a card!");
  }
}
