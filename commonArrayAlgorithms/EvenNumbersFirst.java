import java.util.Arrays;

public class EvenNumbersFirst{
    public static void main(String[] args){
	final int ARRAY_SIZE = 10;
	final int BOUND = 100;
	int[] array = new int[ARRAY_SIZE];

	for(int i = 0; i < ARRAY_SIZE; i++){
	    array[i] = (int)(Math.random() * BOUND);
	}
	
	System.out.println(Arrays.toString(array));

	int i = 0;
	int j = 0;

	while(i < ARRAY_SIZE){
	    if(array[i] % 2 != 0){
		i++;
	    }else{
		int temp = array[i];
	   	array[i++] = array[j];
	    	array[j++] = temp; 
	    }   
	}

	System.out.println(Arrays.toString(array));
    }
}