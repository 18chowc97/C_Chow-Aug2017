import java.util.Arrays;
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		int[] temp = null;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4 ,5};
		changeMe(num, strMain, arrMain);
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		int a = 1, b = 2;
		change(a, b);
		System.out.println(a +", "+b);
		String A = "a"; 
		String B = "b";
		change(A, B);
		System.out.println(A + B);
		int[] first = {1,2};
		int[] second = {3, 4};
		change(first, second);
		System.out.println(Arrays.toString(first) + ", "+ Arrays.toString(second));
		temp = first;
		first = second;
		second = temp;
		System.out.println(Arrays.toString(first) + ", "+ Arrays.toString(second));
	}
	public static void changeMe(int x, String str, int[] arr) {
		x++;
		str+=" First Period";
		arr[1] = 0;
	}
	public static void change(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
	public static void change(String x, String y) {
		String temp = x;
		x = y;
		y = temp;
	}
	public static void change(int[] x, int[] y) {
		int[] temp = x;
		x = y;
		y = temp;
	}
}
