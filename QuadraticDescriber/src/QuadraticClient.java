
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
		System.out.println("Welcome to Quadratic Describer!");
		do {
			System.out.println("What are the values of a, b, and c?\n");
			while (test == 0) {
				System.out.print("a: ");
				String A = console.nextLine();
				//Uses nextLine to ensure that user cannot enter something like "1 2 1" as a valid input.
				//If it is guaranteed that user will enter a double value, 
				//the program can use console.nextDouble instead, and skip the try-catch.
				try {
					//Checks if input is a double and not something else. 
					a = Double.parseDouble(A);
					if (a == 0) {
						//Checks if input is linear function.
						System.out.println("ERROR: It can't be a linear function! Try another value.");
					} else {
						test++;
					}
				} catch (NumberFormatException exception) {
					System.out.println("ERROR: Not a valid number: " + A +"\nTry again.");
				}
			}
			while (test == 1) {
				System.out.print("b: ");
				String B = console.nextLine();
				try {
					//Checks for if second coefficient is a double.
					b = Double.parseDouble(B);
					test++;
				} catch (NumberFormatException exception) {
					System.out.println("ERROR: Not a valid number: " + B +"\nTry again.");
				}
			}
			while (test == 2) {
				System.out.print("c: ");
				String C = console.nextLine();
				try {
					//Checks if third coefficient is a double value.
					c = Double.parseDouble(C);
					System.out.println("\n" + Quadratic.quadrDescriber(a, b, c));
					//Prints the string output of the quadrDescriber method.
					test++;
				} catch (NumberFormatException exception) {
					System.out.println("ERROR: Not a valid number: " + C + "\nTry again.");
				}
			}
			while (test == 3) {
				System.out.println("Do you want to continue? (Type \"quit\" to exit.)");
				String finalcheck = console.nextLine().toLowerCase();
				//Checks whether user wants to continue or exit the program.
				if (finalcheck.contains("yes")) {
					test = 0;
				} else if (finalcheck.equals("quit")) {
					test = 6;
				} else {
					System.out.println("Not a valid input. Try again.");
				}
			}
		} while (test < 5);
		console.close();
		System.out.print("Done.");
	}
}
