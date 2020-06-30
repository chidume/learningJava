import java.util.Scanner;
import java.util.Arrays;

public class NeighborSum{
    public static int getDimensions(String string){
	boolean done = false;
	int dimension = 0;
	Scanner in = new Scanner(System.in);

	do{
	    System.out.print(string + " dimensions: ");
	    if(in.hasNextInt()){
		if((dimension = in.nextInt()) > -1){
		    done = true;
		}
	    }else{
		in.next();
	    }
	}while(!done);

	return dimension;
    }

    public static int getDimensions(String string, int rowCount){
	boolean done = false;
	int dimension = 0;
	Scanner in = new Scanner(System.in);

	do{
	    System.out.print("Which " + string + ": ");
	    if(in.hasNextInt()){
		if((dimension = in.nextInt()) > -1 && dimension < rowCount){
		    done = true;
		}	
	    }else{
		in.next();
	    }
	}while(!done);

	return dimension;
    }

    public static void populateArray(int[][] array){
	final int BOUND = 100;
	
	for(int i = 0; i < array.length; i++){
	   for(int j = 0; j < array[i].length; j++){
		array[i][j] = (int)(Math.random() * BOUND);
	   }
	}
    }

    public static void printArray(int[][] array){
	for(int i = 0; i < array.length; i++){
	   for(int j = 0; j < array[i].length; j++){
		if(j > 0){ System.out.print("  |  ");}
		System.out.printf("%3d",array[i][j]);
	   }
	   System.out.println();
	}
    }

    public static int neighborSum(int[][] array,int row, int column, int i, int j){
	int total  = 0;

	if(i < row - 1){ total += array[i + 1][j]; }	//adds bottom neighbor

	if(i > 0){ total += array[i - 1][j]; }		//adds top neighbor

	if(j < column - 1){ total += array[i][j + 1]; }	//adds right neighbor

	if(j > 0){ total += array[i][j - 1]; };		//adds left neighbor

	return total;
    }	

    public static void main(String[] args){
	String row = "ROW";
	String col = "COLUMN";
	final int ROWS = getDimensions(row);
	final int COLUMNS= getDimensions(col);
	
	int[][] array = new int[ROWS][COLUMNS];

	populateArray(array);
	
	printArray(array);

	System.out.println("What index: ");
	int i = getDimensions(row, ROWS);
	int j = getDimensions(col, COLUMNS);
	
	int total = neighborSum(array, ROWS, COLUMNS, i, j);

	System.out.println("Sum of neighbors: " + total);
    }
}