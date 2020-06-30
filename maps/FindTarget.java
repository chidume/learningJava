import java.util.Map;
import java.util.HashMap;

/**
    Given an array of integers, return indices of the two numbers
    such that they add up to a specific target.
*/
public class FindTarget{

    public static void main(String[] args){
	int target = 17;
        int[] arr = {2, 7, 9, 15};

	// maps elements to indices
 	Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	for(int i = 0; i < arr.length; i++){
	    int complement = target - arr[i];
	    if(m.keySet().contains(complement)){
		System.out.println("index: " + m.get(complement) 
		    + " and " + "index " + i);
	    }else{
		m.put(arr[i], i);
            }	
        }
    }
}