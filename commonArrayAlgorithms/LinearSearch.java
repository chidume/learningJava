public class LinearSearch{
    public static void main(String[] args){
        final int SIZE = 10;
	double[] array = new double[SIZE];
	double key = Math.random() * 50;
	int keyLocation = (int)	(Math.random() * (array.length + 1));
	System.out.println("The value of the key is " + key);

	for(int i = 0; i < array.length; i++){
	    array[i] = Math.random() * 100;
	}

	array[keyLocation] = key;
	FindMax.printArray(array);
	System.out.println("key " + key + " was inserted into index " + keyLocation);

	for(int i = 0;i < array.length; i++ ){
	    if(array[i] == key){
		System.out.println("The key, " + key + " was found at index " + i);
	    }
	}
    }
}