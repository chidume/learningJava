import java.util.Arrays;
import java.util.Scanner;

public class RemovingAnElement{
    /** 
	given a scanner and array size, 
        accepts valid input between 0 - currentSize
    */
    public static int validateIndex(Scanner in, int currentSize){
	int pos = 0;
	boolean done = false;

	do{
	    System.out.print("Choose index (0 - " + (currentSize-1) + "): ");
	    if(in.hasNextInt()){
	        if((pos = in.nextInt()) > -1 && pos < currentSize){
		    done = true; 
		}
	    }else{
		in.next();
	    }
	}while(!done);

	return pos;
    }
	
    /**
	accepts a scanner and returns Y/N
	for yes or no
    */
    public static String isSorted(Scanner in){
	boolean done = false;
	String response = "";

	do{
	    System.out.print("Treat the array as ordered (Y or N)?");
	    if(in.hasNext("[YyNn]")){
	        response = in.next();
		done = true;
	    }else{
		in.next();
	    }
	}while(!done);
	
	return response;
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
        int[] array = {2, 4, 6, 8, 10, 12};
	int currentSize = array.length;

	System.out.println("Current size: " + currentSize);
	System.out.println(Arrays.toString(array));
	
	int pos = validateIndex(in, currentSize);
	String response = isSorted(in);

	if(response.toLowerCase().equals("n")){
	    array[pos] = array[currentSize - 1];
	    currentSize--;
	}else{
	    for(int i = pos; i < currentSize - 1; i++){
		array[i] = array[i+1];
	    }
	    currentSize--;
	}

	System.out.println("Current size: " + currentSize);
	for(int i = 0; i < currentSize; i++){
	    if(i > 0){ System.out.print(" | ");}
	    System.out.print(array[i]);
	}
	
    }
}