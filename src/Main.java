import java.util.ArrayList;
import java.util.Scanner;

// typing the word "sysout", then pressing [Ctrl + Space] yields "System.out.println();"
// scan.nextLine(); consumes the rest of the line. Any time you go from entering a number to
// entering a string, add a "scan.nextLine();" before "String a = scan.nextLine();"

// Variable: A place in memory to store a value
// Scope: Describes the location in which a Variable is defined. A variable defined in a method is a
// "local" variable and is only accessible within that method. A variable defined in a class, but
// not a method, is a "global" variable and is accessible from all methods within the class.

// Byte: Consists of 8 bits, can represent 2^8 numbers, from -128 to 127 (integers)
// Short: 16 bits, 2^16 (integers)
// Int: 32 bits 2^32 (integers)
// Long: 64 bits, 2^64 (integers) Ends with a 'L'
// Float: 32 bit, single precision (0.1) (decimal) Ends with a 'f'
// Double: 64 bit, double precision (0.01) (decimal) Ends with a 'd'
// Boolean: Undefined size, holds either true or false, so it acts like a special bit
// Char: Single 16-bit Unicode character from '\u0000' (0) to '\uffff' (65,535) Written with
// singular quotes, NOT double quotes

// Ctrl + Shift + F ==> Enforce coding style (Google)

/**
 * A program integrating skills learned in COP 2006. Serves as the driver class of the program.
 * 
 * @author John Maurer
 *
 */
public class Main {

