package textExcel;

public abstract class RealCell implements Cell{
	String realValue;
	public RealCell(String numVal) {
		realValue = numVal;
	}
	public abstract String abbreviatedCellText(); 
	public abstract String fullCellText();
	public abstract double getDoubleValue();
}
