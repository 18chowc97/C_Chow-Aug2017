package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
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
    public static String produceAnswer(String input){ 
    	String[] splitInput = input.split(" ");
    	if (splitInput.length < 3 || splitInput[0].equals("")) {
			// Checks if user inputed appropriate spacing. 
			return "ERROR: Make sure to put spaces only between at least one operator and two numbers.";
		}
		for(int i = 1; i < splitInput.length - 1; i+=2) {
			if (!splitInput[i].equals("+") &&!splitInput[i].equals("-") &&!splitInput[i].equals("*") &&!splitInput[i].equals("/")) {
				// Error Handling, for some weird input like "12 12 + 12".
				// Checks if fractions have operators in between them. 
				return "ERROR: Invalid Operation(s). Please enter numbers with appropriate operators between them.";
			}
		}
    	Fraction answer = new Fraction(splitInput[0]);
    	for (int i = 1; i < splitInput.length - 1; i+=2) {
    		//Operates on the first fraction object with subsequent fraction objects (allows multiple operations)
    		Fraction operand = new Fraction(splitInput[i + 1]);
    		answer.operate(splitInput[i], operand);
    	}
        return answer.toString();
    }
}
