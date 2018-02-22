import java.util.*;
public class StudentRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student x = new Student(1);
		Student y = new Student(2);
		ArrayList<Student> room = new ArrayList<>();
		room.add(x);
		room.add(y);
		System.out.println(x.getSum());
		System.out.println(y.getSum());
		for (Student s : room) {
			for (double num: s.getGrades()) {
				s.setSum(num);
			}
		}
		System.out.println(x.getSum());
		System.out.println(y.getSum());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(10);
		for (int n:list) {
			System.out.print(n);
		}
	}

}
