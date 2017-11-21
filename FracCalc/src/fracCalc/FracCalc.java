//Carl Chow
//This class takes fractions and performs operations on them. 
//November 7, 2017
package fracCalc;

import java.util.*;

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

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to test your code.
	// e.g. String input ==> "1/2 + 3/4" e.g. return ==> "1_1/4"

	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		if (input.contains("(") || input.contains(")")) {
			// We don't do parentheses, or PEMDAS.
			return "ERROR: We don't do parentheses.";
		}
		String[] splitInput = input.split(" ");
		int testString = 0;
		if (splitInput.length < 3) {
			// Checks if user inputed appropriate spacing. 
			return "ERROR: Make sure to put spaces between at least one operator and two numbers.";
		}
		for(int i = 1; i < splitInput.length; i++) {
			if (splitInput[i].equals("+") ||splitInput[i].equals("-") ||splitInput[i].equals("*") ||splitInput[i].equals("/")) {
				testString++;
			}
		}
		if (splitInput.length - 1 != 2 * testString) {
			// Error Handling, for some weird input like "12 12 + 12".
			// Checks if number of fractions matches the number of operators. (#operators = #fractions - 1)
			return "ERROR: Invalid Operations. Enter numbers with appropriate operators between them.";
		}
		// Splits the first operator into whole, numerator, and denominator parts. 
		int[] answerArray = splitPart(splitInput[0]);
		for(int i = 0; i < splitInput.length - 2; i+=2) {
			// Places old answerArray into new answerArray and operates on it (permits multiple operations).
			answerArray = operate(answerArray, splitInput[i+1], splitPart(splitInput[i+2]));
			if (Arrays.equals(answerArray, null)) {
				return "ERROR: Incorrect Formatting";
			}
			//Error checking, answerArray[0] is an element that checks if something went wrong.
			if(answerArray[0] == 1) {
				return "ERROR: Cannot have zero in a denominator.";
			}
			if(answerArray[0] == 2) {
				return "ERROR: If you have a mixed number, the fractional part should not be written with negatives.";
			}
		}
		if (answerArray[2] == 1) { 
			//Formats the Strings correctly, e.g. 0 instead of 0/1 or 12 instead of 12/1.
			return answerArray[1] + "";
		}
		if (answerArray[1] == 0) {
			return "0";
		}
		return toMixedNum(answerArray[1], answerArray[2]);
	}
	public static int[] splitPart(String input) {
		//Takes one of the fraction inputs and converts its contents to an array.
		int[] splitArray = { 0, 0, 1 };
		String[] secondFraction = input.split("_");
		String[] splitFraction = secondFraction[secondFraction.length - 1].split("/");
		//Splits once by "_", then by "/".
		try {
			//Error handling erroneous inputs, such as if a person types "#4 + $5", the program will catch the exception. 
			//If error handling removed, try-catch is not needed, since we'd assume the user formats the input correctly.
			if(secondFraction.length > 2) {
				//If person inputs more than one "_" in a row, throw an exception.
				Integer.parseInt(input);
			}
			//Places appropriate integers into the fraction array.
			if (secondFraction.length == splitFraction.length) {
				splitArray[0] = Integer.parseInt(secondFraction[0]);
			}
			if (splitFraction.length == 2) {
				splitArray[1] = Integer.parseInt(splitFraction[0]);
				splitArray[2] = Integer.parseInt(splitFraction[1]);
			}
			else {
				Integer.parseInt(input);
			}
		}catch (NumberFormatException e) {
			splitArray = null;
		}
		return splitArray;
	}
	public static int[] operate(int[]operand1, String operation, int[] operand2) {
		//Actually does the operations ( +, -, *, / ) to the String.
		if (Arrays.equals(operand1, null) || Arrays.equals(operand2, null)) {
			//Here, a null array is code for something that went wrong, and the program throws an error message.
			return null;
		}
		int numerator1 = absValue(operand1[0] * operand1[2]) + operand1[1];
		int numerator2 = absValue(operand2[0] * operand2[2]) + operand2[1];
		//Checking if inputed numbers are negative or not.  
		if(operand1[0] < 0) {
			numerator1 *= -1;
		}
		if(operand2[0] < 0) {
			numerator2 *= -1;
		}
		int[] answer = { 0, numerator1 * operand2[2], operand1[2] * operand2[2] };
		if(operand1[2] == 0 || operand2[2] == 0) {
			//If zero in the denominator, turn answer[0], the "error checker" from 0 to 1.
			answer[0] = 1;
		}
		if((operand1[0] != 0 && (operand1[1] < 0 || operand1[2] < 0)) 
			|| (operand2[0] != 0 && (operand2[1] < 0 || operand2[2] < 0))){
			// If an operand is a mixed number formatted incorrectly, change answer[0] to 2.
			answer[0] = 2;
		}
		// Can split into two methods (+ and *), but here is more compact because there are some common 
		// calculations that can be moved out of the if statements for efficiency.
		if (operation.equals("-")) {
			//Changes second operand to negative and does the addition operation.
			numerator2 *= -1;
			operation = "+";
		}
		if(operation.equals("+")) {
			answer[1] += (numerator2 * operand1[2]);
		}
		else if(operation.equals("*")) {
			answer[1] = numerator1 * numerator2;
		}
		else if(operation.equals("/")) {
			if(operand2[1] == 0 && operand2[0] == 0) {
				//If dividing by zero, eventually returns an error message. 
				answer[0] = 1;
			}
			answer[2] = operand1[2] * numerator2;
		}
		int gcf = gcf(absValue(answer[1]), absValue(answer[2]));
		answer[1] /= gcf;
		answer[2] /= gcf;
		return answer;
	}
	// Below are Helper Methods from Calculate.
	public static int gcf(int greaterint, int smallerint) {
		//This method takes two positive integers and returns the greatest common factor (divisor).
		int gcf = 1;
		for (int i = 1; i<= min(smallerint, greaterint); i++) {
			if (greaterint % i == 0 && smallerint % i == 0) {
				gcf = i;
			}
		}
		return gcf;
	}
	public static int absValue (int number) {
		// This method takes a double value and returns the absolute value of that double. 
		if (number >= 0) {
			return number;
		}
		else {
			return -1 * number;
		}
	}
	public static int max (int firstnum, int secondnum) {
		// This method takes two integer values and returns the larger of the two.
		if (firstnum >= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}	
	}
	public static int min (int firstnum, int secondnum) {
		// This method takes two integers and returns the smaller of the two.
		if (firstnum <= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}
	}
	public static String toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		int wholenumber = numerator/denominator;
		int negativecheck = (numerator * denominator)/absValue(numerator * denominator);
		int remaindernumer = absValue(numerator) % absValue(denominator);
		String mixednumber = wholenumber + "_" + remaindernumer + "/" + absValue(denominator);
		if (wholenumber == 0) {
			//If absolute value of fraction is less than one, return this. 
			mixednumber = (negativecheck * absValue(numerator)) + "/" + absValue(denominator);
		}
		if(remaindernumer == 0) {
			mixednumber = wholenumber + "";
		}
		return mixednumber;
	}
	//Wow, a third of this was comments and error checking.
}