/**
    implementation of Heap data structure using CLRS
*/
public class MaxHeap implements Heap{
    public static final int DEFAULT_HEAP_SIZE = 10;

    private int[] heap;
    private int heapSize;

    public MaxHeap(){
	heap = new int[DEFAULT_HEAP_SIZE];
	heapSize = 0;
    } 

    public MaxHeap(int[] array, int heapSize){
        heap = array;
	this.heapSize = heapSize;
    }

    public int getHeapSize(){
	return heapSize;
    }

    /**
	calculates and returns the index of the parent 
    */
    public int parent(int child){
	return (child - 1) / 2;
    }

    /**
	calculates and returns the index of the left child 
    */
    public int leftChild(int parent){
	return 2 * parent + 1;
    }

    /**
	calculates and returns the index of the right child 
    */
    public int rightChild(int parent){
	return 2 * parent + 2;
    }

    /**
    	maintains max heap property for subtree at index i
	assuming its subtrees are max heaps
    */
    public void heapify(int parent){
	int leftChild = leftChild(parent);
	int rightChild = rightChild(parent);
	int largest = parent;

	if(leftChild < heapSize && heap[leftChild] > heap[largest]){
	    largest = leftChild;
	}

	if(rightChild < heapSize && heap[rightChild] > heap[largest]){
	    largest = rightChild;
	}

	if(largest != parent){
	    exchange(parent, largest);
	    heapify(largest);
	}
    }

    /**
	builds a max heap from elements heapSize / 2 down to 0
    */
    public void buildHeap(){
	int i = heapSize / 2 - 1;

	for(; i >= 0; i--){
	    heapify(i);
	}
    }

    /**
	inserts a key into the heap
    */
    public void insert(int key){
	heapSize++;
	heap[heapSize - 1] = Integer.MIN_VALUE;
	increaseKey(heapSize - 1, key);
    }

    /**
	deletes node from the heap
    */
    public void delete(int node){
	if(heap[node] < heap[heapSize - 1]){
	    increaseKey(node, heap[heapSize - 1]);
	}else{
	    heap[node] = heap[heapSize - 1];
	    heapify(node);
	}

	heap[heapSize - 1] = Integer.MIN_VALUE;
	heapSize--;
    }

    /**
	sorts the heap using heapsort
    */
    public void sort(){
	buildHeap();

	int i = heapSize - 1;	//initializes i to the last node heap
	while(i > 0){
	    exchange(0, i);
	    heapSize--;		//discards node i from the heap;
	    i--;		//update the position of node i
	    heapify(0);
	}
    }

    public String toString(){
	String result = "";

	for(int i = 0; i < heap.length; i++){
	    result += heap[i] + " ";
	}

	return result;
    }

    /**
	increases the element stored in i to key
    */
    private void increaseKey(int i, int key){
	if(heap[i] > key){
	    System.out.println("new key is smaller than current key!");
	}

	int j = i;
	while(j > 0 && heap[parent(j)] < key){
	    heap[j] = heap[parent(j)];
	    j = parent(j);
	}

	heap[j] = key;
    }

    /**
	Swaps 2 elements within the heap
    */
    private void exchange(int value, int value1){
	int temp = heap[value];
	heap[value] = heap[value1];
	heap[value1] = temp;
    }
    
}