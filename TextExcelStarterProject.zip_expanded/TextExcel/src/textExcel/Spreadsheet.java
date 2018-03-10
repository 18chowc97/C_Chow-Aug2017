package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray = new Cell[20][12];
	public Spreadsheet() {
		clear();
	}
	@Override
	public String processCommand(String command){
		String[] split = command.split(" ", 3);
		if(split[0].length() == 0) {
			return "";
		}
		if(split[0].toLowerCase().contains("clear")) {
			if(split.length == 1) {
				clear();
			}
			else {
				Location clearedCell = new SpreadsheetLocation(split[split.length - 1]);
				cellArray[clearedCell.getRow()][clearedCell.getCol()] = new EmptyCell();
			}
		}
		else if(Character.isLetter(split[0].charAt(0)) && Character.isDigit(split[0].charAt(1))) {
			//extensive test for error handling if user types something that isn't a command
			if(split.length == 1) {
				return getCell(new SpreadsheetLocation(split[0])).fullCellText();
			}
			Location updateCell = new SpreadsheetLocation(split[0]);
			if(split[2].startsWith("\"") && split[2].endsWith("\"")){
				cellArray[updateCell.getRow()][updateCell.getCol()] = new TextCell(split[2]);
			}
			else if(Character.isDigit(split[2].charAt(0)) || Character.isDigit(split[2].charAt(1))) {
				if(split[2].endsWith("%")) {
					cellArray[updateCell.getRow()][updateCell.getCol()] = new PercentCell(split[2]);
				}
				else {
					cellArray[updateCell.getRow()][updateCell.getCol()] = new ValueCell(split[2]);
				}
			}
			else if(split[2].startsWith("(") && split[2].endsWith(")")) {
				cellArray[updateCell.getRow()][updateCell.getCol()] = new FormulaCell(split[2]);
			}
		}
		return this.getGridText();
	}

	@Override
	public int getRows(){
		return 20;
	}

	@Override
	public int getCols(){
		return 12;
	}

	@Override
	public Cell getCell(Location loc){
		return cellArray[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		// TODO Auto-generated method stub
		String grid = "   |";
		for(char c = 'A'; c <= 'L'; c++) {
			grid += c + "         |";
		}
		grid += "\n";
		for(int i = 1; i <= 20; i++) {
			grid += (i + "  ").substring(0, 3) + "|";
			for(int j = 0; j < 12; j++) {
				grid += cellArray[i-1][j].abbreviatedCellText() + "|";
			}
			grid += "\n";
		}
		return grid;
	}
	
	private void clear() {
		for(int i = 0; i < cellArray.length; i++) {
			for(int j = 0; j <cellArray[i].length; j++) {
				cellArray[i][j] = new EmptyCell();
			}
		}
	}

}
