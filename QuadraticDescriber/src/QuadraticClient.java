//Carl Chow
//This is the client side of the Quadratic Describer.
//9/22/17
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		double a = 0, b = 0, c = 0;
		int test = 0;
		String input = "";
		System.out.println("Welcome to Quadratic Describer!");
		do {
			System.out.println("What are the values of a, b, and c?");
			System.out.print("a: ");
			String A = console.next();
			while (test == 0) {
				try {
					a = Double.parseDouble(A);
					if (a == 0) {
						System.out.println("ERROR: It can't be a linear function! Try another value.");
						System.out.print("a: ");
						A = console.next();
					} else {
						test++;
					}
				} catch (NumberFormatException exception) {
					System.out.println("ERROR: Not a valid number: " + A);
					while (true) {
						System.out.println("Do you want to continue? (Type quit to end.)");
						input = console.next().toLowerCase();
						if (input.equals("yes")) {
							System.out.print("a: ");
							A = console.next();
							break;
						} else if (input.equals("quit")) {
							test = 5;
							break;
						} else {
							System.out.println("Not a valid response.");
						}
					}
				}
			}
			if (test == 1) {
				System.out.print("b: ");
				String B = console.next();
				while (true) {
					try {
						b = Double.parseDouble(B);
						test++;
						break;
					} catch (NumberFormatException exception) {
						System.out.println("ERROR: Not a valid number: " + B);
						while (true) {
							System.out.println("Do you want to continue? (Type quit to end.)");
							input = console.next().toLowerCase();
							if (input.equals("yes")) {
								System.out.print("b: ");
								B = console.next();
								break;
							} else if (input.equals("quit")) {
								test = 5;
								break;
							} else {
								System.out.println("Not a valid response.");
							}
						}
					}
				}
			}
			if (test == 2) {
				System.out.print("c: ");
				String C = console.next();
				while (true) {
					try {
						c = Double.parseDouble(C);
						test++;
						break;
					} catch (NumberFormatException exception) {
						System.out.println("ERROR: Not a valid number: " + C);
						while (true) {
							System.out.println("Do you want to continue? (Type quit to end.)");
							input = console.next().toLowerCase();
							if (input.equals("yes")) {
								System.out.print("c: ");
								C = console.next();
								break;
							} else if (input.equals("quit")) {
								test = 5;
								break;
							} else {
								System.out.println("Not a valid response.");
							}
						}
					}
				}
				Quadratic.quadrDescriber(a, b, c);
				System.out.println("Do you want to continue? (Type \"quit\" to exit.)");
				input = console.next().toLowerCase();
				while (test == 3) {
					if (input.equals("yes")) {
						test = 0;
					} else if (input.equals("quit")) {
						test = 6;
					} else {
						System.out.println("Not a valid input. Try again.");
						input = console.next().toLowerCase();
					}
				}
			}
		} while (test < 5);
	}
}
