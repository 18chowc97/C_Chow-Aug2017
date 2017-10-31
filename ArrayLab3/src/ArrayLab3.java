//Carl Chow
//October 31, 2017
//This is a lab that contains methods to manipulate certain characteristics of the input arrays.
import java.util.*;
public class ArrayLab3 {
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arrSum = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arrSum[i] = arr1[i] + arr2[i];
		}
		return arrSum;
	}
	public static int[] append(int[] arr, int num) {
		int arrAppend[] = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			arrAppend[i] = arr[i];
		}
		arrAppend[arr.length] = num;
		return arrAppend;
	}
	public static int[] remove(int[] arr, int idx) {
		int[] arrRemove = new int[arr.length - 1];
		for(int i = 0; i < arr.length; i ++) {
			if(i < idx) {
				arrRemove[i] = arr[i];
			}
			else if(i > idx) {
				arrRemove[i-1] = arr[i];
			}
		}
		return arrRemove;
	}
	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i+=2) {
			sum += arr[i];
		}
		return sum;
	}
	public static void rotateRight(int[] arr) {
		int temp = arr[arr.length - 1];
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}

}
