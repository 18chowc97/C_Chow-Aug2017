import java.util.Scanner;

//A simple class to run the Magpie class.

public class MagpieRunner2 {

	// Create a Magpie, give it user input, and print its replies.

	public static void main(String[] args) {
		Magpie2 maggie = new Magpie2();

		System.out.println(maggie.getGreeting());
		Scanner in = new Scanner(System.in);
		String statement = in.nextLine();

		while (!statement.toLowerCase().equals("bye")) {
			if(statement.length()>0) {
				System.out.println(maggie.getResponse(statement));
			}
			else {
				System.out.println("Please say something to me.");
			}
			statement = in.nextLine();
		}
		in.close();
	}

}