  /**
   * Runs the entire program. Serves as the first method of execution.
   * 
   * @param args an array of strings used to determine the environment the program runs in, usually
   *        empty unless the program is run through the console and the user specifies different
   *        codes.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");
    // utf-8 is a code that tells the Scanner what we plan on feeding into it.

    boolean goodInput = false;

    int selection = 0;

    do {
      goodInput = false;
      System.out
          .println("\nWelcome! Please type a number that matches in the menu. Press 0 to quit.");
      System.out.println("1. Run the 'bulkIntegration' method.");
      System.out.println("2. Play Blackjack.");
      System.out.println("Enter your selection: ");

      while (!goodInput) {
        try {
          selection = scan.nextInt();
          goodInput = true;
        } catch (Exception ex) {
          System.out.println("Please enter in an integer: ");
          scan.nextLine();
        }
      }

      scan.nextLine();
      System.out.println();

      switch (selection) {
        case 0:
          break;
        case 1:
          bulkIntegration();
          break;
        case 2:
          playBlackjack(scan);
          break;
        default:
          System.out.println("Please try again.");
      }

    } while (selection != 0);

    scan.close();
  }

  /**
   * Runs a console game of Blackjack. Contains the core of the game logic.
   * 
   * @param input a <code>Scanner</code> object, borrowed over from method <code>Main</code>.
   * @see #main(String[])
   */
  public static void playBlackjack(Scanner input) {
    boolean playAgain = true;
    boolean stand = false;
    int playerValue = 0;
    int dealerValue = 0;

    String yesOrNo = "y";
    ArrayList<PlayingCard> dealersHand = new ArrayList<PlayingCard>();
    ArrayList<PlayingCard> playersHand = new ArrayList<PlayingCard>();
    Deck blackjackDeck = new Deck();
    StringBuilder builder = new StringBuilder();

    do {
      // Set up game
      playerValue = 0;
      dealerValue = 0;

      stand = false;

      blackjackDeck.shuffle();
      // this is a method call. If the shuffle() method had a parameter, the argument for this
      // method call would be in between the parentheses.

      playersHand.add(blackjackDeck.dealCard());
      dealersHand.add(blackjackDeck.dealCard());
      playersHand.add(blackjackDeck.dealCard());
      dealersHand.add(blackjackDeck.dealCard());

      System.out.println("The first cards have been dealt. The dealer is showing a "
          + dealersHand.get(1).toString() + ".");
      System.out.println("Your cards are: " + playersHand.get(0).toString() + ", "
          + playersHand.get(1).toString());

      // Calculate card total value, particularly if the card is a GOD DAMN ACE
      playerValue = calculateBestScore(playersHand);
      dealerValue = calculateBestScore(dealersHand);

      System.out.println("Your current best score: " + playerValue);

      // Loop until player busts or doesn't want to hit anymore
      do {
        System.out.println("Would you like to hit? Y/N: ");
        yesOrNo = input.next();

        while (!yesOrNo.equalsIgnoreCase("y") && !yesOrNo.equalsIgnoreCase("n")) {
          System.out.println("Please type in 'Y' or 'N' for your selection: ");
          yesOrNo = input.next();
        }

        if (yesOrNo.equalsIgnoreCase("n")) {
          stand = true;
          System.out.println("You choose to stand.");
        } else {
          playersHand.add(blackjackDeck.dealCard());

          builder.setLength(0);

          for (int i = 0; i < playersHand.size(); i++) {
            if (i == (playersHand.size() - 1)) {
              // currentHand += playersHand.get(i).toString(); <--SpotBugs says this is bad because
              // using + in String concatenation creates a StringBuilder, appends the string
              // together, then converts the total back to a String. It's more efficient to make one
              // StringBuilder rather than creating one over and over again.
              builder.append(playersHand.get(i).toString());
            } else {
              builder.append(playersHand.get(i).toString());
              builder.append(", ");
            }
          }

          System.out.println("You draw a card. Your hand is now: " + builder.toString());

          playerValue = calculateBestScore(playersHand);

          System.out.println("Your current best score: " + playerValue);
        }

        if (playerValue >= 21) {
          stand = true;
        }

      } while (stand == false);

      // Loop until dealer reaches 16 (hit if 17) or busts
      System.out.println("The dealer reveals their full hand: " + dealersHand.get(0).toString()
          + ", " + dealersHand.get(1).toString());
      if (playerValue <= 21) {
        do {
          if (dealerValue > 17 || dealerValue > playerValue) {
            System.out.println("The dealer stands.");
          } else {
            dealersHand.add(blackjackDeck.dealCard());

            builder.setLength(0);

            for (int i = 0; i < dealersHand.size(); i++) {
              if (i == (dealersHand.size() - 1)) {
                builder.append(dealersHand.get(i).toString());
              } else {
                builder.append(dealersHand.get(i).toString());
                builder.append(", ");
              }
            }

            System.out
                .println("The dealer draws a card. Their hand now shows: " + builder.toString());

            dealerValue = calculateBestScore(dealersHand);
          }

        } while (dealerValue <= 17);
      } else {
        System.out.println("The dealer laughs at your busted plight. The dealer stands.");
      }

      // Compare and determine winner
      if (dealerValue > 21 && playerValue > 21) {
        System.out.println("You both busted. Its a draw.");
      } else if (dealerValue > 21) {
        System.out.println("The dealer busted. You win!");
      } else if (playerValue > 21) {
        System.out.println("You busted. The dealer wins.");
      } else if (playerValue > dealerValue) {
        System.out.println("Your total is higher than the dealer's. You win!");
      } else if (dealerValue > playerValue) {
        System.out.println("The dealer's total is higher than yours. The dealer wins.");
      } else if (playerValue == 21 && dealerValue == 21) {
        if (playersHand.size() == 2 && playersHand.get(0).getValue() == 10
            && playersHand.get(1).getValue() == 11) {
          System.out.println("You win with a Blackjack!");
        } else if (playersHand.size() == 2 && playersHand.get(0).getValue() == 11
            && playersHand.get(1).getValue() == 10) {
          System.out.println("You win with a Blackjack!");
        } else if (dealersHand.size() == 2 && dealersHand.get(0).getValue() == 11
            && dealersHand.get(1).getValue() == 10) {
          System.out.println("The dealer wins with a Blackjack.");
        } else if (dealersHand.size() == 2 && dealersHand.get(0).getValue() == 11
            && dealersHand.get(1).getValue() == 10) {
          System.out.println("The dealer wins with a Blackjack.");
        } else {
          System.out.println("It's a draw.");
        }
      } else {
        System.out.println("It's a draw.");
      }

      // Prompt if user wants to play again
      System.out.println("Would you like to play again? Y/N: ");
      yesOrNo = input.next();

      while (!yesOrNo.equalsIgnoreCase("y") && !yesOrNo.equalsIgnoreCase("n")) {
        System.out.println("Please type in 'Y' or 'N' for your selection: ");
        yesOrNo = input.next();
      }

      if (yesOrNo.equalsIgnoreCase("y")) {
        playAgain = true;
      } else {
        playAgain = false;
      }

      for (int i = 0; i < playersHand.size(); i++) {
        blackjackDeck.addCard(playersHand.get(i));
      }

      for (int i = 0; i < dealersHand.size(); i++) {
        blackjackDeck.addCard(dealersHand.get(i));
      }

      playersHand.clear();
      dealersHand.clear();

    } while (playAgain);

  }

  /**
   * Calculates the best score given the current cards in a player's hand. The best score is the
   * highest score of cards possible without going over 21.
   * 
   * @param hand an <code>ArrayList</code> of type <code>PlayingCard</code> of the hand of a player.
   * @return the best possible score given the player's hand.
   */
  public static int calculateBestScore(ArrayList<PlayingCard> hand) {
    int total = 0;

    for (int i = 0; i < hand.size(); i++) {
      total += hand.get(i).getValue();
    }

    if (total > 21) {
      for (int i = 0; i < hand.size(); i++) {
        if (hand.get(i).getValue() == 11) {
          hand.get(i).setValue(1);
          total = calculateBestScore(hand);
        }
      }
    }

    return total;
  }

