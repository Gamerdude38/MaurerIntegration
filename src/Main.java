import java.util.Scanner;

// John Maurer
// A program integrating skills learned in COP 2006. Driver class

/*
 * Foreword: I'm thinking of making a Blackjack card game. Or perhaps a collection of card games
 * using ASCII graphics This main class for the time being is serving as a way for me to at least
 * make sure I have the minimum requirements complete for the integration project milestones.
 * Hopefully by the time I actually sit down for a couple of hours to work on this, a lot of the
 * code here will actually be replaced by code that will actually run the game. I'm just going to
 * start with a PLayingCard class and go from there, pls don't be mad.
 */

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

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int selection = 0;

    do {
      System.out
          .println("Welcome! Please type a number that matches in the menu. Press 0 to quit.");
      System.out.println("1. Run the 'bulkIntegration' method.");
      System.out.println("2. Play Blackjack.");
      System.out.print("Enter your selection: ");

      selection = scan.nextInt();

      switch (selection) {
        case 0:
          break;
        case 1:
          bulkIntegration();
          break;
        case 2:
          playBlackjack();
          break;
        default:
          System.out.println("Please try again.");
      }

    } while (selection != 0);

    scan.close();
  }

  public static void playBlackjack() {
    System.out.println("Welcome to Casino Royale! \n");

    Deck blackjackDeck = new Deck();

    blackjackDeck.shuffle(); // this is a method call. If the shuffle() method had a parameter, the
    // argument for this method call would be in between the parentheses.

    System.out.println(blackjackDeck.toString());
    System.out.println("Drawn Card: " + blackjackDeck.dealCard().toString());
    System.out.println(blackjackDeck.toString());
  }

  public static void bulkIntegration() {
    boolean isTrue = true;
    String myString = "HEya";
    final int MY_NUMBER = 7; // the keyword "final" means that this variable cannot be changed
                             // later.
                             // MY_NUMBER will always be the number it is assigned to on this line,
                             // regardless of the code after this line.
    double myDouble = 2.3;

    System.out.println(
        "Welcome to this integration project! If you tune in long enough, it'll turn into a game of"
            + " Blackjack!");
    System.out.println("Boolean: isTrue = " + isTrue);
    System.out.println("String: myString = " + myString);
    System.out.println("Int: MY_NUMBER = " + MY_NUMBER);
    System.out.println("Double: myDouble = " + myDouble);

    myString = myString.toLowerCase(); // .toLowerCase returns a string where all the letters are
                                       // lower case. There's an upper case method that works
                                       // similarly to this one.

    String mySubstring = myString.substring(0, 1); // .substring returns a string that is within the
                                                   // range of the given string. In this example,
                                                   // "HEya" from 0 to 1 will return "H" as a new
                                                   // string

    System.out.println("String: mySubstring = " + mySubstring);

    String yesNo = mySubstring.equals("H") ? "Yes" : "No"; // Using == compares the locations in
                                                           // memory of two objects.
    System.out.println(yesNo);

    while (yesNo.equals("Yes")) {
      if (isTrue && 1 > 0) {
        yesNo = "No";
        break; // This causes the loop to end and for execution to continue outside of the statement
               // it resides in.
      } else {
        yesNo = "No";
        continue; // This causes the loop to immediately shift to the next iteration of the loop.
      }
    }

    myDouble += 3 + 4 - 2 * 8 / 3 % 5 + myDouble++ + myDouble--; // Operator precedence is
                                                                 // essentially the order of
                                                                 // operators. The order goes along
                                                                 // the lines of post-fix, unary,
                                                                 // multiplicitive, additive,
                                                                 // relational, conditional, and
                                                                 // finally assignment.

    if (mySubstring.compareTo(myString) >= 1) { // .compareTo returns an integer that represents the
                                                // lexicographic distance one string is from
                                                // another. If mySubstring is larger than myString
                                                // lexicographically, it will return a positive
                                                // number. If they're the same, it will return 0. If
                                                // mySubstring is smaller, it will return a negative
                                                // number)
      System.out.println(
          "\"" + mySubstring + "\" is lexicographically bigger than \"" + myString + "\".");
    } else if (mySubstring.compareTo(myString) == 0) {
      System.out.println(
          "\"" + mySubstring + "\" is lexicographically the same as \"" + myString + "\".");
    } else {
      System.out.println(
          "\"" + mySubstring + "\" is lexicographically smaller than \"" + myString + "\".");
    }

    int dubToInt = (int) myDouble; // This is an example of casting. By putting (int) before
                                   // myDouble, I will be able to put the double into an integer.
                                   // The 2.3 will lose its .3 and just become 2.

    System.out.println("myDouble being casted to an integer results in: " + dubToInt);
  }

}
