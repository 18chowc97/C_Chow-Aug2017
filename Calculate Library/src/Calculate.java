/*
 * Carl Chow
 * September 5, 2017
 * This is a library that will contain various mathematical methods.
 * Overloaded methods likely used to also accept doubles as parameters.
 */
public class Calculate {
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
		// This method takes a radian value and converts it to degrees (unrounded).
		double degree = (radian * 180)/3.14159;
		return degree;
	}
	public static double toRadians (double degree) {
		//This method takes a degree value and converts it to radians.
		double radian = (degree * 3.14159)/180;
		return radian;
	}
	public static double discriminant (double a, double b, double c) {
		//This method takes the coefficients of a quadratic equation in standard form and returns the discriminant.
		double discriminant = (b * b) - 4 * a * c;
		return discriminant;
	}
	public static double discriminant (int a, int b, int c) {
		//This method takes integer coefficients of a quadratic equation in standard form and returns the discriminant.
		return (double)(square(b) - 4 * a * c);
	}
	public static String toImproperFrac (int wholenumber, int numerator, int denominator) {
		//This method takes a mixed number and returns an improper fraction of the same value. 
		//This assumes both numerator and denominator values are written properly.
		//e.g. You would not write a mixed number -3_-1/2 or -3_1/-2. The method treats this the same as -3_1/2.
		if (denominator == 0) {
			throw new IllegalArgumentException("Zero as denominator");
		}
		int negativecheck = (numerator * denominator)/absValue(numerator * denominator);
		int impropernumerator = (absValue(wholenumber * denominator)) + absValue(numerator);
		String improperfraction = impropernumerator + "/" + denominator;
		if (wholenumber < 0) {
			improperfraction = "-" + improperfraction;
		}
		if (wholenumber == 0) {
			improperfraction = (negativecheck * absValue(numerator)) + "/" + absValue(denominator);
		}
		return improperfraction;
	}
	public static String toMixedNum (int numerator, int denominator) {
		//This method takes an improper fraction and returns a mixed number of the same value.
		if (denominator == 0) {
			throw new IllegalArgumentException("Zero as denominator");
		}
		int wholenumber = numerator/denominator;
		int negativecheck = (numerator * denominator)/absValue(numerator * denominator);
		int remaindernumer = absValue(numerator) % absValue(denominator);
		String mixednumber = wholenumber + "_" + remaindernumer + "/" + absValue(denominator);
		if (wholenumber == 0) {
			//If absolute value of fraction is less than one, return this. 
			mixednumber = (negativecheck * absValue(numerator)) + "/" + absValue(denominator);
		}
		return mixednumber;
	}
	public static String foil (int firstco, int secondco, int thirdco, int fourthco, String variable) {
		// This method takes the coefficient and constant values of a factored quadratic equation
		// and returns a quadratic equation in standard form.
		int a = firstco * thirdco;
		int b = (firstco * fourthco) + (secondco * thirdco);
		int c = (thirdco * fourthco);
		String stringb = String.valueOf(b);
		String stringc = String.valueOf(c);
		if (b >= 0) {
			stringb = "+" + b;
		}
		//Formats the "bx" and "c" portion of the string.
		//However, still leaves the variable even if the coefficient is zero.
		if (c >= 0) {
			stringc = "+" + c;
		}
		String quadratic = a + variable + "^2" + stringb + variable + stringc;
		return quadratic;
	}
	// Part 2
	public static boolean isDivisibleBy(int dividend, int divisor){
		// This method takes two integers and checks if one integer is divisible into the other.
		if (dividend == 0 || divisor == 0) {
			throw new IllegalArgumentException ("Inappropriate values: "+ divisor +", "+ dividend);
		}
		//This method takes the larger of the two values as the dividend, and the smaller as divisor.
		//i.e. Both isDivisibleBy(8, 2) and isDivisibleBy(2, 8) will return true
		//because it is known that a larger integer will never divide into a smaller integer without remainder.
		if (max(absValue(dividend), absValue(divisor)) % min(absValue(dividend), absValue(divisor)) == 0) {
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
	public static int absValue (int integer) {
		//This method takes an integer value and returns the absolute value of that integer.
		if (integer >= 0) {
			return integer;
		}
		else {
			return -1 * integer;
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
		//Leaves up to thousandths place and multiplies absolute value by 1000.
		double roundedup = rounded - (rounded % 10);
		if (rounded % 10 >= 5) {
			//If thousandths place (currently ones) is greater than 5, add one to hundredths place.
			roundedup += 10;
		}
		if (decimal < 0) {
			roundedup *= -1;
		}
		//Note: If the rounded answer ends in zero (e.g. 1.20), Java removes the trailing zero (1.2).
		return roundedup/1000;
	}
	//Part 3
	public static double exponent(double base, int exponent) {
		//This method takes two double values and takes one value to power of another, assuming the exponent is positive.
		double basepower = 1;
		if (exponent < 0) {
			//Algorithm's fault, not math's
			//Can also return [1/b^(|x|)] if negative exponent
			throw new IllegalArgumentException("Negative exponent: " + exponent);
		}
		for (int i = 1; i <= exponent;i++) {
			basepower *= base;
		}
		return basepower;
	}
	public static int factorial (int integer) {
		// This method takes a positive integer and returns its factorial (n!).
		if (integer < 0) {
			//Only checks if parameter is negative, and not if integer.
			//May require a String parameter to do that. 
			throw new IllegalArgumentException("Negative integer: "+ integer);
		}
		if (integer == 0 || integer == 1) {
			return 1;
		}
		for (int i = integer - 1; i > 1; i--) {
			integer *=i;
		}
		return integer;
	}
	public static boolean isPrime(int integer) {
		//This method takes a positive integer and checks whether it is a prime number.
		if (integer <= 0) {
			//Again, only checks if input is negative, and not if actually an integer.
			throw new IllegalArgumentException("Inappropriate value: " + integer);
		}
		if(integer == 1) {
			return false;
		}
		boolean test = true;
		for (int i = 2; i < integer; i++) {
			if (isDivisibleBy(integer, i)) {
				test = false;
			}
		}
		return test;
	}
	public static int gcf(int greaterint, int smallerint) {
		//This method takes two positive integers and returns the greatest common factor (divisor).
		// It is also possible to use the Euclidean Algorithm.
		if (greaterint <= 0 || smallerint <= 0) {
			throw new IllegalArgumentException("Illegal number values: "+greaterint+", "+smallerint);
		}
		int gcf = 1;
		for (int i = 1; i<= min(smallerint, greaterint); i++) {
			if (isDivisibleBy(greaterint,i) && isDivisibleBy(smallerint,i)) {
				gcf = i;
			}
		}
		return gcf;
	}
	public static double sqrt(double operand) {
		// This method takes a double value and returns an approximation of its square root, without recursion.
		if (operand < 0) {
			throw new IllegalArgumentException ("Inappropriate negative value: " + operand);
		}
		double guess = 1;
		while (absValue(operand - (guess * guess)) >= 0.005){
			//Can also change the required 0.005 to a smaller value for greater accuracy.
			guess = 0.5 * (operand/guess + guess);
		}
		return round2(guess);
	}
	public static String quadForm(int a, int b, int c) {
		// This method takes the coefficient values of a quadratic and returns its roots.
		if (a == 0) {
			//Checks if equation is actually quadratic first.
			throw new IllegalArgumentException ("not a quadratic equation");
		}
		double discriminant = discriminant(a, b, c);
		if (discriminant < 0) {
			return "no real roots";
		}
		else if (discriminant == 0) {
			//One repeated root.
			return round2(-b/(2 * a)) + "";
		}
		else {
			return round2((-b + sqrt(discriminant))/(2 * a)) + " and " + round2((-b - sqrt(discriminant))/(2 * a));
		}
	}
}

