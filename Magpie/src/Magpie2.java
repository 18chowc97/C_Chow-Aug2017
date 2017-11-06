
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statementc) {
		String statement = statementc.toLowerCase();
		String response = "";
		if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} 
		else if(statement.indexOf("dreyer") > -1 
				|| statement.indexOf("knox") > -1
				|| statement.indexOf("lamont") > -1){
			response = "Sounds like an excellent teacher";
		}
		else if(statement.indexOf("school") > -1) {
			response = "Don't mention that around here.";
		}
		else if(statement.indexOf("where") > -1
			|| statement.indexOf("when") > -1
			|| statement.indexOf("why") > -1){
				response = "Google it";
			}
		else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "That's something to think about.";
		} else if (whichResponse == 5) {
			response = "Far out, dude.";
		}

		return response;
	}
}
