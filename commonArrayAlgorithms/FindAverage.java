import java.util.Arrays;

public class FindAverage{
    public static void main(String[] args){
	final int SIZE = (int)(Math.random() * 20);
	System.out.println("The array size is " + SIZE);
	System.out.println("-------------------------");

        double[] array = new double[SIZE];
	double sum = 0;
	int count = 0;

	for(int i = 0; i < array.length; i++){
	    array[i] = Math.random()*100;
	}
	System.out.println(Arrays.toString(array));
	System.out.println("--------------------------");

	for(double element: array){
	    sum = sum + element;
	    System.out.println("The sum thus far is " + sum);
	    count++;
	    System.out.println("The count thus far is " + count);
	    System.out.println("------------------------------");
	}

	if(count > 0){
	    System.out.println("The average is " + sum/count);
	}else{
	    System.out.println("The array had a length of 0, hence no average");
	}
    }
}