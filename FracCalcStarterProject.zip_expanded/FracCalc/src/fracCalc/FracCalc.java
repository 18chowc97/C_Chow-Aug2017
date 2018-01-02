//Carl Chow
//FracCalc but with objects
//December 10, 2017

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number String with spaces between basic operators and numbers.");
		String input = in.nextLine();
		while (!input.equals("quit")) {
			System.out.println(produceAnswer(input));
			System.out.println("Enter another String, or type \"quit\" to exit.");
			input = in.nextLine();
		}
		in.close();
		System.out.println("Done.");
	}

	public static String produceAnswer(String input) {
		String[] splitInput = input.split(" ");
		if (splitInput.length < 3 || splitInput[0].equals("")) {
			// Error Handling: Checks if user inputed appropriate spacing.
			return "ERROR: Make sure to put spaces only between at least one operator and two numbers.";
		}
		for (int i = 1; i < splitInput.length - 1; i += 2) {
			// Error Handling, for some weird input like "12 12 + 12".
			if (!splitInput[i].equals("+") && !splitInput[i].equals("-") && !splitInput[i].equals("*")
					&& !splitInput[i].equals("/")) {
				// Checks if fractions have operators in between them.
				return "ERROR: Invalid Operation(s). Please enter appropriate operators between the numbers.";
			}
		}
		Fraction answer = new Fraction(splitInput[0]);
		for (int i = 1; i < splitInput.length - 1; i += 2) {
			// Operates on the first fraction object with subsequent fraction objects (allows multiple operations)
			Fraction operand = new Fraction(splitInput[i + 1]);
			answer.operate(splitInput[i], operand);
		}
		return answer.toString();
	}
}
