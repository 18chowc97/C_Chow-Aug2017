package textExcel;

public abstract class RealCell implements Cell, Comparable<RealCell>{
	String realValue;
	public RealCell(String numVal) {
		realValue = numVal;
	}
	public abstract String abbreviatedCellText(); 
	public String fullCellText() {
		return realValue;
	}
	public abstract double getDoubleValue();
	public int compareTo(RealCell o) {
		double compare = this.getDoubleValue() - o.getDoubleValue();
		return (int)(compare/Math.abs(compare));
	}
}
