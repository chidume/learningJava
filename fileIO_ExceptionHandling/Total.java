import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/*
    reads values from numbers.txt and outputs total
    to another file
*/

public class Total{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
	System.out.print("Input file: ");
	String inputFileName = in.next();
	System.out.print("Ouput file: ");
	String outputFileName = in.next();

	File inFile = new File(inputFileName);
	Scanner read = new Scanner(inFile);
	PrintWriter out = new PrintWriter(outputFileName);
	double total = 0;

	while(read.hasNextDouble()){
	    double value = read.nextDouble();
	    total += value;
	    out.printf("%15.2f\n", value);
	}
	
	out.printf("Total: %8.2f", total);

	read.close();
	out.close();
    }
}