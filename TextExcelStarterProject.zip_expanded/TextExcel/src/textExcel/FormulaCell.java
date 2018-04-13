//Carl Chow
//4/13/18
//Cell that takes equations and formulas, also contains sort command
package textExcel;
import java.util.*;

public class FormulaCell extends RealCell{
	private Cell[][] sheet;
	public FormulaCell(String numVal, Cell[][] sheet, String cellname) {
		super(numVal);
		this.sheet = sheet; 
	}
	public String abbreviatedCellText() {
		return (getDoubleValue() + "         ").substring(0, 10);
	}
	public double getDoubleValue() {
		String[] calcArray = fullCellText().split(" ");
		if (!Character.isLetter(calcArray[1].charAt(calcArray[1].length() - 1))) {
			// checks if array contains cell names, and replaces them with appropriate double values
			for(int i = 1; i < calcArray.length; i+=2) {
				if(Character.isLetter(calcArray[i].charAt(0))) {
					calcArray[i] = getRCValue(calcArray[i]).getDoubleValue()+"";
				}
			}
		}
		else { //if the first index is either average or sum command
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
		//calculates the answer with operations left to right, similar to FracCalc
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
}
