package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray = new Cell[20][12];
	public Spreadsheet() {
		clear();
	}
	@Override
	public String processCommand(String command){
		String[] split = command.split(" ");
		if(split[0].toLowerCase().contains("clear")) {
			if(split.length == 1) {
				clear();
			}
			else {
				Location loc = new SpreadsheetLocation(split[split.length-1]);
				cellArray[loc.getRow()][loc.getCol()] = new EmptyCell();
			}
		}
		else if(split.length == 1) {
			return getCell(new SpreadsheetLocation(split[split.length-1])).fullCellText();
		}
		else if(command.contains("=")) {
			if(split[2].startsWith("\"") && split[split.length-1].endsWith("\"")){
				for(int i = 2; i < split.length - 1;i++) {
					split[2] += " " + split[i+1];
				}
				cellArray[(new SpreadsheetLocation(split[0])).getRow()][(new SpreadsheetLocation(split[0])).getCol()] = new TextCell(split[2]);
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
