//Carl Chow
//This class takes fractions and performs operations on them. 
//November 7, 2017
package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the String of fractions, with spaces between basic operator and number.");
		String input = in.nextLine();
		while (!input.equals("quit")) {
			System.out.println(produceAnswer(input));
			System.out.println("Enter another String, or type \"quit\" to exit.");
			input = in.nextLine();
		}
		in.close();
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		String[] splitInput = input.split(" ");
		if (splitInput.length < 3) {
			return "ERROR: Make sure to put spaces between operators and numbers.";
		}
		int[] answerArray = splitPart(splitInput[0]);
		for(int i = 0; i < splitInput.length - 2; i+=2) {
			// Places old answerArray into new answerArray and operates on it.
			answerArray = operate(answerArray, splitInput[i+1], splitPart(splitInput[i+2]));
			if(answerArray[0] == 1) {
				return "ERROR: Cannot have zero in a denominator.";
			}
			if(answerArray[0] == 2) {
				return "ERROR: Invalid Operation.";
			}
		}
		if(answerArray[1] == 0) {
			return "0";
		}
		if (answerArray[2] == 1) {
			return answerArray[1] + "";
		}
		return toMixedNum(answerArray[1], answerArray[2]);
	}
	public static int[] splitPart(String input) {
		int[] splitArray = { 0, 0, 1 };
		String[] secondFraction = input.split("_");
		String[] splitFraction = secondFraction[secondFraction.length - 1].split("/");
		if (secondFraction.length == splitFraction.length) {
			splitArray[0] = Integer.parseInt(secondFraction[0]);
		}
		if (splitFraction.length == 2) {
			splitArray[1] = Integer.parseInt(splitFraction[0]);
			splitArray[2] = Integer.parseInt(splitFraction[1]);
		}
		return splitArray;
	}
	public static int[] operate(int[]operand1, String operation, int[] operand2) {
		//Actually does the operation ( +, -, *, / ) to the String.
		int[] answer = new int[3];
		if(operand1[2] == 0 || operand2[2] == 0) {
			answer[0] = 1;
			return answer;
		}
		int numerator1 = (absValue(operand1[0] * operand1[2]) + operand1[1]);
		int numerator2 = (absValue(operand2[0] * operand2[2]) + operand2[1]);
		if(operand1[0] < 0) {
			numerator1 *= -1;
		}
		if(operand2[0] < 0) {
			numerator2 *= -1;
		}
		answer[2] = operand1[2] * operand2[2];
		if(operation.equals("+")) {
			answer[1] = (numerator1 * operand2[2]) + (numerator2 * operand1[2]);
		}
		else if(operation.equals("-")) {
			answer[1] = (numerator1 * operand2[2]) - (numerator2 * operand1[2]);
		}
		else if(operation.equals("*")) {
			answer[1] = numerator1 * numerator2;
		}
		else if(operation.equals("/")) {
			if(operand2[1] == 0 && operand2[0] == 0) {
				answer[0] = 1;
				return answer;
			}
			answer[2] = operand1[2] * numerator2;
			answer[1] = numerator1 * operand2[2];
		}
		else {
			answer [0] = 2;
			return answer;
		}
		int gcf = gcf(absValue(answer[1]), absValue(answer[2]));
		answer[1] /= gcf;
		answer[2] /= gcf;
		return answer;
	}
	public static int gcf(int greaterint, int smallerint) {
		//This method takes two positive integers and returns the greatest common factor (divisor).
		// It is also possible to use the Euclidean Algorithm.
		int gcf = 1;
		for (int i = 1; i<= min(smallerint, greaterint); i++) {
			if (isDivisibleBy(greaterint,i) && isDivisibleBy(smallerint,i)) {
				gcf = i;
			}
		}
		return gcf;
	}
	public static boolean isDivisibleBy(int dividend, int divisor){
		if (max(absValue(dividend), absValue(divisor)) % min(absValue(dividend), absValue(divisor)) == 0) {
			return true;
		}
		else {
			return false;
		}
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
			return wholenumber + "";
		}
		return mixednumber;
	}
}