//Carl Chow
//This class contains methods that split a String of ingredients to determine the components of a sandwich.
//due 10/30/17
import java.util.Arrays;

public class Split {
	public static String breadSplit(String sandwich) {
		//This method takes a String with no spaces and finds the ingredients between the bread.
		String[] split = sandwich.split("bread");
		if(split.length < 1) {
			return "Not enough to make a sandwich!";
		}
		int slices = split.length - 1;
		int sliceCount = split.length - 1;
		String answer = "Contents of sandwich: ";
		while (sandwich.substring(sandwich.length() - 5).equals("bread")) {
			// Checked if the input ends in "bread" since .split behaves differently with
			// "bread" in the front than at the end.
			if(sliceCount == split.length -1) {
				sliceCount +=1;
			}
			slices += 1;
			sandwich = sandwich.substring(0, sandwich.length()-5);
		}
		if (slices < 2) {
			//Only one piece of bread in the sandwich, or no bread
			return "Illegal Sandwich! Only "+ slices + " slice(s) of bread!";
		}
		for (int i = 1; i < sliceCount; i++) {
			answer = answer + split[i];
		}
		return answer +" ("+slices+" slices of bread)";
	}
	public static String spaceSplit(String sandwich) {
		//This method takes a String with spaces and finds the ingredients between the bread.
		//It is also possible to split between the spaces and call breadSplit, but the return value won't be formatted.
		int startIndex = -1, endIndex = -1;
		int slices = 0;
		String[] split = sandwich.split(" ");
		for (int i = 0; i < split.length; i++) {
			if (split[i].equals("bread")) {
				if(slices == 0) {
					startIndex = i + 1;
				}
				slices++;
				endIndex = i;
			}
		}
		String answer = "Contents of sandwich("+ slices+" slices of bread):  ";
		if(slices < 2) {
			return "Illegal Sandwich! Only " + slices + " slice(s) of bread!";
		}
		if(startIndex == endIndex-1) {
			// If nothing between the slices of bread.
			return "Illegal Sandwich! Nothing between slices of bread!";
		}
		for (int i = startIndex; i < endIndex; i++) {
			if (!split[i].equals("bread")) {
					answer += split[i] + ", ";
			}
		}
		return answer.substring(0, answer.length() - 2);
	}

	public static void main(String[] args) {
		String word = "breadbreadlettucetomatobaconmayohamcheesestuffbreadbreadhambreadhambreadbread";
		String spaceWord = "a b bread c bread bread bread d bread e bread f bread bread";
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
	
}