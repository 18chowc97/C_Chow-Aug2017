package textExcel;

public class FormulaCell extends RealCell{
	public FormulaCell(String numVal) {
		super(numVal);
	}
	public String abbreviatedCellText() {
		return (getDoubleValue() + "         ").substring(0, 10);
	}
	public double getDoubleValue() {
		String[] calcArray = fullCellText().split(" ");
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
