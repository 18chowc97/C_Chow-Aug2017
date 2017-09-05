//Carl Chow
//August 24, 2017
//Project 2 - Use print and println
public class Project2 {
	public static int Add (int n, int n2) {
		int sum = n + n2;
		return sum;
	}

	public static void main(String[] args) {
		// Testing Println and Print
		int a = 1, b = 2;
		int sum = Add(a, b);
		for (int i = 0; i <= 9; i++) {
			System.out.println(Add(i, i+1));
		}
	}

}
