import java.util.Arrays;
import java.util.Scanner;

public class InsertAnElement{
    public static void main(String[] args){
	int position = 0;
	double element = 0;
	boolean done = false;
	final int SIZE = 10;
	final int UPPERBOUND = 100;
        double[] array = new double[SIZE];
	int currentSize = (int)(Math.random() * SIZE); 
	Scanner in = new Scanner(System.in);

	System.out.println("The array has " + SIZE + " indices");

	System.out.println("The currentSize is " + currentSize);
	
	for(int i = 0; i < currentSize; i++){
	    array[i] = Math.random() * UPPERBOUND;
	}

	System.out.println(Arrays.toString(array));

	do{
	    System.out.print("Element to be inserted: ");
	    if(in.hasNextDouble()){
		element = in.nextDouble();
		done = true;
	    }else{
		in.next();
	    }
	}while(!done);

	done = false;
	do{
	    System.out.print("Position to be inserted (0-" + currentSize + "): ");
	    if(in.hasNextInt()){
		if((position = in.nextInt()) > -1 && position < currentSize){
		    done = true;
                }
	    }else{
	        in.next();
	    }
	}while(!done);

	if(currentSize < SIZE){
	    for(int i = currentSize; i > position ; i--){
		array[i] = array[i - 1];
	    }
	    array[position] = element;
	}else{
	    System.out.println("ERROR, full array!");
	}

	System.out.println(Arrays.toString(array));
    }
}