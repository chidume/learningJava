import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
	final int SIZE = 10;
	final int BOUND = 100;
	boolean done = false;
	int[] array = new int[SIZE];
	int key = 0;
	Scanner in = new Scanner(System.in);

	for(int i = 0; i < SIZE; i++){
	    array[i] = (int)(Math.random() * BOUND);
	}
	
	Arrays.sort(array);
	System.out.println(Arrays.toString(array));

	do{
	    System.out.print("value to be searched: ");
	    if(!in.hasNextInt()){
		in.next();
	    }else{
		key = in.nextInt();
		done = true;
	    }
	}while(!done);

	System.out.println("key value: " + key);

	boolean found = false;
	int low = 0;
	int high = SIZE - 1;
	int mid = 0;
	while(low <= high && !found){
	    mid = low + (high - low) / 2;
	    if(array[mid] == key){
	        found = true;
		System.out.println("The key was found at index " + mid);
	    }else if(key < array[mid]){
    		high = mid - 1;
		System.out.println("index high was updated to " + (mid - 1));
	    }else{
		low = mid + 1;
		System.out.println("index low was updated to " + (mid + 1));
       	    }
	}

	if(found == false){
	    System.out.println("The key is not within the array!");
	}
    }
}