package textExcel;

public class TextCell implements Cell{
	private String text;
	public TextCell(String text) {
		this.text = text.substring(1, text.length()-1);
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		if(text.length() > 10) {
			return text.substring(0, 10);
		}
		return "          ".substring(0, 10-text.length()) + text;
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "\"" + text + "\"";
	}

}
