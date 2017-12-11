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

	public static String produceAnswer(String input) {
		// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to test your code.
		// e.g. String input ==> "1/2 + 3/4" e.g. return ==> "1_1/4"
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
		// Splits the first operator into whole, numerator, and denominator parts. 
		int[] answerArray = splitPart(splitInput[0]);
		for(int i = 0; i < splitInput.length - 2; i+=2) {
			// Places old answerArray into new answerArray and operates on it (can perform multiple operations).
			answerArray = operate(answerArray, splitInput[i+1], splitPart(splitInput[i+2]));
			//Error checking, answerArray[0] is an element that checks if something went wrong.
			if(answerArray[0] == 1) {
				return "ERROR: Cannot have zero in a denominator.";
			}
			if(answerArray[0] == 2) {
				return "ERROR: If you have a mixed number, the fractional part should not be written with negatives.";
			}
		}
		if (answerArray[2] == 1 || answerArray[1] == 0) { 
			//Formats the Strings correctly, e.g. 0 instead of 0/1 or 12 instead of 12/1.
			return answerArray[1] + "";
		}
		return toMixedNum(answerArray[1], answerArray[2]);
	}
	public static int[] splitPart(String input) {
		//Takes one of the fraction inputs and converts its contents to an array.
		int[] splitArray = { 0, 0, 1 };
		String[] splitWhole = input.split("_");
		String[] splitFraction = splitWhole[splitWhole.length - 1].split("/");
		//Splits once by "_", then by "/".
		//Places appropriate integers into the fraction array.
		if (splitWhole.length == splitFraction.length) {
			//Either fraction contains both "_" and "/" or neither, for the whole number not to be zero.
			splitArray[0] = Integer.parseInt(splitWhole[0]);
		}
		if (splitFraction.length == 2) {
			//If input contains a "/", it contains a fraction.
			splitArray[1] = Integer.parseInt(splitFraction[0]);
			splitArray[2] = Integer.parseInt(splitFraction[1]);
		}
		return splitArray;
	}
	public static int[] operate(int[]operand1, String operation, int[] operand2) {
		//Actually does the operations ( +, -, *, / ) to the String. Also handles divide by zero and some format errors.
		int numerator1 = absValue(operand1[0] * operand1[2]) + operand1[1];
		int numerator2 = absValue(operand2[0] * operand2[2]) + operand2[1];
		//Checking if inputed numbers are negative or not.  
		if(operand1[0] < 0) {
			numerator1 *= -1;
		}
		if(operand2[0] < 0) {
			numerator2 *= -1;
		}
		//Initializes answer array with denominator in answer[2].
		int[] answer = { 0, 0, operand1[2] * operand2[2] };
		if(operand1[2] == 0 || operand2[2] == 0) {
			//If zero in the denominator, return an error message. This takes care of "1/0" as one fraction.
			answer[0] = 1;
		}
		if((operand1[0] != 0 && (operand1[1] < 0 || operand1[2] < 0)) || (operand2[0] != 0 && (operand2[1] < 0 || operand2[2] < 0))){
			// If an operand is a mixed number formatted incorrectly, e.g. 1_-1/2, returns an error message.
			answer[0] = 2;
		}
		//Below, after checking for the type of operation, finds the appropriate if/else statement to execute.
		if (operation.equals("-")) {
			//Changes second operand to negative and does the addition operation.
			numerator2 *= -1;
			operation = "+";
		}
		if(operation.equals("+")) {
			answer[1] = (numerator1 * operand2[2]) + (numerator2 * operand1[2]);
		}
		else if(operation.equals("*")) {
			answer[1] = numerator1 * numerator2;
		}
		else if(operation.equals("/")) {
			if(operand2[1] == 0 && operand2[0] == 0) {
				//If dividing by zero, eventually returns an error message. This takes care of "1 / 0".
				answer[0] = 1;
			}
			answer[1] = numerator1 * operand2[2];
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
		// This method takes an integer value and returns the absolute value of that integer. 
		return -min(number, -number);
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
}
