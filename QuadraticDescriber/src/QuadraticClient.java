//Carl Chow
//This is the client side of the Quadratic Describer.
//9/22/17
import java.util.*;
public class QuadraticClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		double a=0, b=0, c=0;
		int test = 0;
		System.out.println("Welcome to Quadratic Describer!\nA quadratic equation is in the form ax^2+bx+c.");
		System.out.println("What is the value of the \"a\" coefficient?");
		String A = console.nextLine();
		while(test == 0) {
			try {
				a = Double.parseDouble(A);
				if(a==0) {
					System.out.println("It can't be a linear function! Try another value.");
					A = console.next();
				}
				else {
					test++;
				}
			}
			catch(NumberFormatException exception){
				System.out.println("Not a valid number. Try again.");
				A = console.next();
			}
		}
		System.out.println("Great choice. What is the value of the \"b\" coefficient?");
		String B = console.nextLine();
		while(test==1) {
			try {
				b = Double.parseDouble(B);
				test++;
			}
			catch(NumberFormatException exception){
				System.out.println("Not a valid number. Try again.");
				B = console.next();
			}
		}
		System.out.println("Excellent. What is the value of the \"c\" coefficient?");
		String C = console.next();
		while(test==2) {
			try {
				c = Double.parseDouble(C);
				test++;
			}
			catch(NumberFormatException exception){
				System.out.println("Not a valid number. Try again.");
				C = console.nextLine();
			}
		}
		System.out.println("Here is the description of the quadratic function:");
		Quadratic.quadrDescriber(a, b, c);
	}
}
