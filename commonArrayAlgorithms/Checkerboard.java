public class Checkerboard{
    public static void main(String[] args){
	final int ARRAY_SIZE = 8;
	int[][] array = new int[ARRAY_SIZE][ARRAY_SIZE];

	for(int i = 0; i < array.length; i++){
	    for(int j = 0; j < array[0].length; j++){
		if((i + j) % 2 != 0)
		    array[i][j] = 1;
	    }
	}

	NeighborSum.printArray(array);
    }
}