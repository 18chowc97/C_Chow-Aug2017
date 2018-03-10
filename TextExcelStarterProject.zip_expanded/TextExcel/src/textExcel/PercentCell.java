package textExcel;

public class PercentCell extends ValueCell{
	public PercentCell(String numVal) {
		super(Double.parseDouble(numVal.substring(0, numVal.length() - 1))/100 + "");
	}
	public String abbreviatedCellText() {
		String converted = (Double.parseDouble(fullCellText()) * 100 + "");
		String truncated = converted.substring(0, converted.indexOf('.'));
		if(truncated.length() > 9) {
			truncated.substring(0, 9);
		}
		return (truncated + "%         ").substring(0, 10);
	}
}
