
//Carl Chow
//This program takes a set of integer inputs until a person types "done" and prints certain calculations.
//10/3/17
import java.util.*;

public class PairProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter in your integers here. (Enter \"done\" once you are done entering numbers.)");
		//Instead of asking for the number of values to enter, the user enters values until
		//he/she enters "done", at which point the program stops taking values and calculates.
		Scanner console = new Scanner(System.in); 
		String input = "";
		int inputp = 0;
		int evensum = 0;
		int counter = 1;
		int max = 0;
		int evenmax = 0;
		int min = 0;
		do {
			System.out.print(counter + ": ");
			input = console.next();
			if (!input.equals("done")) {
				try {
					//Checks if input is an integer. 
					inputp = Integer.parseInt(input);
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
						if (evenmax == 0) {
							evenmax = inputp;
						} else if (evenmax < inputp){
							evenmax = inputp;
						}
					}
				} catch (NumberFormatException exception) {
					System.out.println("Invalid input. Try again");
					//Catches if input is not an integer.
				}
			}

		} while (!input.equals("done")); //Continues if user does not enter "done".
		if (counter == 1) {
			System.out.println("No numbers entered.");
		} else {
			System.out.println("Number of numbers: " + (counter - 1));
			System.out.println("Largest Number: " + max);
			System.out.println("Smallest Number: " + min);
			System.out.println("Sum of evens: " + evensum);
			System.out.println("Largest Even Number: " + evenmax);
		}
		console.close();
	}
}
