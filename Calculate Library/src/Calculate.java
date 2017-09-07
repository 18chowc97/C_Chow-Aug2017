/*
 * Carl Chow
 * September 5, 2017
 * This is a library that will contain various mathematical methods.
 */
public class Calculate {
	static double pi = 3.14159;
	public static int square (int operand) {
		// This method takes an integer and returns its square.
		return operand * operand;
		//Or place operand * operand calculation into a variable
	}
	public static int cube (int operand) {
		// This method takes an integer and returns its cube.
		return operand * operand * operand;
	}
	public static double average (double firstvalue, double secondvalue) {
		// This method takes two double values and returns their average.
		double average = (firstvalue + secondvalue)/2;
		return average;
	}
	public static double average (double firstvalue, double secondvalue, double thirdvalue) {
		// This method takes three double values and returns their average.
		double average = (firstvalue + secondvalue + thirdvalue)/3;
		return average;
	}
	public static double toDegrees (double radian) {
		// This method takes a radian value and converts it to degrees.
		double degree = (radian * 180)/pi;
		return degree;
	}
	public static double toRadians (double degree) {
		//This method takes a degree value and converts it to radians.
		double radian = (degree * pi)/180;
		return radian;
	}
	public static double discriminant (double a, double b, double c) {
		//This method takes the coefficients of a quadratic equation in standard form and returns the discriminant.
		double discriminant = (b * b) - 4 * a * c;
		return discriminant;
	}
	public static String toImproperFrac (int wholenumber, int numerator, int denominator) {
		//This method takes a mixed number and returns an improper fraction of the same value. 
		int impropernumerator = (Math.abs(wholenumber) * Math.abs(denominator)) + Math.abs(numerator);
		String improperfraction = impropernumerator + "/" + denominator;
		if (wholenumber < 0) {
			improperfraction = "-" + improperfraction;
		}
		return improperfraction;
	}
	public static String toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		int wholenumber = numerator/denominator;
		int remaindernumer = Math.abs(numerator) % Math.abs(denominator);
		String improperfrac = wholenumber + "_" + remaindernumer + "/" + Math.abs(denominator);
		return improperfrac;
	}
	public static String foil (int firstco, int secondco, int thirdco, int fourthco, String variable) {
		int a = firstco * thirdco;
		int b = (firstco * fourthco) + (secondco * thirdco);
		int c = (thirdco * fourthco);
		String stringb = String.valueOf(b);
		String stringc = String.valueOf(c);
		if (b >= 0) {
			stringb = "+" + b;
		}
		if (c >= 0) {
			stringc = "+" + c;
		}
		String quadratic = a + variable + "^2" + stringb + variable + stringc;
		return quadratic;
	}
	public static boolean isDivisibleBy(int dividend, int divisor){
		if (dividend % divisor == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static double absValue (double number) {
		if (number >= 0) {
			return number;
		}
		else {
			return -1 * number;
		}
	}
	public static double max (double firstnum, double secondnum) {
		if (firstnum >= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}	
	}
	public static double max (double firstnum, double secondnum, double thirdnum) {
		if (firstnum >= secondnum) {
			if(firstnum >= thirdnum) {
				return firstnum;
			}
			else {
				return thirdnum;
			}
		}
		else {
			if(secondnum >= thirdnum) {
				return secondnum;
			}
			else {
				return thirdnum;
			}
		}
	}
	public static int min (int firstnum, int secondnum) {
		if (firstnum <= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}
	}
	public static double round2(double decimal) {
		double rounded = decimal - (decimal % 0.01);
		if (decimal % 0.01 >= 0.005) {
			rounded = rounded + 0.01;
			return rounded;
		}
		else {
			return rounded;
		}
	}
}
