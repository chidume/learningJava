import java.util.ArrayList;
import java.util.Scanner;

/*
    Reads user input, stores them in an ArrayList,
    then prints them out while marking the largest 
*/

public class LargestInArrayList{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	ArrayList<Integer> list = new ArrayList<Integer>();
	boolean done = false;
	int input;
	int largestIndex = 0;
	int largestVal = Integer.MIN_VALUE;
	String string = "";
	int i = 0;

	System.out.println("Please enter values, Q to quit: ");
	do{
	    if(in.hasNextInt()){
		input = in.nextInt();
		list.add(input);
		if(input > largestVal){
		    largestVal = input;
		    largestIndex = i;
		}
		i++;
	    }else if(in.hasNext()){
		string = in.next();
		if(string.equals("Q".toLowerCase())){
		    done = true;
		}
	    }else{
		in.next();
	    }
	}while(!done);
	
	System.out.println("-------------------------------------"); 

	for(int j = 0; j < list.size(); j++){
	    System.out.print(list.get(j));
	    if(j == largestIndex){
		System.out.print(" <=== largest value");
	    }
	    System.out.println();
	}
    }
}