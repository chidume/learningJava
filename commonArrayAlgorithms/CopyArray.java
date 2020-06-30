import java.util.Arrays;

public class CopyArray{
    public static void main(String[] args){
	final int SIZE = 5;
	final int BOUND = 100;
	double[] array = new double[SIZE];
	
	for(int i = 0; i < array.length; i++){
	    array[i] = Math.random() * BOUND;
	}
	
	System.out.println(Arrays.toString(array));

	array = Arrays.copyOf(array, SIZE * 2);

	System.out.println(Arrays.toString(array));
    }
}