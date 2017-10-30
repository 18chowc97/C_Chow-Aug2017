import java.util.Arrays;

public class Split {
	public static String breadSplit(String sandwich) {
		String[] split = sandwich.split("bread");
		int slices = 0;
		String answer = "Contents of sandwich: ";
		if (sandwich.substring(sandwich.length() - 5).equals("bread")) {
			// Checked if the input ends in "bread" since .split behaves differently with
			// "bread" in the front than at the end.
			if (split.length < 2) {
				//Only one piece of bread at the end of sandwich, or no bread
				return "Illegal sandwich! Only " + split.length +" slice(s) of bread!";
			}
			slices = split.length;
			for (int i = 1; i < split.length; i++) {
				//If no contents, nothing will be added to the return value. 
				answer = answer + split[i];
			}
		} else {
			if (split.length < 3) {
				//Only one piece of bread in front or middle of the sandwich, or no bread
				return "Illegal Sandwich! Only "+ (split.length -1) + " slice(s) of bread!";
			}
			slices = split.length - 1;
			for (int i = 1; i < split.length - 1; i++) {
				answer = answer + split[i];
			}
		}
		return answer +" ("+slices+" slices of bread)";
	}
	public static String spaceSplit(String sandwich) {
		int startIndex = -1;
		int slices = 0;
		String[] split = sandwich.split(" ");
		for (int i = split.length - 1; i>=0; i--) {
			if (split[i].equals("bread")) {
				startIndex = i;
				slices++;
			}
		}
		String answer = "Contents of sandwich (with "+ slices+" slices of bread): ";
		if(slices < 2) {
			return "Illegal Sandwich! Only " + slices + " slice(s) of bread!";
		}
		for (int i = split.length - 1; i >= 0; i--) {
			if (split[i].equals("bread")) {
				if (startIndex == i - 1) {
					// If nothing between the slices of bread.
					return "Illegal Sandwich! Nothing between slices of bread!";
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
		String word = "lettucetomatobaconmayohamcheesestuffbreadham";
		String spaceWord = "a b bread c bread d bread e bread f bread";
		String[] arrayB = word.split("bread");
		String[] arrayS = spaceWord.split(" ");
		System.out.println(Arrays.toString("really I reallyreallyreally like really red apples really.".split("really")));
		System.out.println(Arrays.toString("reallyIreallyreallyreallylikereallyredapplesreally.".split("really")) + "\n");
		System.out.println(Arrays.toString(arrayB));
		System.out.println(breadSplit(word));
		System.out.println(Arrays.toString(arrayS));
		System.out.println(spaceSplit(spaceWord));
		//System.out.println(breadSplit(spaceSplit(spaceWord))); //Testing alternate method for spaceSplit.
	}
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
}