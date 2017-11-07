package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner in = new Scanner(System.in);
    	String input = in.nextLine();
    	while(!input.equals("quit")){
    	System.out.println(produceAnswer(input));
    	input = in.nextLine();
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
        String[] splitInput = input.split(" ");
        String[] secondFraction = splitInput[2].split("_");
        String[] splitFraction = secondFraction[secondFraction.length - 1].split("/");
        if(secondFraction.length == splitFraction.length) {
        whole = secondFraction[0];
        }
        if(splitFraction.length == 2) {
        	numerator = splitFraction[0];
        	denominator = splitFraction[1];
        }
        return "whole:"+whole+" numerator:"+numerator+" denominator:"+denominator;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
