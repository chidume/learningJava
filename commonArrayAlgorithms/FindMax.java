public class FindMax{
    public static void main(String[] args){
	final int SIZE = 10;
	double[] array = new double[SIZE];

	for(int i = 0;i < array.length; i++){
	    array[i] = Math.random()*100;
	}
	
	double max = array[0];
	printArray(array);

	for(int i = 0; i < array.length; i++){
	    if(array[i] > max){
		max = array[i];
	    }
	}	

	System.out.println("The max value is " + max);
    }

    public static void printArray(double[] array){
	for(int i = 0; i < array.length;i++){
	    if(i > 0){
		System.out.print(" | ");
	    }
	    System.out.print(array[i]);
        }
	
        System.out.println();
    }
}