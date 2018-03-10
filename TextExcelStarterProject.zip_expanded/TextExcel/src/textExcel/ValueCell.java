package textExcel;

public class ValueCell extends RealCell{
	public ValueCell(String numVal) {
		super(numVal);
	}
	public  String abbreviatedCellText() {
		return (getDoubleValue() + "          ").substring(0, 10);
	}
	public double getDoubleValue() {
		return Double.parseDouble(fullCellText());
	}
}
