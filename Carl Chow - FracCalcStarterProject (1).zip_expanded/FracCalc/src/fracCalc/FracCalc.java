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
    
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] splitInput = input.split(" ");
    	Fraction oper1 = new Fraction(splitInput[0]);
    	Fraction oper2 = new Fraction(splitInput[2]);
    	oper1.operate(splitInput[1], oper2);
        return oper1.toString();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
