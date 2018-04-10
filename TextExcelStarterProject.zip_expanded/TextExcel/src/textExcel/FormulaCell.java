package textExcel;
import java.util.*;

public class FormulaCell extends RealCell{
	private Cell[][] sheet;
	private static ArrayList<String> crTest = new ArrayList<String>(); //for Circular Reference Errors
	private int errorcheck; // also for Circular Reference Errors
	public FormulaCell(String numVal, Cell[][] sheet, String cellname) {
		super(numVal);
		this.sheet = sheet;
		crTest.add(cellname);
	}
	public String abbreviatedCellText() {
		return (getDoubleValue() + "         ").substring(0, 10);
	}
	public double getDoubleValue() {
		String[] calcArray = fullCellText().split(" ");
		if (!Character.isLetter(calcArray[1].charAt(calcArray[1].length() - 1))) {
			test(calcArray);
			if(errorcheck != 1) {
			for(int i = 1; i < calcArray.length; i+=2) {
				if(Character.isLetter(calcArray[i].charAt(0))) {
					calcArray[i] = getRCValue(calcArray[i]).getDoubleValue()+"";
				}
			}
			}
		}
		else {
			double total = 0; int counter = 0;
			String[] endpoint = calcArray[2].split("-");
			Location cL = new SpreadsheetLocation(endpoint[0]);
			Location cR = new SpreadsheetLocation(endpoint[1]);
			for(int c = cL.getRow(); c <= cR.getRow(); c++ ) {
				for(int j = cL.getCol(); j <= cR.getCol(); j++) {
					RealCell num = (RealCell)(sheet[c][j]);
					total += num.getDoubleValue();
					counter++;
				}
			}
			if (calcArray[1].equalsIgnoreCase("avg")) {
				total /= counter;
			}
			String[] temp = { "(", total + "",")"};
			calcArray = temp;
		}
		double answer = Double.parseDouble(calcArray[1]);
		for (int i = 2; i < calcArray.length - 1; i+=2) {
			if(calcArray[i].equals("+")) {
				answer += Double.parseDouble(calcArray[i + 1]);
			}
			else if(calcArray[i].equals("-")) {
				answer -= Double.parseDouble(calcArray[i + 1]);
			}
			else if(calcArray[i].equals("*")) {
				answer *= Double.parseDouble(calcArray[i + 1]);
			}
			else if(calcArray[i].equals("/")) {
				answer /= Double.parseDouble(calcArray[i + 1]);
			}
		}
		return answer;
	}
	
	public RealCell getRCValue(String location) {
		Location loc = new SpreadsheetLocation(location);
		return (RealCell)(sheet[loc.getRow()][loc.getCol()]);		
	}
	public void test (String[] text) { //for Circular Reference Errors
		for (int i = 1; i < text.length - 1; i+=2) {
			if(Character.isLetter(text[i].charAt(0)) && errorcheck != 1) {
				crTest.add(text[i]);
				for (String s: crTest) {
					if(crTest.indexOf(s) != crTest.lastIndexOf(s)) {
						errorcheck = 1;
					}
				}
				test(getRCValue(text[i]).fullCellText().split(" "));
			}
		}
		crTest.clear();
	}
}
