import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class CSVTester{ 

    public static void main(String[] args){
	if(args.length != 2){ 
	    CSVFilter.usage();
	    return;
	}

	String inFile = args[0];
	String outFile = args[1];
	
	try{
	    CSVFilter filter = new CSVFilter(inFile, outFile);
	    try{
		filter.printColumnHeader();
	        filter.retrieveColumnsToBeFiltered();
		filter.printOutputFile();
	    }finally{
		filter.closeResources();
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found!");
	}catch(NoSuchElementException e){
	    System.out.println("File contents invalid");
	}
    }
}