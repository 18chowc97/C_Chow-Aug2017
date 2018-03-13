package textExcel;

public class FormulaCell extends RealCell{
	String[] calcArray;
	public FormulaCell(String numVal, String[] convertedVal) {
		super(numVal);
		calcArray = convertedVal;
	}
	public String abbreviatedCellText() {
		return (getDoubleValue() + "         ").substring(0, 10);
	}
	public double getDoubleValue() {
		//for PEMDAS, use arrayList
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
}
