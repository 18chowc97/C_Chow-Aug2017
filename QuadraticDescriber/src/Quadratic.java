/* Carl Chow
 * This is the function section of the Quadratic Describer.
 * 9/22/17
 */
public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		//New Version that Returns a String that describes a quadratic function
		//by taking an input of three doubles that represent the quadratic coefficients.
		String B = "";
		String C = "";
		if (b > 0) {
			B = " + " + b + " x";
		}
		else if(b < 0){
			B = " - " + absValue(b)+" x";
		}
		if (c > 0) {
			C = " + " + c;
		}
		else if(c<0){
			C = " - " + absValue(c);
		} //Formats the function correctly.
		String graphdesc = "Descripton of Graph of :\ny = "+a+" x^2"+B+C;
		if(a < 0) {
			graphdesc = graphdesc + "\nOpens: Down";
		}
		else {
			graphdesc = graphdesc + "\nOpens: Up";
		} // Checks which direction it opens.
		String symaxis = "\nAxis of Symmetry: x = " + round2(-b/(2*a));
		String vertex = "\nVertex: " + vertex(a, b, c); //Uses vertex method below.
		String xintercept = "\nX-Intercept(s): " + quadForm(a, b, c);
		String yintercept = "\nY-Intercept: " + c;
		//Returns graph description as a string value.
		return graphdesc + symaxis + vertex + xintercept + yintercept;
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
		if (a==0) {
			throw new IllegalArgumentException ("not a quadratic equation");
		}
		double discriminant = discriminant(a, b, c);
		if (discriminant < 0) {
			return "no real roots / x-intercepts";
		}
		else if (discriminant == 0) {
			return round2(-b/(2 * a)) + "";
		}
		else {
			return round2((-b + sqrt(discriminant))/(2 * a)) + " and " + round2(((-b - sqrt(discriminant))/(2 * a)));
		}
	}
	//Below is the Old Version of quadrDescriber that is a Void method. Find the new version above.
			//It's called quadDescriber now instead of quadrDescriber to avoid confusion. 
			//This method takes three quadratic coefficients as doubles and prints out a graph description. 
	/*
	public static void quadDescriber(double a, double b, double c) {
		String B = "";
		String C = "";
		if (b > 0) {
			B = " + " + b + " x";
		}
		else if(b < 0){
			B = " - " + absValue(b)+" x";
		}
		if (c > 0) {
			C = " + " + c;
		}
		else if(c<0){
			C = " - " + absValue(c);
		} //Formats the function correctly.
		System.out.println("Description of Graph of :");
		System.out.println("y = "+a+" x^2"+B+C);
		if(a < 0) {
			System.out.println("Opens: Down");
		}
		else {
			System.out.println("Opens: Up");
		} // Checks which direction it opens.
		System.out.println("Axis of Symmetry: x = " + round2(-b/(2*a)));
		System.out.println("Vertex: " + vertex(a, b, c)); //Uses vertex method below.
		System.out.println("X-Intercept(s): " + quadForm(a, b, c));
		System.out.println("Y-Intercept: " + c);
	}
	*/
}
