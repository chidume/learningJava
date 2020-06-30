import java.util.Scanner;

public class RowOrColumnSum{
    public static String rowOrColumn(){
	Scanner in = new Scanner(System.in);
	boolean done = false;	
	int value = 0;
	String result= "";

	do{
	    System.out.print("row sum (0) OR column sum (1): ");
		if(in.hasNextInt()){
		    if((value = in.nextInt()) == 0){
			result = "row";
			done = true;
		    }else if(value == 1){
			result = "column";
			done = true;
		    }
		}else{
		    in.next();
		}
	}while(!done);
	
	return result;
    }
    
    public static int getTotal(int[][] array, int rows, int columns, String dimension, int index){
	int total = 0;	

	if(dimension.equals("row")){
	    for(int i = 0; i < rows; i++){
		total += array[index][i];
	    }
	}else if (dimension.equals("column")){
	    for(int i = 0; i < columns; i++){
		total += array[i][index];
	    }
	}

	return total;
    }

    public static void main(String[] args){
	String row = "ROW";
	String col = "COLUMN";
	final int ROWS = NeighborSum.getDimensions(row);
	final int COLUMNS= NeighborSum.getDimensions(col);

	int[][] array = new int[ROWS][COLUMNS];

	NeighborSum.populateArray(array);
	
	NeighborSum.printArray(array);

	//are we selecting a row or col?
	String rowOrCol = rowOrColumn();

	int count = rowOrCol.equals("row") ? ROWS : COLUMNS;

	//count variable enforces valid input within 0 - count
	int index = NeighborSum.getDimensions(rowOrCol, count);

	int total  = getTotal(array, ROWS, COLUMNS, rowOrCol, index);

	System.out.println(total);
    }
}