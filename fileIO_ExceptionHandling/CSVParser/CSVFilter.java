import java.util.Scanner; 
import java.io.File;
import java.io.PrintWriter;	
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/*
    Recieves an input file and column names within
    and prints those columns into an output file
*/

public class CSVFilter{
    private Scanner console;
    private Scanner fileReader;
    private PrintWriter fileWriter;
    private String inFile;
    private String outFile;
    private int numOfColumns;
    private ArrayList<Integer> colsToBeFiltered;

    public CSVFilter(String inFile, String outFile) throws FileNotFoundException{
	console = new Scanner(System.in);
	fileReader = new Scanner(new File(inFile));
	fileWriter = new PrintWriter(outFile);
	this.inFile = inFile;
	this.outFile = outFile;
	numOfColumns = 0;
        colsToBeFiltered = new ArrayList<Integer>();	
    } 

    public void printColumnHeader() throws FileNotFoundException, NoSuchElementException{
	Scanner scanner = new Scanner(new File(inFile));

	try{
	    String columnHeader = scanner.nextLine();
	    displayColumnHeader(columnHeader);
	}finally{
	    scanner.close();
	}
    }

    /** the method accepts columnHeader, parses it and outputs
	columns in a numbered list
	@param columnHeader contains the header of the csv file	
    */
    private void displayColumnHeader(String columnHeader){
	final String REGEX = "\"|,";
	Scanner in = new Scanner(columnHeader);

	while(in.hasNext()){
	    String columnName = in.next().replaceAll(REGEX , "");
	    System.out.printf("%d. %s\n", this.numOfColumns++, columnName);
	}

	in.close();
    }

    public static void usage(){
	System.out.println("Usage: java CSVFilter inFile outFile");
    }

    public void retrieveColumnsToBeFiltered(){
	boolean done = false;
	int i = 0;
        int colSize = numsOfColsToFilter();

	while(colsToBeFiltered.size() < colSize){
	    System.out.printf("Column %d: ",i);
	    if(console.hasNextInt()){
		int input = console.nextInt();
		if(!(0 <= input && input < numOfColumns)){
		    System.out.println("Invalid Entry, Input is out of range!");
                }else if(arrayListContains(input)){
		    System.out.println("Invalid Entry, Input has already been selected!");
                }else{
		    colsToBeFiltered.add(input);
		    i++;
                }
	    }else{
		console.next();
		System.out.println("Invalid Entry, input is not an int!");
	    }
	}
    }

    public void printOutputFile(){
        while(fileReader.hasNextLine()){
	    Scanner reader = new Scanner(fileReader.nextLine());
	    String[] row = new String[numOfColumns];
	    
	    int i = 0;
	    while(reader.hasNext() && i < row.length){
		row[i++] = reader.next();
	    }

	    for(int j = 0; j < colsToBeFiltered.size(); j++){
		int column = colsToBeFiltered.get(j);
		fileWriter.print(row[column] + " ");
	    }

	    fileWriter.print("\n");
        }
    }

    public void closeResources(){
	if(console != null){ console.close(); }	

        if(fileReader != null){ fileReader.close(); }

	if(fileWriter != null){ fileWriter.close(); }
    }

    private boolean arrayListContains(int key){
	boolean contains = false;

	for(int i : colsToBeFiltered){
	    if(i == key){ contains = true;}
	}

	return contains;
    }

    /** this method returns how many columns the user wants filtered from the csv sheet
	@return colsToBeFiltered holds the amount of columns to be filtered
    */
    private int numsOfColsToFilter(){
	int colsToBeFiltered = 0;
	boolean done = false;	

	while(!done){
	    System.out.print("Number of columns to be filtered: ");
	    if(console.hasNextInt()){
		colsToBeFiltered = console.nextInt();
		if(0 < colsToBeFiltered && colsToBeFiltered <= numOfColumns){
		    done = true;
		}else{ System.out.printf("Must select a value between 0 - %d\n", numOfColumns); }
	    }else{
		console.next();
		System.out.printf("Must select a value between 0 - %d\n", numOfColumns);
	    }
	}
	
	return colsToBeFiltered;
    }
}