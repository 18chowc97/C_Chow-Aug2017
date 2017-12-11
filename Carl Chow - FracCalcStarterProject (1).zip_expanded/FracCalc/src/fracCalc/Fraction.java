package fracCalc;

public class Fraction {
	private int numerator;
	private int denominator = 1;
	private int whole;
	private String sign;
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
		if(whole == 0) {
			toMixedNum(numerator, denominator);
		}
		return "whole: " + whole + ", numerator: " + numerator + ", denominator: " + denominator;
	}
	//Helper Methods
	private void toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		whole = numerator/denominator;
		int negativecheck = (numerator * denominator)/absValue(numerator * denominator);
		this.numerator = absValue(numerator) % absValue(denominator);
		if (whole == 0) {
			//If absolute value of fraction is less than one, return this. 
			this.numerator = (negativecheck * absValue(numerator));
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