  /**
   * A method containing extra programming concepts not needed in the Blackjack game.
   */
  public static void bulkIntegration() {
    boolean isTrue = true;
    String myString = "HEya";
    final int MY_NUMBER = 7;
    // CheckStyle shows a warning here since it doesn't like the CONSTANT_CASE formatting required
    // by the Google Style Guide. Prof. Vanselow requested for the Google Style guide to be honored.

    // the keyword "final" means that this variable cannot be changed later.
    // MY_NUMBER will always be the number it is assigned to on this line, regardless of the code
    // after this line.

    double myDouble = 2.3;

    System.out.println(
        "Welcome to this integration project! If you tune in long enough, it'll turn into a game of"
            + " Blackjack!");
    System.out.println("Boolean: isTrue = " + isTrue);
    System.out.println("String: myString = " + myString);
    System.out.println("Int: MY_NUMBER = " + MY_NUMBER);
    System.out.println("Double: myDouble = " + myDouble);

    myString = myString.toLowerCase();
    // .toLowerCase returns a string where all the letters are lower case. There's an upper case
    // method that works similarly to this one.

    String mySubstring = myString.substring(0, 1);
    // .substring returns a string that is within the range of the given string. In this example,
    // "HEya" from 0 to 1 will return "H" as a new string.

    System.out.println("String: mySubstring = " + mySubstring);

    String yesNo = mySubstring.equals("H") ? "Yes" : "No";
    // Using == compares the locations in memory of two objects.

    System.out.println(yesNo);

    while (yesNo.equals("Yes")) {
      if (isTrue && 1 > 0) {
        yesNo = "No";
        break;
        // This causes the loop to end and for execution to continue outside of the statement it
        // resides in.
      } else {
        yesNo = "No";
        continue; // This causes the loop to immediately shift to the next iteration of the loop.
      }
    }

    myDouble += 3 + 4 - 2 * 8 / 3 % 5 + myDouble++ + myDouble--;
    // Operator precedence is essentially the order of operators. The order goes along the lines of
    // post-fix, unary, multiplicative, additive, relational, conditional, and finally assignment.

    if (mySubstring.compareTo(myString) >= 1) {
      // .compareTo returns an integer that represents the lexicographic distance one string is from
      // another. If mySubstring is larger than myString lexicographically, it will return a
      // positive number. If they're the same, it will return 0. If mySubstring is smaller, it will
      // return a negative number)

      System.out.println(
          "\"" + mySubstring + "\" is lexicographically bigger than \"" + myString + "\".");
    } else if (mySubstring.compareTo(myString) == 0) {
      System.out.println(
          "\"" + mySubstring + "\" is lexicographically the same as \"" + myString + "\".");
    } else {
      System.out.println(
          "\"" + mySubstring + "\" is lexicographically smaller than \"" + myString + "\".");
    }

    int dubToInt = (int) myDouble;
    // This is an example of casting. By putting (int) before myDouble, I will be able to put the
    // double into an integer. The 2.3 will lose its .3 and just become 2.

    System.out.println("myDouble being casted to an integer results in: " + dubToInt);

    int[] myArray = new int[10];

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = (i + 1);
      builder.append(myArray[i]);
      builder.append(", ");
    }

    String listOfNumbers = builder.toString();

    System.out.println("myArray: " + listOfNumbers);

    int smallest = myArray[0];
    int accumulator = 0;
    int target = 6;
    for (int i : myArray) {
      System.out.println("Loop " + i);
    }

    for (int i = 0; i < myArray.length; i++) {
      accumulator += myArray[i];

      if (smallest > myArray[i]) {
        smallest = myArray[i];
      }

      if (myArray[i] == target) {
        System.out.println("The number 6 is located at index " + i);
      }
    }

    System.out.println("The total of the array is " + accumulator);
    System.out.println("The smallest value of the array is " + smallest);

    int[][] my2DArray = new int[10][10];

    for (int row = 0; row < my2DArray.length; row++) {
      for (int col = 0; col < my2DArray[0].length; col++) {
        my2DArray[row][col] = 5 * row * col;
      }
    }

    target = 80;

    for (int row = 0; row < my2DArray.length; row++) {
      for (int col = 0; col < my2DArray[0].length; col++) {
        if (my2DArray[row][col] == target) {
          System.out
              .println("The number 80 is located at array coordinates (" + row + ", " + col + ")");
        }
      }
    }
  }

}
