//Carl Chow
//4/13/18
//The main spreadsheet object actually accepts commands
package textExcel;
import java.util.*;

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray = new Cell[20][12];
	public Spreadsheet() {
		clear("clear");
	}
	@Override
	public String processCommand(String command){
		String[] split = command.split(" ", 3);
		if(split[0].length() == 0) { // if empty command, return empty String
			return "";
		}
		if(split[0].toLowerCase().contains("clear")) { // checks for both instances of "clear" command
			clear(split[split.length - 1]);
		}
		else if(split.length == 1) { // if user types in  just the cell name
			return getCell(new SpreadsheetLocation(split[0])).fullCellText();
		}
		else if(split[1].equals("=")) { // if the user types an assignment statement
			Location update = new SpreadsheetLocation(split[0]);
			updateCell(update.getRow(), update.getCol(), split[2], split[0]);
		}
		else if(split[0].toLowerCase().contains("sort")) { // if user types a sort command (Checkpoint 6)
			String[] endpoint = split[1].split("-");
			ArrayList<Cell> compArr = new ArrayList<Cell>();
			Location cL = new SpreadsheetLocation(endpoint[0]);
			Location cR = new SpreadsheetLocation(endpoint[1]);
			for(int i = cL.getRow(); i <= cR.getRow(); i++ ) {
				for(int j = cL.getCol(); j <= cR.getCol(); j++) {
					//uses end points to traverse selected cells and place them in order in an ArrayList
					int index = 0;
					for(Cell c: compArr) {
						if(cellArray[i][j] instanceof TextCell) {
							TextCell t = (TextCell) cellArray[i][j];
							if(t.compareTo(c) < 0) { 
								index++;
							} 
						} // we need an if/else because we implement Comparable interface on both RealCell and TextCell
						else if(cellArray[i][j] instanceof RealCell){
							RealCell r = (RealCell) cellArray[i][j];
							if(r.compareTo(c) < 0) {
								index++;
							}
						} // uses compareTo method to add certain cells in order by incrementing index
					}
					compArr.add(index, cellArray[i][j]);
				}
			}
			int placeholder = 0;
			if(split[0].endsWith("a") || split[0].endsWith("A")) {
				placeholder = 1 - compArr.size();
			} // if sorta instead of sortd, the loop increments in reverse, using Math.abs
			for(int i = cL.getRow(); i <= cR.getRow(); i++ ) {
				for(int j = cL.getCol(); j <= cR.getCol(); j++) {
					cellArray[i][j] = compArr.get(Math.abs(placeholder));
					placeholder++;
				}
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
		if(cell.equalsIgnoreCase("clear")){ // if the command is just "clear"
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
	
	private void updateCell(int row, int col, String condition, String CRCheck) {
		if(condition.startsWith("\"") && condition.endsWith("\"")){
			cellArray[row][col] = new TextCell(condition);
		}
		else if(condition.endsWith("%")) {
			cellArray[row][col] = new PercentCell(condition);
		}
		else if(condition.startsWith("(") && condition.endsWith(")")) {
			cellArray[row][col] = new FormulaCell(condition, cellArray, CRCheck);
		}
		else {
			cellArray[row][col] = new ValueCell(condition);
		}
	}

}
