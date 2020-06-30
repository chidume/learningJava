import java.util.ArrayList;
import java.util.Scanner;

/*
    creates and arraylist of size 10 and initializes it with
    random values then prompts user for an index to be printed
*/

public class GetAnElement{
    public static void main(String[] args){
	final int BOUND = 100;
	final int SAMPLESIZE = 10;
    	ArrayList<Integer> list = new ArrayList<Integer>();
	Scanner in = new Scanner(System.in);

	for(int i = 0; i < SAMPLESIZE; i++){
	    int value = (int)(Math.random()*BOUND);
	    list.add(value);
	}

	System.out.println(list);
	boolean done = false;
	String string = "";
	int input = 0;

	do{
	    System.out.printf("Choose an element to display (0 - %d) OR q to quit: ", (list.size() - 1));
	    if(in.hasNextInt()){
		input = in.nextInt();
		if(input >= 0 && input < list.size()){
		    System.out.println(list.get(input));
		}
	    }else if(in.hasNext()){
		string = in.next();
		if(string.equals("Q".toLowerCase())){
		    done = true;
		}
	    }else{
	        in.next();
	    }
	}while(!done);

    }
}