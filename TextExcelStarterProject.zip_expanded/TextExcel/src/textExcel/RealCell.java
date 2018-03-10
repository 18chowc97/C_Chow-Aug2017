package textExcel;

public abstract class RealCell implements Cell{
	String realValue;
	public RealCell(String numVal) {
		realValue = numVal;
	}
	public abstract String abbreviatedCellText(); 
	public String fullCellText() {
		return realValue;
	}
	public abstract double getDoubleValue();
}
