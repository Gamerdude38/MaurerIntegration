import java.util.Scanner;

//John Maurer
// A program integrating skills learned in COP 2006.

//typing the word "sysout", then pressing [Ctrl + Space] yields "System.out.println();"
//scan.nextLine(); consumes the rest of the line. Any time you go from entering a number to entering a string, add a "scan.nextLine();" before "String a = scan.nextLine();"

//Variable: A place in memory to store a value
//Scope: Describes the location in which a Variable is defined. A variable defined in a method is a "local" variable and is only accessible within that method. A variable defined in a class, but not a method, is a "global" variable and is accessible from all methods within the class.

//Byte: Consists of 8 bits, can represent 2^8 numbers, from -128 to 127 (integers)
//Short: 16 bits, 2^16 (integers)
//Int: 32 bits 2^32 (integers)
//Long: 64 bits, 2^64 (integers) Ends with a 'L'
//Float: 32 bit, single precision (0.1) (decimal) Ends with a 'f'
//Double: 64 bit, double precision (0.01) (decimal) Ends with a 'd'
//Boolean: Undefined size, holds either true or false, so it acts like a special bit
//Char: Single 16-bit Unicode character from '\u0000' (0) to '\uffff' (65,535) Written with singular quotes, NOT double quotes

public class Main {

	public static void main(String[] args) {
		boolean isTrue = true;
		String myString = "HEya";
		final int myNumber = 7; //the keyword "final" means that this variable cannot be changed later. myNumber will always be the number it is assigned to on this line, regardless of the code after this line.
		double myDouble = 2.3;
		
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("Welcome to this integration project!");
		System.out.println(isTrue);
		System.out.println(myString);
		System.out.println(myNumber);
		System.out.println(myDouble);
		
		scan.close();
	}

}
