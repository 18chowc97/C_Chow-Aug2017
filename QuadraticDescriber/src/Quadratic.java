/* Carl Chow
 * This is the function section of the Quadratic Describer.
 * 9/22/17
 */
public class Quadratic {
	public static void quadrDescriber(double a, double b, double c) {
		if(a < 0) {
			System.out.println("The parabola opens downard.");
		}
		else {
			System.out.println("The parabola opens upward.");
		}
		System.out.println("The vertex is " + vertex(a, b, c) + ".");
		System.out.println("The function's roots (x-intercepts): " + quadForm(a, b, c));
	}
	public static String vertex(double a, double b, double c) {
		double x = round2(-b/(2*a));
		double y = round2((square(b)/(4 * a) - (square(b))/(2 * a) + c));
		return "("+x+", "+y+")";
	}
	public static int square (int operand) {
		// This method takes an integer and returns its square.
		return operand * operand;
	}
	public static double square (double operand) {
		// This method takes an integer and returns its square.
		return operand * operand;
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
	public static double discriminant (double a, double b, double c) {
		//This method takes the coefficients of a quadratic equation in standard form and returns the discriminant.
		double discriminant = (b * b) - 4 * a * c;
		return discriminant;
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
	public static double sqrt(double operand) {
		// This method takes a double value and returns an approximation of its square root, without recursion.
		if (operand < 0) {
			throw new IllegalArgumentException ("Inappropriate negative value: " + operand);
		}
		double guess = 1;
		while (absValue(operand - (guess * guess)) >= 0.005){
			guess = 0.5 * (operand/guess + guess);
		}
		return round2(guess);
	}
	public static String quadForm(double a, double b, double c) {
		// This method takes the coefficient values of a quadratic and returns its roots.
		double discriminant = discriminant(a, b, c);
		if (discriminant < 0) {
			return "no real roots";
		}
		else if (discriminant == 0) {
			return round2(-b/(2 * a)) + "";
		}
		else {
			return round2((-b + sqrt(discriminant))/(2 * a)) + " and " + round2(((-b - sqrt(discriminant))/(2 * a)));
		}
	}
}
