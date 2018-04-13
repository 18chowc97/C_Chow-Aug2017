//Carl Chow
//Cell that extends for other numerical cells
package textExcel;

public abstract class RealCell implements Cell, Comparable<Object>{
	String realValue;
	public RealCell(String numVal) {
		realValue = numVal;
	}
	public abstract String abbreviatedCellText(); 
	public String fullCellText() {
		return realValue;
	}
	public abstract double getDoubleValue();
	public int compareTo(Object o) { //for Checkpoint 6
		RealCell r = (RealCell) o;
		double compare = this.getDoubleValue() - r.getDoubleValue();
		return (int)(compare/Math.abs(compare));
	}
}
