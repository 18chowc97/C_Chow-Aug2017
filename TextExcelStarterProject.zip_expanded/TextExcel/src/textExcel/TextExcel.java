package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
	    // Add your command loop here
		Spreadsheet sheet = new Spreadsheet();
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		while(!command.equals("quit")) {
			System.out.println(sheet.processCommand(command));
			command = input.nextLine();
		}
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(sheet.getGridText());
		//System.out.println(th.getText());
		input.close();
	}
}
