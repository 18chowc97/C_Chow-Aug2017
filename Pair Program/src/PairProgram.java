import java.util.*;

public class PairProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter in your integers here. (Enter \"done\" once you are done entering numbers.)");
		Scanner console = new Scanner(System.in);
		String input = "";
		int inputp = 0;
		int evensum = 0;
		int counter = 1;
		int max = 0;
		int evenmax = 1;
		int min = 0;
		do {
			System.out.print(counter + ": ");
			input = console.next();
			if (!input.equals("done")) {
				try {
				inputp = Integer.parseInt(input);
				}
				catch(NumberFormatException exception) {
					throw new InputMismatchException("Invalid Input");
				}
				if (counter == 1) {
					max = inputp;
					min = inputp;
				} else {
					if (inputp > max) {
						max = inputp;
					} else if (inputp < min) {
						min = inputp;
					}
				}
				counter++;
				if (inputp % 2 == 0) {
					evensum += inputp;
					if (evenmax == 1) {
						evenmax = inputp;
					} else {
						if (evenmax < inputp) {
							evenmax = inputp;
						}
					}
				}
			}
		} while (!input.equals("done"));
		System.out.println("Number of numbers: " + (counter - 1));
		System.out.println("Largest Number: " + max);
		System.out.println("Smallest Number: " + min);
		System.out.println("Sum of evens: " + evensum);
		System.out.println("Largest Even Number: " + evenmax);
		console.close();
	}

}
