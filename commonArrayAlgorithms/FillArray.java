import java.util.Random;
import java.util.Arrays;

public class FillArray{
    public static void main(String[] args){
	final int ARRAYSIZE = 10;
        int[] array = new int[ARRAYSIZE];
	Random rand = new Random();

	for(int i = 0;i < array.length; i++){
	    array[i] = rand.nextInt(10);
	}

	System.out.println(Arrays.toString(array));
    }
}