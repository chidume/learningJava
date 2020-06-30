import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/*
    Writes string input from user to an output file
*/

public class WritingToFile{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);

	System.out.print("Output File: ");
	String outputFileName = in.next();

	PrintWriter out = new PrintWriter(outputFileName);

	System.out.print("Enter a sentence, ! to quit: ");
	while(in.hasNext()){
	    String next = in.next();
	    if(next.equals("!")){
                break;
	    }else{
                out.print(next + " ");
            }
	}

	out.close();
    }
}