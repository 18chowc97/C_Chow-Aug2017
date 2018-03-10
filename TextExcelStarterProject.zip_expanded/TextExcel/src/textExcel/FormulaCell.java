package textExcel;

public class FormulaCell extends RealCell{
	public FormulaCell(String numVal) {
		super(numVal);
	}
	public String abbreviatedCellText() {
		return "0123456789";
	}
	public double getDoubleValue() {
		return 0;
	}
}
