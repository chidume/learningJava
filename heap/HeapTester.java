public class HeapTester{
    public static void main(String[] args){

	//int[] array = {5, 3, 17, 10, 84, 19, 6, 22, 9};
	Heap h = new MaxHeap();

	System.out.println(h.toString());

	h.insert(5);
	h.insert(3);
	h.insert(17);
	h.insert(10);
	h.insert(84);
	h.insert(19);
	h.insert(6);
	h.insert(22);
	h.insert(9);

	System.out.println(h.toString());
    }
}