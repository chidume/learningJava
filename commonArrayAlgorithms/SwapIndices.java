import java.util.Arrays;
import java.util.Scanner;

public class SwapIndices{
    public static void main(String[] args){
        final int SIZE = 10;
	final int BOUND= 100;
	double[] array = new double[SIZE];
	boolean done = false;
	int index = 0;
	int index1 = 0;
	Scanner in = new Scanner(System.in);

	for(int i = 0; i < SIZE; i++){
	    array[i] = Math.random() * BOUND;
	}

	System.out.println(Arrays.toString(array));

	do{
	    System.out.print("Index 1,(0-9): ");
	    if(in.hasNextInt()){
		if((index = in.nextInt()) > -1 && index < SIZE){
		    done = true;
		}
	    }else{
		in.next();
	    }
	}while(!done);

	done = false;
	do{
	    System.out.print("Index 2,(0-9): ");
	    if(in.hasNextInt()){
		if((index1 = in.nextInt()) > -1 && index < SIZE){
		    done = true;
		}
	    }else{
		in.next();
	    }
	}while(!done);

	double temp = array[index];
	array[index] = array[index1];
	array[index1] = temp;

	System.out.println(Arrays.toString(array));
    }
}