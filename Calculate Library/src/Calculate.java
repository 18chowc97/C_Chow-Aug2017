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
		int impropernumerator = (absValue(wholenumber) * absValue(denominator)) + absValue(numerator);
		String improperfraction = impropernumerator + "/" + denominator;
		if (wholenumber < 0) {
			improperfraction = "-" + improperfraction;
		}
		return improperfraction;
	}
	public static String toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		int wholenumber = numerator/denominator;
		int remaindernumer = absValue(numerator) % absValue(denominator);
		String improperfrac = wholenumber + "_" + remaindernumer + "/" + absValue(denominator);
		return improperfrac;
	}
	public static String foil (int firstco, int secondco, int thirdco, int fourthco, String variable) {
		// This method takes the coefficient and constant values of a factored quadratic equation
		// and returns a quadratic equation in standard form.
		int a = firstco * thirdco;
		int b = (firstco * fourthco) + (secondco * thirdco);
		int c = (thirdco * fourthco);
		String stringb = b + "";
		String stringc = c + "";
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
		// This method takes two integers and checks if one integer is divisible into the other,
		// with the first integer always being the dividend.
		if (dividend % divisor == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static double absValue (double number) {
		// This method takes a double value and returns the absolute value of that double. 
		if (number >= 0) {
			return number;
		}
		else {
			return -1 * number;
		}
	}
	public static int absValue (int number) {
		//This method takes an integer value and returns the absolute value of that integer.
		if (number >= 0) {
			return number;
		}
		else {
			return -1 * number;
		}
	}
	public static double max (double firstnum, double secondnum) {
		// This method takes two double values and returns the larger of the two.
		if (firstnum >= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
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
	public static double max (double firstnum, double secondnum, double thirdnum) {
		// This method takes three double values and returns the largest one.
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
		// This method takes two integers and returns the smaller of the two.
		if (firstnum <= secondnum) {
			return firstnum;
		}
		else {
			return secondnum;
		}
	}
	public static double round2(double decimal) {
		// This method takes a double and rounds it to two decimal places.
		double rounded = absValue(1000 * (decimal - (decimal % 0.001)));
		double roundedup = rounded - (rounded % 10);
		if (rounded % 10 >= 5) {
			roundedup += 10;
		}
		if (decimal < 0) {
			roundedup *= -1;
		}
		return roundedup/1000;
	}
	//Part 3
	public static double exponent(double base, double exponent) {
		//This method takes two double values and takes one value to power of another, assuming the exponent is positive.
		double basepower = base;
		for (int i = 1; i < exponent;i++) {
			basepower = basepower * base;
		}
		return basepower;
	}
	public static int factorial (int integer) {
		// This method takes a positive integer and returns its factorial (n!).
		for (int i = integer - 1; i >= 1; i--) {
			integer *=i;
		}
		return integer;
	}
	public static boolean isPrime(int integer) {
		//This method takes a positive integer and checks whether it is a prime number.
		boolean test = false;
		for (int i = 2;i<absValue(integer);i++) {
			if (isDivisibleBy(integer, i)) {
				test = false;
			}
			else {
				test = true;
			}
		}
		return test;
	}
	public static int gcf(int greaterint, int smallerint) {
		//This method takes two positive integers and returns the greatest common factor (divisor).
		// It is also possible to use Euclidean Algorithm.
		int gcf = 1;
		for (int i = 1; i<= smallerint; i++) {
			if (isDivisibleBy(greaterint,i) && isDivisibleBy(smallerint,i)) {
				gcf = i;
			}
		}
		return gcf;
	}
	public static double sqrt(double operand) {
		// This method takes a double value and returns an approximation of its square root, without recursion.
		double guess = 1;
		while (absValue(operand - (guess * guess)) >= 0.005){
			guess = 0.5 * (operand/guess + guess);
		}
		return round2(guess);
	}
}

