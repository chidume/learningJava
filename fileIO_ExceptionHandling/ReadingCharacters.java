import java.util.Scanner;

public class ReadingCharacters{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
	in.useDelimiter("");
	boolean done =  false;

	while(in.hasNext()){
	    char c = in.next().charAt(0);
	    System.out.print(c); 
	}

    }
}