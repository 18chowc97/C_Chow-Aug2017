import java.util.Arrays;
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		int[] temp = null;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4 ,5};
		changeMe(num, strMain, arrMain);
		//Thought String would also be changed in method.
		//Only arrMain was changed by method, reference semantics.
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		int a = 1, b = 2;
		change(a, b);
		//Does not change anything, since primitives use value semantics
		System.out.println(a +", "+b);
		String A = "a"; 
		String B = "b";
		change(A, B);
		System.out.println(A + B);
		//Even though Strings are objects, they use value semantics, so did not change in the method.
		int[] first = {1, 2};
		int[] second = {3, 4};
		change(first, second);
		//Does not switch the arrays, impossible to change in a method with different references
		System.out.println(Arrays.toString(first) + ", "+ Arrays.toString(second));
		temp = first;
		first = second;
		second = temp;
		//However, works if directly assigning arrays to new reference.
		//The new reference works if in main.
		System.out.println(Arrays.toString(first) + ", "+ Arrays.toString(second));
		add(first);
		//Adding works, because it does not change reference in a method.
		System.out.println(Arrays.toString(first));
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
		int[] tem = x;
		x = y;
		y = tem;
	}
	public static void add(int[] x) {
		for (int i = 0; i< x.length;i++) {
			x[i] ++;
		}
	}
}
