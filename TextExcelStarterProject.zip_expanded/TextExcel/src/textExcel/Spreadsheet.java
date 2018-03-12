package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray = new Cell[20][12];
	public Spreadsheet() {
		clear("clear");
	}
	@Override
	public String processCommand(String command){
		String[] split = command.split(" ", 3);
		if(split[0].length() == 0) {
			return "";
		}
		if(split[0].toLowerCase().contains("clear")) {
			clear(split[split.length - 1]);
		}
		else if(split.length == 1) {
			return getCell(new SpreadsheetLocation(split[0])).fullCellText();
		}
		else if(split[1].equals("=")) {
			Location update = new SpreadsheetLocation(split[0]);
			updateCell(update.getRow(), update.getCol(), split[2]);
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
	
	private void clear(String cell) {
		if(cell.equalsIgnoreCase("clear")){
			for(int i = 0; i < cellArray.length; i++) {
				for(int j = 0; j < cellArray[i].length; j++) {
					cellArray[i][j] = new EmptyCell();
				}
			}
		}
		else {
			Location clearedCell = new SpreadsheetLocation(cell);
			cellArray[clearedCell.getRow()][clearedCell.getCol()] = new EmptyCell();
		}
	}
	
	private void updateCell(int row, int col, String condition) {
		if(condition.startsWith("\"") && condition.endsWith("\"")){
			cellArray[row][col] = new TextCell(condition);
		}
		else if(condition.endsWith("%")) {
			cellArray[row][col] = new PercentCell(condition);
		}
		else if(condition.startsWith("(") && condition.endsWith(")")) {
			cellArray[row][col] = new FormulaCell(condition);
		}
		else {
			cellArray[row][col] = new ValueCell(condition);
		}
	}

}
