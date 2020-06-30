import java.util.Arrays;

public class SwapArrayHalves{
    public static void main(String[] args){
	final int ARRAY_SIZE = 5;
	final int BOUND = 100;
	double[] array = new double[ARRAY_SIZE];

	for(int i = 0; i < ARRAY_SIZE; i++){
	    array[i] = Math.random() * BOUND;
	}
	
	System.out.println(Arrays.toString(array));

	int i = 0;
	int j = (int)Math.ceil(ARRAY_SIZE / 2.0);
	int numOfSwaps = ARRAY_SIZE / 2;

	while(i < numOfSwaps){
	    double temp = array[i];
	    array[i++] = array[j];
	    array[j++] = temp;    
	}

	System.out.println(Arrays.toString(array));
    }
}