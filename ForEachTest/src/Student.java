import java.util.*;
public class Student {
	private ArrayList<Double> grades = new ArrayList<>();
	private double sum;
	public Student(double a) {
		grades.add(a);
		sum = 0;
	}
	public ArrayList<Double> getGrades(){
		return grades;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double s) {
		sum = s;
	}
}
