package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator = 1;
	private int whole;
	public Fraction(String input) {
		String[] splitWhole = input.split("_");
		String[] splitFraction = splitWhole[splitWhole.length - 1].split("/");
		//Splits once by "_", then by "/".
		if (splitWhole.length == splitFraction.length) {
			//Either fraction contains both "_" and "/" or neither, for the whole number not to be zero.
			whole = Integer.parseInt(splitWhole[0]);
		}
		if (splitFraction.length == 2) {
			//If input contains a "/", it contains a fraction.
			numerator = Integer.parseInt(splitFraction[0]);
			denominator = Integer.parseInt(splitFraction[1]);
		}
	}
	public String toString() {
		String mixednumber = whole + "_" + numerator + "/" + absValue(denominator);
		if (whole == 0) {
			//If absolute value of fraction is less than one, return this. 
			mixednumber = numerator + "/" + absValue(denominator);
		}
		if(numerator == 0) {
			mixednumber = whole + "";
		}
		return mixednumber;
	}
	public void operate( String operation, Fraction secondFraction) {
		//Actually does the operations ( +, -, *, / ) to the String. Also handles divide by zero and some format errors.
		int[] operand1 = this.improper();
		int[] operand2 = secondFraction.improper();
		//Initializes answer array with denominator in answer[2].
		int[] answer = { operand1[0] * operand2[1], operand1[1] * operand2[1] };
		//Below, after checking for the type of operation, finds the appropriate if/else statement to execute.
		if (operation.equals("-")) {
			//Changes second operand to negative and does the addition operation.
			operand2[0] *= -1;
			operation = "+";
		}
		if(operation.equals("+")) {
			answer[0] += (operand2[0] * operand1[1]);
		}
		else if(operation.equals("*")) {
			answer[0] = operand1[0] * operand2[0];
		}
		else if(operation.equals("/")) {
			if(operand2[1] == 0 && operand2[0] == 0) {
				//If dividing by zero, eventually returns an error message. This takes care of "1 / 0".
				//answer[0] = 1;
			}
			answer[1] = operand1[1] * operand2[0];
		}
		int gcf = gcf(absValue(answer[0]), absValue(answer[1]));
		answer[0] /= gcf;
		answer[1] /= gcf;
		this.toMixedNum(answer[0], answer[1]);
	}
	//Helper Methods
	public int[] improper () {
		int[] fractionArray = { (absValue(whole * denominator) + numerator) , denominator };
		if (whole < 0) {
			fractionArray[0] *= -1;
		}
		return fractionArray;
	}
	private void toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		whole = numerator/denominator;
		this.numerator = absValue(numerator) % absValue(denominator);
		if (whole == 0 && numerator != 0) {
			//If absolute value of fraction is less than one, do this.
			int negativecheck = (numerator * denominator)/absValue(numerator * denominator);
			this.numerator *= negativecheck;
		}
	}
	private int gcf(int greaterint, int smallerint) {
		//This method takes two positive integers and returns the greatest common factor (divisor).
		int gcf = 1;
		for (int i = 1; i<= min(smallerint, greaterint); i++) {
			if (greaterint % i == 0 && smallerint % i == 0) {
				gcf = i;
			}
		}
		return gcf;
	}
	private int absValue (int number) {
		// This method takes an integer value and returns the absolute value of that integer. 
		return -min(number, -number);
	}
	private int min (int firstnum, int secondnum) {
		// This method takes two integers and returns the smaller of the two.
		if (firstnum <= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}
	}
}
