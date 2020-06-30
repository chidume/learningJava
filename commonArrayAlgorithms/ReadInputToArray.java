import java.util.Scanner;
import java.util.Arrays;

public class ReadInputToArray{
    public static int[] readInputToArray(){
        Scanner in = new Scanner(System.in);
	boolean done = false;
	int numOfElements = 0;

	do{
	    System.out.print("How many values will be entered? ");
	    if(in.hasNextInt()){
		numOfElements = in.nextInt();
		done = true;
	    }else{
		in.next();
	    }
	}while(!done);

	done = false;
	int[] array = new int[numOfElements];
	
	for(int i = 0; i < numOfElements; i++){
            do{
		System.out.print("value " + i + ": ");
		if(in.hasNextInt()){
		    array[i] = in.nextInt();
		    done = true;
		}else{
		    in.next();
		}
            }while(!done);
	    done = false;
	}

	return array;
    }
	
    public static void main(String[] args){
	int[] array = readInputToArray();
	System.out.println(Arrays.toString(array));
    }
}