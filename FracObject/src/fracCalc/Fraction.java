//Carl Chow
//Fraction Class for FracCalc
//December 12, 2017
package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator = 1;
	private int whole;

	public Fraction(String input) {
		String[] splitWhole = input.split("_");
		String[] splitFraction = splitWhole[splitWhole.length - 1].split("/");
		// Splits once by "_", then by "/".
		if (splitWhole.length == splitFraction.length) {
			// Either fraction contains both "_" and "/" or neither, for the whole number not to be zero.
			whole = Integer.parseInt(splitWhole[0]);
		}
		if (splitFraction.length == 2) {
			// If input contains a "/", it contains a fraction.
			numerator = Integer.parseInt(splitFraction[0]);
			denominator = Integer.parseInt(splitFraction[1]);
		}
	}

	public String toString() {
		if (denominator == 0) {
			return "ERROR: Zero in denominator.";
		}
		int gcf = gcf(absValue(numerator), absValue(denominator));
		numerator /= gcf;
		denominator /= gcf;
		int wholenumber = numerator / denominator;
		int remaindernumer = absValue(numerator) % absValue(denominator);
		String mixednumber = wholenumber + "_" + remaindernumer + "/" + absValue(denominator);
		if (wholenumber == 0 && numerator != 0) {
			// If absolute value of fraction is less than one, return this.
			int negativecheck = (numerator * denominator) / absValue(numerator * denominator);
			mixednumber = (negativecheck * absValue(numerator)) + "/" + absValue(denominator);
		}
		if (remaindernumer == 0) {
			mixednumber = wholenumber + "";
		}
		return mixednumber;
	}

	public void operate(String operation, Fraction secondFraction) {
		// Actually does the operations ( +, -, *, / ) to the String.
		int[] operand1 = this.toImproper();
		int[] operand2 = secondFraction.toImproper();
		// Initializes answer array with denominator in answer[1].
		int[] answer = { operand1[0] * operand2[1], operand1[1] * operand2[1] };
		if (operation.equals("-")) {
			// Changes second operand to negative and does the addition operation.
			operand2[0] *= -1;
			operation = "+";
		}
		if (operation.equals("+")) {
			answer[0] += (operand2[0] * operand1[1]);
		} else if (operation.equals("*")) {
			answer[0] = operand1[0] * operand2[0];
		} else if (operation.equals("/")) {
			answer[1] = operand1[1] * operand2[0];
			if (operand2[1] == 0 || operand2[0] == 0) {
				// If dividing by zero, eventually returns an error message. This takes care of "1 / 0".
				answer[1] = 0;
			}
		}
		this.whole = 0;
		this.numerator = answer[0];
		this.denominator = answer[1];
	}

	// Helper Methods
	private int[] toImproper() {
		int[] fractionArray = { (absValue(whole * denominator) + numerator), denominator };
		if (whole < 0) {
			fractionArray[0] *= -1;
		}
		return fractionArray;
	}

	private int gcf(int greaterint, int smallerint) {
		// This method takes two positive integers and returns the greatest common factor (divisor).
		int gcf = 1;
		for (int i = 1; i <= min(smallerint, greaterint); i++) {
			if (greaterint % i == 0 && smallerint % i == 0) {
				gcf = i;
			}
		}
		return gcf;
	}

	private int absValue(int number) {
		// This method takes an integer value and returns the absolute value of that integer.
		return -min(number, -number);
	}

	private int min(int firstnum, int secondnum) {
		// This method takes two integers and returns the smaller of the two.
		if (firstnum <= secondnum) {
			return firstnum;
		} else {
			return secondnum;
		}
	}
}