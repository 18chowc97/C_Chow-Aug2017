import java.util.Arrays;

public class Split {
	public static String breadSplit(String sandwich) {
		String[] split = sandwich.split("bread");
		String answer = "Contents of sandwich: ";
		if (sandwich.substring(sandwich.length() - 5).equals("bread")) {
			// Checked if the input ends in "bread" since .split behaves differently with
			// "bread" in the front than at the end.
			if (split.length < 2) {
				//Only one piece of bread at the end of sandwich
				return "Illegal sandwich!";
			}
			for (int i = 1; i < split.length; i++) {
				answer = answer + split[i];
			}
		} else {
			if (split.length < 3) {
				//Only one piece of bread in front or middle of the sandwich
				return "Illegal Sandwich!";
			}
			for (int i = 1; i < split.length - 1; i++) {
				answer = answer + split[i];
			}
		}
		return answer;
	}
	public static String spaceSplit(String s) {
		int startIndex = -1;
		String answer = "Contents of sandwich: ";
		String[] split = s.split(" ");
		if (s.indexOf("bread") == -1) {
			return "Illegal Sandwich!";
		}
		for (int i = 0; startIndex == -1; i++) {
			if (split[i].equals("bread")) {
				startIndex = i;
			}
		}
		for (int i = split.length - 1; i >= 0; i--) {
			if (split[i].equals("bread")) {
				if (startIndex == i - 1 || startIndex == i) {
					// Either only one piece of bread or nothing between the slices of bread.
					return "Illegal Sandwich!";
				}
				for (int j = startIndex + 1; j < i; j++) {
					if (!split[j].equals("bread")) {
						answer += split[j] + ", ";
					}
				}
				i = -1;
			}
		}
		return answer.substring(0, answer.length() - 2);
	}

	public static void main(String[] args) {
		// String.split();
		// It's a method that acts on a string, <StringName>.split(<String sp>);
		// Where sp is the string where the string splits
		// And it returns an array
		// Example: "I like apples!".split(" ");
		// it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		// it will split at the word "really" and return an array of ["I "," like ","
		// apples!"]
		// play around with String.split! what happens if you "I reallyreally like
		// apples".split("really") ?
		String word = "breadlettucetomatobreadbaconmayohamcheesestuffbreadham";
		String spaceWord = "a b bread c bread d e f";
		String[] arrayB = word.split("bread");
		String[] arrayS = spaceWord.split(" ");
		System.out.println(Arrays.toString("really I reallyreallyreally like really red apples really.".split("really")));
		System.out.println(Arrays.toString("reallyIreallyreallyreallylikereallyredapplesreally.".split("really")) + "\n");
		System.out.println(Arrays.toString(arrayB));
		System.out.println(breadSplit(word));
		System.out.println(Arrays.toString(arrayS));
		System.out.println(spaceSplit(spaceWord));
		System.out.println(breadSplit(spaceSplit(spaceWord))); //Testing alternate method for spaceSplit.
	}
	/*
	 * public static void mystery(int x) { 
	 * System.out.print(x%10); 
	 * if(x/10!=0) {
	 * mystery(x/10); System.out.println(); 
	 * } 
	 * System.out.print(x%10); }
	 */
}