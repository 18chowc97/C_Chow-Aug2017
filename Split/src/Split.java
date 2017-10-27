import java.util.Arrays;

public class Split {
	public static String breadSplit(String s) {
				/*
				 * Write a method that take in a string like
				 * "applespineapplesbreadlettucetomatobaconmayohambreadcheese" describing a
				 * sandwich use String.split to split up the sandwich by the word "bread" and
				 * return what's in the middle of the sandwich and ignores what's on the outside
				 * What if it's a fancy sandwich with multiple pieces of bread?
				 */
		String[] split = s.split("bread");
		String answer = "Contents of sandwich: ";
		if(s.substring(s.length()-5, s.length()).equals("bread")) {
			//Checked if the input ends in "bread" since .split behaves differently with "bread" in the front than in back.
			if(split.length < 2) {
				return "Illegal sandwich!";
			}
			for(int i = 1;i<split.length;i++) {
				answer=answer+split[i];
			}
		}
		else {
			if(split.length < 3) {
				return "Illegal Sandwich!";
			}
			for(int i = 1;i<split.length-1;i++) {
				answer=answer+split[i];
			}
		}
		return answer;
	}
	public static String spaceSplit(String s) {
				/* pt.2
				 * Write a method that take in a string like
				 * "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
				 * describing a sandwich use String.split to split up the sandwich at the
				 * spaces, " ", and return what's in the middle of the sandwich and ignores
				 * what's on the outside Again, what if it's a fancy sandwich with multiple
				 * pieces of bread?
				 */
		int startIndex = -1;
		String answer = "Contents of sandwich: ";
		String[] split = s.split(" ");
		for(int i = 0;startIndex == -1;i++) {
			try {
				if (split[i].equals("bread")) {
					startIndex = i;
				}
			}catch(ArrayIndexOutOfBoundsException exception){
				return "Illegal Sandwich!";
			}
		}
		for(int i = split.length -1;i>=0;i--) {
			if(split[i].equals("bread")) {
				if(startIndex==i-1 || startIndex == i) {
					return "Illegal Sandwich!";
				}
				for(int j = startIndex + 1;j < i;j++) {
					if(!split[j].equals("bread")) {
						answer += split[j] + ", ";
					}
				}
				i = -1;
			}
		}
		return answer.substring(0, answer.length()-2);
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
		String word = "lettucetomatobaconmayohamcheesestuffham";
		String spaceWord = "a bread b c bread d bread e f";
		String[] array = word.split("bread");
		String[] arrayS = spaceWord.split(" ");
		System.out.println(Arrays.toString("really I reallyreallyreally like really red apples really.".split("really")));
		System.out.println(Arrays.toString("reallyIreallyreallyreallylikereallyredapplesreally.".split("really"))+"\n");
		System.out.println(Arrays.toString(array));
		System.out.println(breadSplit(word));
		System.out.println(Arrays.toString(arrayS));
		System.out.println(spaceSplit(spaceWord));
	}
	/*
	public static void mystery(int x) {
		System.out.print(x%10);
		if(x/10!=0) {
			mystery(x/10);
			System.out.println();
		}
		System.out.print(x%10);
	}
	*/
}