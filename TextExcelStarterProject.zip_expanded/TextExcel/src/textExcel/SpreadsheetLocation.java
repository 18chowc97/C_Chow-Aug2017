package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	private int column;
	private int row;
	 public SpreadsheetLocation(String cellName){
		 // TODO: Fill this out with your own code
		 column = Character.toUpperCase(cellName.charAt(0)) - 'A';
		 row = Integer.parseInt(cellName.substring(1)) - 1;
	    }
    @Override
    public int getRow(){
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }

}
