package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextExcel {

	public static void main(String[] args) {
		Spreadsheet sheet = new Spreadsheet();
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		while(!command.equalsIgnoreCase("quit")) {
			System.out.println(sheet.processCommand(command));
			command = input.nextLine();
		}
		input.close();
	}
}
